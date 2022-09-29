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
		// ����
		InputTaskData in = new InputTaskDataFromFile("dirPath");
		Vector<Vector<Task>> taskSuit = in.getTaskData();
		
		// ִ���㷨
		RunAlgorithm algorithmCase = new RunAlgorithmCase(taskSuit.get(0), 200);
		
		// ���õ����㷨��У���㷨
		SchedulingAlgorithm schedulingAlgorithm = new PeriodicSchedulingAlgorithm();
		CheckAlgorithm checkAlgorithm = new PeriodicCheckAlgorithm();
		algorithmCase.setSchedulingAlgorithm(schedulingAlgorithm);
		algorithmCase.setCheckAlgorithm(checkAlgorithm);
		
		// ִ�е����㷨
		algorithmCase.runSchedulingAlgorithm();
		// ִ��У���㷨
		algorithmCase.runCheckAlgorithm();
		
		// ��������㷨����
		PerformanceTest pt = new PerformanceTest(algorithmCase);
		System.out.println(pt.calcTimeUtilization());
		
		// ���
		OutputSchedulingResult out = new OutputForTerminal(algorithmCase);
		out.outSchedulingResult();
		
		System.out.println((taskSuit.get(0).get(0).getClass() == pers.han.scheduler.task.PeriodicTask.class));
		
	}

}
