package pers.han.scheduler.task;

/**
 * 所有实时任务类的基类
 * 
 * @author		hanYG
 * @createDate	2021年5月17日
 * @alterDate	2021年10月10日 修改时间类型double->int，表示单位时间不可拆分
 * 				2022年09年28日 添加拷贝函数
 * @version		21.0
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
	
	/** 任务已经运行的时间 */
	protected int runTime = 0;
	
	/**
	 * 获取任务优先级
	 * @return int
	 */
	public int getTaskPriority() {
		return this.taskPriority;
	}
	
	/**
	 * 设置任务的优先级
	 * @param priority
	 */
	public void setTaskPriority(int priority) {
		this.taskPriority = priority;
		return;
	}
	
	/**
	 * 获取作业可抢占
	 * @return JobPreemption
	 */
	public JobPreemption getJobPreemption() {
		return this.jobPreempt;
	}
	
	/**
	 * 获取作业执行时间
	 * @return int
	 */
	public int getJobExecTime() {
		return this.jobExecTime;
	}
	
	/**
	 * 获取作业时限
	 * @return int
	 */
	public int getJobDeadline() {
		return this.jobDeadline;
	}
	
	/**
	 * 获取作业释放时间
	 * @return int
	 */
	public int getJobReleaseTime() {
		return this.jobReleaseTime;
	}
	
	/**
	 * 获取类名，不包含包名
	 * @return String
	 */
	public String getClassName() {
		String clsName = this.getClass().getName();
		return clsName.substring(clsName.lastIndexOf(".") + 1);
	}
	
	/**
	 * 拷贝构造函数
	 */
	public abstract Task clone();
	
	/**
	 * 任务运行一个单位时间
	 */
	public void run() {
		this.runTime += 1;
	}
	
	/**
	 * 任务运行time时间单位
	 * @param time 时间
	 */
	public void run(int time) {
		this.runTime += time;
	}
	
	/**
	 * 获取任务实际运行时间
	 * @return Integer
	 */
	public int getRunTime() {
		return this.runTime;
	}
}
