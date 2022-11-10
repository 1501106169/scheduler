package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.algroithms.Numeric;
import pers.han.scheduler.algroithms.Tools;
import pers.han.scheduler.check.CheckAlgorithm;
import pers.han.scheduler.check.EDFCheckAlgorithm;
import pers.han.scheduler.check.LSTCheckAlgorithm;
import pers.han.scheduler.check.PerformanceTest;
import pers.han.scheduler.check.PeriodicCheckAlgorithm;
import pers.han.scheduler.framework.RunAlgorithm;
import pers.han.scheduler.framework.RunAlgorithmCase;
import pers.han.scheduler.io.InputTaskData;
import pers.han.scheduler.io.InputTaskDataFromFile;
import pers.han.scheduler.io.OutputForTerminal;
import pers.han.scheduler.io.OutputSchedulingResult;
import pers.han.scheduler.task.Task;

public class Test {

	public static void main(String[] args) {
		// 输入数据
		InputTaskData in = new InputTaskDataFromFile("./fileData/periodic_task");
		Vector<Vector<Task>> taskSuit = in.getTaskData();

		// 执行算法
		RunAlgorithm algorithmCase = new RunAlgorithmCase(taskSuit.get(0), Tools.hyperperiod((taskSuit.get(0))));
		// 设置调度算法和校验算法
		SchedulingAlgorithm schedulingAlgorithm = new LSTSchedulingAlgorithm();
		CheckAlgorithm checkAlgorithm = new LSTCheckAlgorithm();
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
