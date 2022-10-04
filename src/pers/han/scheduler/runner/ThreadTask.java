package pers.han.scheduler.runner;

import pers.han.scheduler.check.PerformanceTest;
import pers.han.scheduler.framework.RunAlgorithm;
import pers.han.scheduler.io.OutputForTerminal;
import pers.han.scheduler.io.OutputSchedulingResult;

/**
 * 在一组任务上执行调度算法和校验算法的线程
 * 
 * @author		hanYG
 * @createDate	2022年10月3日
 * @alterDate	2022年10月3日
 * @version		1.0
 *
 */
public class ThreadTask implements Runnable {
	
	/** 在一组任务上执行调度算法的实例 */
	RunAlgorithm algorithmCase;

	/**
	 * 构造函数
	 * @param algorithmCase	执行调度算法的实例
	 */
	public ThreadTask(RunAlgorithm algorithmCase) {
		this.algorithmCase = algorithmCase;
		return;
	}
	
	@Override
	public void run() {
		// 执行调度算法和校验算法
		this.algorithmCase.run();
		
		PerformanceTest pt = new PerformanceTest(algorithmCase);
		// 计算时间利用率
		System.out.print("时间利用率: ");
		System.out.println(pt.calcTimeUtilization());
		System.out.print("作业响应时间: ");
		System.out.println(pt.calcResponseTime());
		System.out.print("作业响应时间方差: ");
		System.out.println(pt.calcVarianceResponseTime());
		
		// 输出
		OutputSchedulingResult out = new OutputForTerminal(algorithmCase);
		out.outSchedulingResult();
		
	}
	
}
