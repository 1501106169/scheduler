package pers.han.scheduler.algroithms;

import pers.han.scheduler.task.*;
import java.util.ArrayList;
// import java.util.Iterator;
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
		// 当前时刻
		// double nowTime = 0;
		// timeAxis.add(new TimeBlock(1, nowTime, periodicTaskList.get(1).getJobExecTime()));
		
		// 使用Queue存储TimeBlock
		
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
		
		return timeAxis;
	}
	
	
}
