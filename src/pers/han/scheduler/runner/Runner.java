package pers.han.scheduler.runner;

import java.util.Map;
import java.util.Vector;

import pers.han.scheduler.framework.RunAlgorithm;
import pers.han.scheduler.framework.RunAlgorithmTestCase;
import pers.han.scheduler.io.*;
import pers.han.scheduler.task.*;
import pers.han.scheduler.scheduling.*;
import pers.han.scheduler.check.*;
import pers.han.scheduler.compiler.DynamicCompilerManager;

public class Runner {

	public static void main(String[] args) {
		// 输入
//		InputTaskData in = new InputTaskDataFromFile("D:\\\\eclipse\\\\workspace\\\\scheduler\\\\fileData");
		InputTasksets in = new InputTasksetsFromFile("/usr/local/scheduler-test-data/");
		Vector<Vector<Task>> taskSuit = in.getTaskData();
		if (taskSuit.size() == 0) {
			return;
		}
		// 执行算法
		RunAlgorithm algorithmCase = new RunAlgorithmTestCase(taskSuit.get(0), 200);
		
		// 设置调度算法和校验算法
//		SchedulingAlgorithm schedulingAlgorithm = new PeriodicSchedulingAlgorithm();
//		System.out.println(schedulingAlgorithm);
		DynamicCompilerManager dcm = new DynamicCompilerManager();
//		dcm.addSourceFile("D:\\eclipse\\workspace\\scheduler\\fileData\\Algorithm.java");
		dcm.addSourceDir("/usr/local/scheduler-algorithm");
		Map<String, Class<?>> classes = dcm.compile();
//		System.out.println(classes);
		Class<?> cls = classes.get("Algorithm");
//		System.out.println(cls);
		SchedulingAlgorithm schedulingAlgorithm = null;
		try {
			schedulingAlgorithm = (SchedulingAlgorithm) cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(schedulingAlgorithm);
//		return ;
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
		System.out.print("CPU USAGE: ");
		System.out.println(pt.calcTimeUtilization());
		System.out.print("AVERAGE RESPONSE TIME: ");
		System.out.println(pt.calcResponseTime());
		System.out.print("RESPONSE TIME VARIANCE: ");
		System.out.println(pt.calcVarianceResponseTime());
		
		// 输出
		OutputSchedulingResult out = new OutputForTerminal(algorithmCase);
		out.outSchedulingResult();
		
	}

}
