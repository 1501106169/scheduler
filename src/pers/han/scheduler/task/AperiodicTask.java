package pers.han.scheduler.task;

/**
 * 非周期性任务
 * 
 * @author		hanYG
 * @createDate	2022年5月29日
 * @alterDate	2022年5月29日
 * 				2022年09年28日 添加拷贝函数，拷贝构造函数
 * @version		1.0
 *
 */
public class AperiodicTask extends Task {
	
	/**
	 * 构造函数
	 * @param jobReleaseTime 释放时间
	 * @param jobExecTime 执行时间
	 * @param jobDeadline 截止时间
	 * @param taskPriority 优先级
	 * @param jobPreempt 是否可抢占
	 */
	public AperiodicTask(int jobReleaseTime, int jobExecTime, int jobDeadline, int taskPriority, JobPreemption jobPreempt) {
		this.jobReleaseTime = jobReleaseTime;
		this.jobExecTime = jobExecTime;
		this.jobDeadline = jobDeadline;
		this.taskPriority = taskPriority;
		this.jobPreempt = jobPreempt;
	}
	
	/**
	 * 构造函数，作业无优先级、不可抢占
	 * @param jobReleaseTime 释放时间
	 * @param jobExecTime 执行时间
	 * @param jobDeadline 截止时间
	 */
	public AperiodicTask(int jobReleaseTime, int jobExecTime, int jobDeadline) {
		this.jobReleaseTime = jobReleaseTime;
		this.jobExecTime = jobExecTime;
		this.jobDeadline = jobDeadline;
		this.jobPreempt = JobPreemption.NONPREEMPTABLE;
		this.taskPriority = 0;
	}
	
	/**
	 * 拷贝构造函数
	 * @param task
	 */
	public AperiodicTask(AperiodicTask task) {
		this.jobReleaseTime = task.getJobReleaseTime();
		this.jobExecTime = task.getJobExecTime();
		this.jobDeadline = task.getJobDeadline();
		this.taskPriority = task.getTaskPriority();
		this.jobPreempt = task.getJobPreemption();
	}

	@Override
	public Task clone() {
		return new AperiodicTask(this.jobReleaseTime, this.jobExecTime, this.jobDeadline, this.taskPriority, this.jobPreempt);
	}
	
}
