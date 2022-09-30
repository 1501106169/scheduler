package pers.han.scheduler.algroithms;

import java.util.Vector;

import pers.han.scheduler.task.Task;

/**
 * 调度算法的基类
 * 
 * @author		hanYG
 * @createDate	2022年5月29日
 * @alterDate	2022年5月29日
 * @version		1.0
 *
 */
public abstract class SchedulingAlgorithm {
	/** 一组实时任务 */
	Vector<Task> TaskSet;
	
	/** 当前时间 */
	int timeAxis = 0;
	
	/** 调度算法运行截至时间 */
	int runEndTime;
	
	/**
	 * 构造函数
	 * @param taskSet 一组实时任务
	 * @param runEndTime 算法运行截至时间
	 */
	public SchedulingAlgorithm(Vector<Task> taskSet, int runEndTime) {
		this.TaskSet = taskSet;
		this.runEndTime = runEndTime;
	}
	
	/**
	 * 向实时任务中添加一个偶发任务。调度偶发任务的调度算法现实时需要重写
	 * @param sporadicTask
	 */
	public void addTask(Task sporadicTask) {
		return;
	}
	
}
