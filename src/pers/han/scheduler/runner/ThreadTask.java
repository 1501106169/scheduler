package pers.han.scheduler.runner;

import pers.han.scheduler.framework.RunAlgorithm;
import pers.han.scheduler.framework.RunAlgorithmCase;
import pers.han.scheduler.io.OutputForTerminal;
import pers.han.scheduler.io.OutputSchedulingResult;
import pers.han.scheduler.scheduling.SchedulingAlgorithm;
import pers.han.scheduler.algroithms.Tools;
import pers.han.scheduler.check.CheckAlgorithm;
import pers.han.scheduler.check.PerformanceTest;
import pers.han.scheduler.task.*;

import java.util.Vector;

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
	RunAlgorithm algorithmCase = null;
	
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
	}

}
