package pers.han.scheduler.task;

/**
 * 不可抢占的周期性任务
 * FileName: PeriodicTask.java
 * 
 * @author		hanYG
 * @createDate	2021.06.17
 * @alterDate	2021.10.10
 * @version		1.0
 *
 */
public final class PeriodicTask extends Task {
	
	/** 任务周期 */
	protected int taskPeriodic;
	
	/**
	 * 构造函数
	 * @param taskPhase		周期性任务的相位
	 * @param taskPeriodic	周期性任务的周期
	 * @param jobExecTime	周期性任务的执行时间
	 * @param jobDeadline	周期性任务的时限
	 */
	public PeriodicTask(int taskPhase, int taskPeriodic, int jobExecTime, int jobDeadline) {
		// 周期性任务
		this.taskType = TaskType.PERIODIC;
		// 不可抢占
		this.jobPreempt = JobPreemption.NONPREEMPTABLE;
		// 时限
		this.jobDeadline = jobDeadline;
		// 周期
		this.taskPeriodic = taskPeriodic;
		// 执行时间
		this.jobExecTime = jobExecTime;
		// 相位
		this.jobReleaseTime = taskPhase;
	}
	
	/**
	 * 构造函数
	 * @param taskPeriodic	周期性任务的周期
	 * @param jobExecTime	周期性任务的执行时间
	 * @param jobDeadline	周期性任务的时限
	 */
	public PeriodicTask(int taskPeriodic, int jobExecTime, int jobDeadline) {
		// 周期性任务
		this.taskType = TaskType.PERIODIC;
		// 不可抢占
		this.jobPreempt = JobPreemption.NONPREEMPTABLE;
		// 时限
		this.jobDeadline = jobDeadline;
		// 周期
		this.taskPeriodic = taskPeriodic;
		// 执行时间
		this.jobExecTime = jobExecTime;
		// 相位相位等于0
		this.jobReleaseTime = 0;
	}
	
	/**
	 * 构造函数
	 * @param taskPeriodic	周期性任务的周期
	 * @param jobExecTime	周期性任务的执行时间
	 */
	public PeriodicTask(int taskPeriodic, int jobExecTime) {
		// 周期性任务
		this.taskType = TaskType.PERIODIC;
		// 不可抢占
		this.jobPreempt = JobPreemption.NONPREEMPTABLE;
		// 时限等于周期
		this.jobDeadline = taskPeriodic;
		// 周期
		this.taskPeriodic = taskPeriodic;
		// 执行时间
		this.jobExecTime = jobExecTime;
		// 相位等于0
		this.jobReleaseTime = 0;
	}
	
	/**
	 * 获取周期性任务周期
	 * @return	Integer
	 */
	public int getTaskPeriodic() {
		return this.taskPeriodic;
	}

}
