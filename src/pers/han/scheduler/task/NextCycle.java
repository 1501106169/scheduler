package pers.han.scheduler.task;

/**
 * 周期性任务的下一个周期
 * 
 * @author		hanYG
 * @createDate	2022年5月29日
 * @alterDate	2022年5月29日
 * 				2022年6月5日		添加taskId
 * 				2022年6月29日	弃用
 * @version		1.1
 *
 */
public class NextCycle extends Task {
	/** 周期性任务 */
	protected PeriodicTask periodicTask;
	
	/** 任务Id */
	protected int taskId;
	
	/** 下一个周期的开始时间 */
	protected int cycleStartTime = 0;
	
	/**
	 * 构造函数，根据周期性任务构造
	 * @param periodicTask 周期性任务
	 */
	public NextCycle(PeriodicTask periodicTask, int taskId) {
		this.periodicTask = periodicTask;
		this.cycleStartTime = 0;
		this.jobPreempt = periodicTask.getJobPreemption();
		this.jobExecTime = periodicTask.getJobExecTime();
		this.jobDeadline = periodicTask.getJobDeadline();
		this.jobReleaseTime = periodicTask.getJobReleaseTime();
		this.taskPriority = periodicTask.getTaskPriority();
		this.taskId = taskId;
	}
	
	/**
	 * 获取周期性任务的下一个周期开始时间
	 * @return
	 */
	public int getCycleStartTime() {
		return this.cycleStartTime;
	}
	
	/**
	 * 设置周期性任务的周期进入下一个周期
	 */
	public void setNextCycle() {
		this.cycleStartTime += this.periodicTask.getTaskPeriodic();
		this.jobReleaseTime = this.cycleStartTime + this.periodicTask.getJobReleaseTime();
		this.jobDeadline = this.cycleStartTime + this.periodicTask.getJobDeadline();
	}
	
	/**
	 * 获取任务
	 * @return PeriodicTask
	 */
	public PeriodicTask getTask() {
		return this.periodicTask;
	}
	
	/**
	 * 获取任务id
	 */
	public int getTaskId() {
		return this.taskId;
	}
	
}
