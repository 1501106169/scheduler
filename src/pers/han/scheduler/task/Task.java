package pers.han.scheduler.task;

/**
 * 所有任务的基类
 * FileName: Task.java
 * 
 * @author		hanYG
 * @createDate	2021.05.17
 * @alterDate	2021.10.10	修改时间类型double->int，1表示单位时间不可拆分
 * @version		2.0
 *
 */
public abstract class Task {
	
	/** 任务类型 */
	// protected TaskType taskType;
	
	/** 任务中作业的抢占 */
	protected JobPreemption jobPreempt;
	
	/** 作业执行时间 */
	protected int jobExecTime;
	
	/** 作业时限 */
	protected int jobDeadline;
	
	/** 作业释放时间 */
	protected int jobReleaseTime;
	
	/** 优先级 */
	protected int taskPriority = 0;
	
	/** 周期 */
	
	/**
	 * 获取任务优先级
	 * @return Integer
	 */
	public int getTaskPriority() {
		return this.taskPriority;
	}
	
	/**
	 * 获取任务类型
	 * @return	枚举类型
	 */
	// public TaskType getTaskType() {
		// return this.taskType;
	// }
	
	/**
	 * 获取作业可抢占
	 * @return	枚举类型
	 */
	public JobPreemption getJobPreemption() {
		return this.jobPreempt;
	}
	
	/**
	 * 获取作业执行时间
	 * @return	Integer
	 */
	public int getJobExecTime() {
		return this.jobExecTime;
	}
	
	/**
	 * 获取作业时限
	 * @return	Integer
	 */
	public int getJobDeadline() {
		return this.jobDeadline;
	}
	
	/**
	 * 获取作业释放时间
	 * @return	Integer
	 */
	public int getJobReleaseTime() {
		return this.jobReleaseTime;
	}
	

}
