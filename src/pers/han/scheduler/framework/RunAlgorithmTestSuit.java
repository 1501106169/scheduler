package pers.han.scheduler.framework;

import pers.han.scheduler.check.CheckAlgorithm;
import pers.han.scheduler.runner.ThreadTask;
import pers.han.scheduler.runner.ThreadTaskPool;
import pers.han.scheduler.scheduling.SchedulingAlgorithm;
import pers.han.scheduler.task.Task;

import java.util.Vector;

/**
 * 在多个调度任务上执行调度算法，RunAlgorithmCase的合集
 * 
 * @author		hanYG
 * @createDate	2022年9月30日
 * @alterDate	2022年9月30日
 * @version		1.0
 *
 */
public class RunAlgorithmTestSuit implements RunAlgorithm {
	
	/** 一组执行算法的实例 */
	private Vector<RunAlgorithm> algorithmSuit = new Vector<RunAlgorithm>();
	
	/** 线程池 */
	private final ThreadTaskPool pool = new ThreadTaskPool();
	
	/**
	 * 使用任务suit构造，需要后续添加调度算法和校验算法
	 * @param taskSuit 任务
	 */
	public RunAlgorithmTestSuit(final Vector<Vector<Task>> taskSuit) {
		for (Vector<Task> taskSet : taskSuit) {
			this.algorithmSuit.add(new RunAlgorithmTestCase(taskSet));
		}
	}
	
	/**
	 * 构造函数
	 * @param taskSuit 任务
	 * @param schedulingAlgorithm 调度算法
	 * @param checkAlgorithm 校验算法
	 */
	public RunAlgorithmTestSuit(final Vector<Vector<Task>> taskSuit, final SchedulingAlgorithm schedulingAlgorithm, final CheckAlgorithm checkAlgorithm) {
		// this.algorithmSuit = new Vector<RunAlgorithm>();
		for (Vector<Task> taskSet : taskSuit) {
			this.algorithmSuit.add(new RunAlgorithmTestCase(taskSet, schedulingAlgorithm, checkAlgorithm));
		}
	}

	/**
	 * 添加执行算法实例任务
	 * @param algorithm 执行算法实例
	 */
	public void addAlgorithmCase(RunAlgorithm algorithm) {
		this.pool.execute(new ThreadTask(algorithm));
		this.algorithmSuit.add(algorithm);
	}
	
	@Override
	public void setSchedulingAlgorithm(SchedulingAlgorithm schedulingAlgorithm) {
		for (RunAlgorithm algorithm : this.algorithmSuit) {
			algorithm.setSchedulingAlgorithm(schedulingAlgorithm);
		}
	}

	@Override
	public void setCheckAlgorithm(CheckAlgorithm checkAlgorithm) {
		for (RunAlgorithm algorithm : this.algorithmSuit) {
			algorithm.setCheckAlgorithm(checkAlgorithm);
		}
	}

	@Override
	public void run() {
		for (RunAlgorithm algorithm : this.algorithmSuit) {
			this.pool.execute(new ThreadTask(algorithm));
		}
	}

	@Override
	public void runSchedulingAlgorithm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runCheckAlgorithm() {
		// TODO Auto-generated method stub
		
	}

}
