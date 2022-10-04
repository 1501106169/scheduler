package pers.han.scheduler.runner;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池，管理线程
 * 
 * @author		hanYG
 * @createDate	2022年10月3日
 * @alterDate	2022年10月3日
 * @version		1.0
 *
 */
public class ThreadTaskPool {
	
	/** 当前线程数 */
	private final AtomicInteger threadNumber = new AtomicInteger(0);
	
	/** 核心线程数 */
	private volatile int coreThreadSize = 4;
	
	/** 最大线程数 */
	private volatile int maxThreadSize = 8;
	
	/** 阻塞队列 */
	private final BlockingQueue<Runnable> blockAlgorithmQueue;
	
	/**
	 * 无参构造
	 */
	public ThreadTaskPool() {
		// 默认阻塞队列大小为1024
		this.blockAlgorithmQueue = new ArrayBlockingQueue<Runnable>(1024);
	}
	
	/**
	 * 构造函数，指定阻塞队列的大小
	 * @param blockAlgorithmQueueSize 阻塞队列的大小
	 */
	public ThreadTaskPool(int blockAlgorithmQueueSize) {
		this.blockAlgorithmQueue = new ArrayBlockingQueue<Runnable>(blockAlgorithmQueueSize);
	}
	
	/**
	 * 构造函数，设置核心线程数、最大线程数和阻塞队列大小
	 * @param coreThreadSize 核心线程数
	 * @param maxThreadSize 最大线程数
	 * @param blockAlgorithmQueueSize 阻塞队列大小
	 */
	public ThreadTaskPool(int coreThreadSize, int maxThreadSize, int blockAlgorithmQueueSize) {
		this.coreThreadSize = coreThreadSize;
		this.maxThreadSize = maxThreadSize;
		this.blockAlgorithmQueue = new ArrayBlockingQueue<Runnable>(blockAlgorithmQueueSize);
	}
	
	/**
	 * 执行任务，创建线程
	 * @param task Runnable实例
	 */
	public void execute(Runnable task) {
		if (this.threadNumber.get() < this.coreThreadSize) {
			if (!this.addWorker(task)) {
				this.reject();
			}
			return;
		}
		// 任务添加到阻塞队列
		if (!this.blockAlgorithmQueue.offer(task)) {
			if (!this.addWorker(task)) {
				this.reject();
			}
		}
	}
	
	/**
	 * 阻塞队列满时，拒绝
	 */
	private void reject() {
		throw new RuntimeException("can not execute! now size: " + this.threadNumber.get()
										+ "; Queue size: " + this.blockAlgorithmQueue.size());
	}
	
	/**
	 * 添加任务到线程池
	 * @param task 任务，TjreadTask
	 * @return Boolean
	 */
	private boolean addWorker(Runnable task) {
		if (this.threadNumber.get() >= this.maxThreadSize) {
			return false;
		}
		ThreadTaskWorker worker = new ThreadTaskWorker(task);
		worker.thread.start();
		this.threadNumber.incrementAndGet();
		return true;
	}
	
	/**
	 * 线程池中工作者线程
	 * 
	 * @author		hanYG
	 * @createDate	2022年10月4日
	 * @alterDate	2022年10月4日
	 * @version		1.0
	 *
	 */
	public class ThreadTaskWorker implements Runnable {
		
		/** 线程实例 */
		final Thread thread;
		
		/** 线程第一个任务 */
		Runnable firstTask;
		
		/**
		 * 构造函数，使用ThreadTask构造
		 * @param firstTask Runnable实例
		 */
		public ThreadTaskWorker(Runnable firstTask) {
			this.firstTask = firstTask;
			this.thread = new Thread(firstTask);
		}
		
		@Override
		public void run() {
			Runnable task = this.firstTask;
			try {
				while (task != null || (task = this.getTask()) != null) {
					task.run();
					if (threadNumber.get() > maxThreadSize) {
						break;
					}
					task = null;
				}
			} finally {
				// 线程数量减少
				threadNumber.decrementAndGet();
			}
		}
		
		/**
		 * 从阻塞队列中获取任务
		 * @return 任务
		 */
		private Runnable getTask() {
			while (true) {
				try {
					System.out.println("blockAlgorithmQueue: " + blockAlgorithmQueue.size());
					return blockAlgorithmQueue.take();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		

	}
	
	
}
