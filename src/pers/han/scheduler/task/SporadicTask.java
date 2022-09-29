package pers.han.scheduler.task;

/**
 * 偶发任务
 * 
 * @author		hanYG
 * @createDate	2022年5月29日
 * @alterDate	2022年5月29日
 * 				2022年09年28日 添加拷贝函数，拷贝构造函数
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
	
	/**
	 * 拷贝构造函数
	 * @param task
	 */
	public SporadicTask(SporadicTask task) {
		this.jobReleaseTime = task.getJobReleaseTime();
		this.jobExecTime = task.getJobExecTime();
		this.jobDeadline = task.getJobDeadline();
		this.taskPriority = task.getTaskPriority();
		this.jobPreempt = task.getJobPreemption();
	}

	@Override
	public Task clone() {
		SporadicTask task = new SporadicTask(this.jobReleaseTime, this.jobExecTime, this.jobDeadline, this.taskPriority, this.jobPreempt);
		return task;
	}

}
