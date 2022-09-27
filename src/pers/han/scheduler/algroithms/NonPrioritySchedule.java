package pers.han.scheduler.algroithms;

import java.util.ArrayList;

import pers.han.scheduler.task.*;

/**
 * 无优先级算法
 * FileName: NonPrioritySchedule.java
 * 
 * @author		hanYG
 * @createDate	2022.03.04
 * @alterDate	2022.03.04
 * @version		1.0
 *
 */
public class NonPrioritySchedule {
	
	private NonPrioritySchedule() { }
	
	/**
	 * FIFO调度，先就绪的任务先调度
	 * @param periodicTaskList 一组周期性任务
	 * @return ArrayList<TimeBlock> 时间轴，每段时间内执行的任务
	 */
	public static ArrayList<TimeBlock> fifoSchedule(ArrayList<PeriodicTask> periodicTaskList) {
		ArrayList<TimeBlock> timeAxis = new ArrayList<TimeBlock>();
		
		return timeAxis;
	}
	
	/**
	 * 轮转调度，Round-Robin
	 * @param periodicTaskList 一组周期性任务
	 * @return ArrayList<TimeBlock> 时间轴，每段时间内执行的任务
	 */
	public static ArrayList<TimeBlock> roundRobin(ArrayList<PeriodicTask> periodicTaskList) {
		ArrayList<TimeBlock> timeAxis = new ArrayList<TimeBlock>();
		
		return timeAxis;
	}
	
	
}
