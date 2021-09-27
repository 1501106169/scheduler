package pers.han.scheduler.algroithms;

import pers.han.scheduler.task.*;
import java.util.ArrayList;
// import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		// 按照 periodicTaskList 给任务排序，即任务编号
		ArrayList<PeriodicTask> periodicTaskList = new ArrayList<PeriodicTask>();
		periodicTaskList.add(new PeriodicTask(4, 1));
		periodicTaskList.add(new PeriodicTask(5, 1.8));
		periodicTaskList.add(new PeriodicTask(20, 1));
		periodicTaskList.add(new PeriodicTask(20, 2));
		
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

		System.out.println(CheckAlgroithmsResult.checkPeriodicTask(periodicTaskList, timeAxis));
		
	}

}
