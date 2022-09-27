package pers.han.scheduler.task;

/**
 * 偶发任务
 * 
 * @author		hanYG
 * @createDate	2022年5月29日
 * @alterDate	2022年5月29日
 * @version		1.0
 *
 */
public class SporadicTask extends Task {
	
	/**
	 * 构造函数
	 * @param jobReleaseTime 释放时间
	 * @param jobExecTime 执行时间
	 * @param jobDeadline 截至时间
	 * @param taskPriority 优先级
	 * @param jobPreempt 是否可抢占
	 */
	public SporadicTask(int jobReleaseTime, int jobExecTime, int jobDeadline, int taskPriority, JobPreemption jobPreempt) {
		this.jobReleaseTime = jobReleaseTime;
		this.jobExecTime = jobExecTime;
		this.jobDeadline = jobDeadline;
		this.taskPriority = taskPriority;
		this.jobPreempt = jobPreempt;
	}
	
	/**
	 * 构造函数，无优先级、不可抢占
	 * @param jobReleaseTime 释放时间
	 * @param jobExecTime 执行时间
	 * @param jobDeadline 截至时间
	 */
	public SporadicTask(int jobReleaseTime, int jobExecTime, int jobDeadline) {
		this.jobReleaseTime = jobReleaseTime;
		this.jobExecTime = jobExecTime;
		this.jobDeadline = jobDeadline;
		this.jobPreempt = JobPreemption.NONPREEMPTABLE;
		this.taskPriority = 0;
	}

}
