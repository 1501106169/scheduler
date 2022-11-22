package pers.han.scheduler.runner;

import java.util.Vector;

import pers.han.scheduler.check.CheckAlgorithm;
import pers.han.scheduler.check.CheckAlgorithmPreemptable;
import pers.han.scheduler.framework.RunAlgorithm;
import pers.han.scheduler.framework.RunAlgorithmTestSuit;
import pers.han.scheduler.io.InputTasksets;
import pers.han.scheduler.io.InputTasksetsFromFile;
import pers.han.scheduler.io.OutputForTerminal;
import pers.han.scheduler.scheduling.EDFSchedulingAlgorithmPreemptbale;
import pers.han.scheduler.scheduling.SchedulingAlgorithm;
import pers.han.scheduler.task.Task;

public class Test {
	
	public static void main(String[] args) {
		// 输入数据
		InputTasksets in = new InputTasksetsFromFile("./fileData/periodic_task");
		Vector<Vector<Task>> taskSuit = in.getTaskData();
		// 调度算法
		SchedulingAlgorithm schedulingAlgorithm = new EDFSchedulingAlgorithmPreemptbale();
		// 校验算法
		CheckAlgorithm checkAlgorithm = new CheckAlgorithmPreemptable();
		RunAlgorithmTestSuit suit = new RunAlgorithmTestSuit(taskSuit, schedulingAlgorithm, checkAlgorithm);
		// suit.addAlgorithmCase(null);
		suit.run();
		// 等待线程执行完成
		
//		for (RunAlgorithm algorithm : suit.getAlgorithmsSuit()) {
//			new OutputForTerminal(algorithm).outSchedulingResult();
//			System.out.println();
//		}
		
	}

}
