package pers.han.scheduler.runner;

import java.util.Vector;

import pers.han.scheduler.framework.RunAlgorithm;
import pers.han.scheduler.framework.RunAlgorithmCase;
import pers.han.scheduler.io.*;
import pers.han.scheduler.task.*;
import pers.han.scheduler.scheduling.*;
import pers.han.scheduler.check.*;

public class Runner {

	public static void main(String[] args) {
		// 输入
		InputTaskData in = new InputTaskDataFromFile("./fileData/periodic_task");
		Vector<Vector<Task>> taskSuit = in.getTaskData();
		
		// 执行算法
		RunAlgorithm algorithmCase = new RunAlgorithmCase(taskSuit.get(0), 200);
		
		// 设置调度算法和校验算法
//		SchedulingAlgorithm schedulingAlgorithm = new PeriodicSchedulingAlgorithm();
		SchedulingAlgorithm schedulingAlgorithm = new PeriodicLIFOSchedulingAlgorithmEx();
		CheckAlgorithm checkAlgorithm = new PeriodicCheckAlgorithm();
		algorithmCase.setSchedulingAlgorithm(schedulingAlgorithm);
		algorithmCase.setCheckAlgorithm(checkAlgorithm);
		
		// 执行调度算法
		algorithmCase.runSchedulingAlgorithm();
		// 执行校验算法
		algorithmCase.runCheckAlgorithm();
		
		// 计算调度算法性能
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
