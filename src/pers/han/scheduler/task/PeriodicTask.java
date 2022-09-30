package pers.han.scheduler.task;

/**
 * 周期性任务
 * 
 * @author		hanYG
 * @createDate	2021年6月17日
 * @alterDate	2021年10月10日
 * 				2022年6月19日	添加属性cycleStartTime
 * 				2022年09月28日 添加拷贝函数
 * @version		1.0
 *
 */
public class PeriodicTask extends Task {
	
	/** 任务周期 */
	protected int taskPeriodic;
	
	/** 下一个周期的开始时间 */
	protected int cycleStartTime = 0;
	
	/**
	 * 构造函数
	 * @param taskPhase 相位
	 * @param taskPeriodic 周期
	 * @param jobExecTime 执行时间
	 * @param jobDeadline 截至时间
	 * @param taskPriority 优先级
	 * @param jobPreempt 是否可抢占
	 */
	public PeriodicTask(int taskPhase, int taskPeriodic, int jobExecTime, int jobDeadline, int taskPriority, JobPreemption jobPreempt) {
		// 相位，释放时间
		this.jobReleaseTime = taskPhase;
		this.jobDeadline = jobDeadline;
		this.taskPeriodic = taskPeriodic;
		this.jobExecTime = jobExecTime;
		this.taskPriority = taskPriority;
		this.jobPreempt = jobPreempt;
	}
	
	
	/**
	 * 构造函数，无优先级、不可抢占
	 * @param taskPhase		周期性任务的相位
	 * @param taskPeriodic	周期性任务的周期
	 * @param jobExecTime	周期性任务的执行时间
	 * @param jobDeadline	周期性任务的时限
	 */
	public PeriodicTask(int taskPhase, int taskPeriodic, int jobExecTime, int jobDeadline) {
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
		this.taskPriority = 0;
	}

	/**
	 * 构造函数，无优先级、不可抢占
	 * @param taskPeriodic	周期性任务的周期
	 * @param jobExecTime	周期性任务的执行时间
	 * @param jobDeadline	周期性任务的时限
	 */
	public PeriodicTask(int taskPeriodic, int jobExecTime, int jobDeadline) {
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
		this.taskPriority = 0;
	}
	
	/**
	 * 构造函数，无优先级、不可抢占
	 * @param taskPeriodic	周期性任务的周期
	 * @param jobExecTime	周期性任务的执行时间
	 */
	public PeriodicTask(int taskPeriodic, int jobExecTime) {
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
		this.taskPriority = 0;
	}
	
	/**
	 * 拷贝构造函数
	 * @param periodicTask 周期性任务
	 */
	public PeriodicTask(PeriodicTask periodicTask) {
		this.jobDeadline = periodicTask.getJobDeadline();
		this.jobExecTime = periodicTask.getJobExecTime();
		this.jobPreempt = periodicTask.getJobPreemption();
		this.jobReleaseTime = periodicTask.getJobReleaseTime();
		this.taskPeriodic = periodicTask.getTaskPeriodic();
		this.taskPriority = periodicTask.getTaskPriority();
	}
	
	/**
	 * 获取周期性任务周期
	 * @return int
	 */
	public int getTaskPeriodic() {
		return this.taskPeriodic;
	}
	
	/**
	 * 获取周期性任务的下一个周期开始时间
	 * @return
	 */
	public int getCycleStartTime() {
		return this.cycleStartTime;
	}
	
	/**
	 * 周期性任务进入下一个周期
	 */
	public void nextCycle() {
		this.cycleStartTime += this.taskPeriodic;
	}

	@Override
	public Task clone() {
		PeriodicTask task = new PeriodicTask(this.jobReleaseTime, this.taskPeriodic, this.jobExecTime, this.jobDeadline, this.taskPriority, this.jobPreempt);
		return task;
	}

}
