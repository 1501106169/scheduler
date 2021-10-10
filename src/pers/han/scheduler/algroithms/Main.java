package pers.han.scheduler.algroithms;

import pers.han.scheduler.task.*;
import pers.han.scheduler.framework.*;
import java.util.ArrayList;
// import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(8);
		System.out.println(numeric.leastCommonMultiple(list));
		
		// 按照 periodicTaskList 给任务排序，即任务编号
		ArrayList<PeriodicTask> periodicTaskList = new ArrayList<PeriodicTask>();
		periodicTaskList.add(new PeriodicTask(40, 10));
		periodicTaskList.add(new PeriodicTask(50, 18));
		periodicTaskList.add(new PeriodicTask(200, 10));
		periodicTaskList.add(new PeriodicTask(200, 20));
		
		ArrayList<TimeBlock> timeAxis = EarlistDeadlineFirst.periodicEDF(periodicTaskList);
		/*
		Iterator<TimeBlock> it = timeAxis.iterator();
		while (it.hasNext()) {
			TimeBlock block = it.next();
			System.out.print(block.getId());
			System.out.print(" ");
			System.out.print(block.getStartTime());
			System.out.print(" ");
			System.out.println(block.getExecTime());
		}
		*/

//		System.out.println(CheckAlgroithmsResult.checkPeriodicTask(periodicTaskList, timeAxis));
		
		BaseSchedulerFrame baseScheduler = new BaseSchedulerFrame();
		System.out.println(baseScheduler.getVisable());
		
	}

}
