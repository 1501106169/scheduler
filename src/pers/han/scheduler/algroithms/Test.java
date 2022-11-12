package pers.han.scheduler.algroithms;

import pers.han.scheduler.check.CheckAlgorithm;
import pers.han.scheduler.check.PeriodicCheckAlgorithm;
import pers.han.scheduler.framework.RunAlgorithmTestSuit;
import pers.han.scheduler.io.*;
import pers.han.scheduler.scheduling.PeriodicSchedulingAlgorithm;
import pers.han.scheduler.scheduling.SchedulingAlgorithm;
import pers.han.scheduler.task.*;

import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		InputTasksets in = new InputTasksetsFromFile("/usr/local/scheduler-test-data/");
		Vector<Vector<Task>> taskSuit = in.getTaskData();
		// 创建调度算法和校验算法
		SchedulingAlgorithm schedulingAlgorithm = new PeriodicSchedulingAlgorithm();
		CheckAlgorithm checkAlgorithm = new PeriodicCheckAlgorithm();
		
//		Vector<RunAlgorithmCase> algorithmSuit = new Vector<RunAlgorithmCase>();
//		// 线程池
//		ThreadTaskPool pool = new ThreadTaskPool();
		
//		for (Vector<Task> taskSet : taskSuit) {
//			RunAlgorithmCase algorithmCase = new RunAlgorithmCase(taskSet, schedulingAlgorithm, checkAlgorithm);
//			algorithmSuit.add(algorithmCase);
//			pool.execute(new ThreadTask(algorithmCase));	
//		}
		RunAlgorithmTestSuit suit = new RunAlgorithmTestSuit(taskSuit, schedulingAlgorithm, checkAlgorithm);
		suit.run();
		
	}

}
