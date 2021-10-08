package pers.han.scheduler.task;

/**
 * 所有任务的基类
 * FileName: Task.java
 * 
 * @author		hanYG
 * @createDate	2021.05.17
 * @alterDate	2021.05.17
 * @version		1.0
 *
 */
public abstract class Task {
	
	/** 任务类型 */
	protected TaskType taskType;
	
	/** 任务中作业的抢占 */
	protected JobPreemption jobPreempt;
	
	/** 作业执行时间 */
	protected double jobExecTime;
	
	/** 作业时限 */
	protected double jobDeadline;
	
	/** 作业释放时间 */
	protected double jobReleaseTime;
	
	/** 优先级 */
	protected double taskPriority = 0;
	
	/** 周期 */
	
	/**
	 * 获取任务优先级
	 * @return Double
	 */
	public double getTaskPriority() {
		return this.taskPriority;
	}
	
	/**
	 * 获取任务类型
	 * @return	枚举类型
	 */
	public TaskType getTaskType() {
		return this.taskType;
	}
	
	/**
	 * 获取作业可抢占
	 * @return	枚举类型
	 */
	public JobPreemption getJobPreemption() {
		return this.jobPreempt;
	}
	
	/**
	 * 获取作业执行时间
	 * @return	Double
	 */
	public double getJobExecTime() {
		return this.jobExecTime;
	}
	
	/**
	 * 获取作业时限
	 * @return	Double
	 */
	public double getJobDeadline() {
		return this.jobDeadline;
	}
	
	/**
	 * 获取作业释放时间
	 * @return	Double
	 */
	public double getJobReleaseTime() {
		return this.jobReleaseTime;
	}
	

}
