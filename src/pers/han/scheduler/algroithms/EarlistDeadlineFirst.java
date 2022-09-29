package pers.han.scheduler.algroithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
// import java.util.Queue;

import pers.han.scheduler.task.*;

// 弃用

/**
 * 最早时限优先算法 
 * FileName: EarlistDeadlineFirst.java
 * 
 * @author		hanYG
 * @createDate	2021.06.18
 * @alterDate	2021.10.11
 * @version		1.0
 *
 */
public class EarlistDeadlineFirst {
	
	private EarlistDeadlineFirst() {
		
	}
	
	/**
	 * 基于EDF的周期性任务调度算法，最小时限最短执行时间优先
	 * @param periodicTaskList	周期性任务数组
	 * @return ArrayList<TimeBlock> 时间轴，每段时间内执行的任务
	 */
	public static ArrayList<TimeBlock> periodicEDF(ArrayList<PeriodicTask> periodicTaskList) {
		// 任务执行的时间段
		ArrayList<TimeBlock> timeAxis = new ArrayList<TimeBlock>();
		
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
		for (PeriodicTask periodicTask : periodicTaskList) {
			nextStopTaskTime.add(new TimeSpan(periodicTask));
		}
		
		while (axis < hyperperiod) {
			// 当未到任务释放时间，任务不可执行
			int leastTaskIndex = getLeastDeadlineIndex(nextStopTaskTime, axis);
			if (leastTaskIndex == -1) {
				leastTaskIndex = getLeastStartTimeIndex(nextStopTaskTime);
				axis = nextStopTaskTime.get(leastTaskIndex).getStartTime();
			}
			if (axis >= hyperperiod) {
				break;
			}
			timeAxis.add(new TimeBlock(leastTaskIndex, axis, nextStopTaskTime.get(leastTaskIndex).getExecTime()));
			axis += nextStopTaskTime.get(leastTaskIndex).getExecTime();
			nextStopTaskTime.get(leastTaskIndex).nextPeriodic();
		}
		return timeAxis;
	}
	
	/**
	 * 获取一组周期任务的超周期
	 * @param periodicTaskList	一组周期性任务
	 * @return Integer
	 */
	private static int getHyperperiod(ArrayList<PeriodicTask> periodicTaskList) {
		ArrayList<Integer> digitalList = new ArrayList<Integer>();
		for (PeriodicTask periodicTask : periodicTaskList) {
			digitalList.add(periodicTask.getTaskPeriodic());
		}
		return Numeric.leastCommonMultiple(digitalList);
	}
	
	/**
	 * 获取一组周期任务中在释放时间之后的最小时限最短任务的索引
	 * @param timeSpanList	一组周期性任务的下一个执行阶段
	 * @param axis	当前时间轴时间
	 * @return	Integer
	 */
	private static int getLeastDeadlineIndex(ArrayList<TimeSpan> timeSpanList, int axis) {
		int leastDeadlineIndex = -1;
		for (int index = 0; index < timeSpanList.size(); ++index) {
			if (timeSpanList.get(index).getStartTime() > axis) {
				continue;
			}
			if (leastDeadlineIndex == -1) {
				leastDeadlineIndex = index;
			}else if (timeSpanList.get(leastDeadlineIndex).getEndTime() > timeSpanList.get(index).getEndTime()) {
				leastDeadlineIndex = index;
			} else if (timeSpanList.get(leastDeadlineIndex).getEndTime() == timeSpanList.get(index).getEndTime()) {
				leastDeadlineIndex = timeSpanList.get(leastDeadlineIndex).getExecTime() > timeSpanList.get(index).getExecTime() ? index : leastDeadlineIndex; 
			}
		}
		return leastDeadlineIndex;
	}
	
	/**
	 * 获取释放时间最小的任务索引
	 * @param timeSpanList	一组周期性任务的下一个执行阶段
	 * @return	Integer
	 */
	private static int getLeastStartTimeIndex(ArrayList<TimeSpan> timeSpanList) {
		int leastStartTimeIndex = 0;
		for (int index = 1; index < timeSpanList.size(); ++index) {
			if (timeSpanList.get(index).getStartTime() < timeSpanList.get(leastStartTimeIndex).getStartTime()) {
				leastStartTimeIndex = index;
			}
		}
		return leastStartTimeIndex;
	}
	
}
