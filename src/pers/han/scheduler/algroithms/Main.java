package pers.han.scheduler.algroithms;

import pers.han.scheduler.task.*;
import pers.han.scheduler.io.*;
// import pers.han.scheduler.framework.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		// 按照 periodicTaskList 给任务排序，即任务编号
		ArrayList<PeriodicTask> periodicTaskList = new ArrayList<PeriodicTask>();
		periodicTaskList.add(new PeriodicTask(40, 10));
		periodicTaskList.add(new PeriodicTask(50, 18));
		periodicTaskList.add(new PeriodicTask(200, 10));
		periodicTaskList.add(new PeriodicTask(200, 20));

		ArrayList<TimeBlock> timeAxis = EarlistDeadlineFirst.periodicEDF(periodicTaskList);
		
		System.out.print("该算法调度结果为：");
		// 调度结果校验
		System.out.println(CheckAlgroithmsResult.checkPeriodicTask(periodicTaskList, timeAxis));
		
		Iterator<TimeBlock> it = timeAxis.iterator();
		while (it.hasNext()) {
			TimeBlock block = it.next();
			System.out.print(block.getId());
			System.out.print(" ");
			System.out.print(block.getStartTime());
			System.out.print(" ");
			System.out.println(block.getExecTime());
		}
		
		// BaseSchedulerFrame baseScheduler = new BaseSchedulerFrame();
		// System.out.println(baseScheduler.getVisable());
		
		 
		new OutputWindow(timeAxis);
		
		// System.exit(0);
	}

}
