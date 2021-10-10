package pers.han.scheduler.algroithms;

import pers.han.scheduler.task.*;
import java.util.ArrayList;
import java.util.Iterator;
// import java.util.Queue;

/**
 * 最早时限优先算法 
 * FileName: EarlistDeadlineFirst.java
 * 
 * @author		hanYG
 * @createDate	2021.06.18
 * @alterDate	2021.06.18
 * @version		1.0
 *
 */
public class EarlistDeadlineFirst {
	
	public EarlistDeadlineFirst() {
		
	}
	
	/**
	 * 基于EDF的周期性任务调度算法
	 * @param periodicTaskList	周期性任务数组
	 * @return	ArrayList<TimeBlock> 时间轴，每段时间内执行的任务
	 */
	public static ArrayList<TimeBlock> periodicEDF(ArrayList<PeriodicTask> periodicTaskList) {
		// 任务执行的时间段
		ArrayList<TimeBlock> timeAxis = new ArrayList<TimeBlock>();
		
		// timeAxis.add(new TimeBlock(1, nowTime, periodicTaskList.get(1).getJobExecTime()));
		
		// 使用Queue存储TimeBlock
		/*
		timeAxis.add(new TimeBlock(0, 0, 10));
		timeAxis.add(new TimeBlock(1, 10, 18));
		timeAxis.add(new TimeBlock(2, 30, 10));
		timeAxis.add(new TimeBlock(0, 40, 10));
		timeAxis.add(new TimeBlock(1, 50, 18));
		timeAxis.add(new TimeBlock(3, 70, 20));
		timeAxis.add(new TimeBlock(0, 90, 10));
		timeAxis.add(new TimeBlock(1, 100, 20));
		timeAxis.add(new TimeBlock(0, 120, 10));
		timeAxis.add(new TimeBlock(1, 150, 18));
		timeAxis.add(new TimeBlock(0, 170, 10));
		*/
		
		// 时间轴
		int axis = 0;
		
		// 获得一组任务的超周期
		int hyperperiod = getHyperperiod(periodicTaskList);
		
		// 存储下一个任务执行的释放时刻、执行时间、时限
		ArrayList<TimeSpan> nextStopTaskTime = new ArrayList<TimeSpan>();
		
		// System.out.println(getHyperperiod(periodicTaskList));
		
		for (PeriodicTask periodicTask : periodicTaskList) {
			nextStopTaskTime.add(new TimeSpan(periodicTask));
		}
		
		
		
		return timeAxis;
	}
	
	
	private static int getHyperperiod(ArrayList<PeriodicTask> periodicTaskList) {
		ArrayList<Integer> digitalList = new ArrayList<Integer>();
		for (PeriodicTask periodicTask : periodicTaskList) {
			digitalList.add(periodicTask.getTaskPeriodic());
		}
		return numeric.leastCommonMultiple(digitalList);
	}
	
}
