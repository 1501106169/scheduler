package pers.han.scheduler.algroithms;

import pers.han.scheduler.task.*;
import pers.han.scheduler.io.*;
// import pers.han.scheduler.framework.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		/*
		// 按照 periodicTaskList 给任务排序，即任务编号
		ArrayList<PeriodicTask> periodicTaskList = new ArrayList<PeriodicTask>();
		periodicTaskList.add(new PeriodicTask(40, 10));
		periodicTaskList.add(new PeriodicTask(50, 18));
		periodicTaskList.add(new PeriodicTask(200, 10));
		periodicTaskList.add(new PeriodicTask(200, 20));
		
		ArrayList<TimeBlock> timeAxis = EarlistDeadlineFirst.periodicEDF(periodicTaskList);
		
		Iterator<TimeBlock> it = timeAxis.iterator();
		while (it.hasNext()) {
			TimeBlock block = it.next();
			System.out.print(block.getId());
			System.out.print(" ");
			System.out.print(block.getStartTime());
			System.out.print(" ");
			System.out.println(block.getExecTime());
		}

		 System.out.println(CheckAlgroithmsResult.checkPeriodicTask(periodicTaskList, timeAxis));
		
		// BaseSchedulerFrame baseScheduler = new BaseSchedulerFrame();
		// System.out.println(baseScheduler.getVisable());
		
		 ArrayList<Task> a = new ArrayList<Task>();
		 a.add(new PeriodicTask(1, 1));
		 a.add(new AperiodicTask());
		 
		 System.out.println(a.get(0).getClass());
		 System.out.println(a.get(1).getClass());
		 // 运行时，获取对象类型
		 a.get(0).getClass().cast(a.get(0));
		 System.out.println(a.get(0).getClass());
		 System.out.println(a.get(0).getJobDeadline());
		 */
		
		ArrayList<TimeBlock> timeAxis = new ArrayList<TimeBlock>();
		timeAxis.add(new TimeBlock(0, 0, 10));
		
		new OutputWindow(timeAxis);
		
		// System.exit(0);
	}

}
