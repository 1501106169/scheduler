package pers.han.scheduler.task;

/**
 * 任务的执行时间段
 * 
 * @author		hanYG
 * @createDate	2022年5月29日
 * @alterDate	2022年5月29日
 * 				2022年6月5日 修改task 为 taskId 
 * @version		2.0
 *
 */
public class TimeBlock {
	// protected Task task;
	/** 任务Id */
	protected int taskId;
	
	/** 开始时间 */
	protected int startTime;
	
	/** 执行时间 */
	protected int execTime;

	/**
	 * 构造函数
	 * @param taskId 指明某个任务
	 * @param startTime 任务开始执行时间
	 * @param execTime 任务执行时间
	 */
	public TimeBlock(int taskId, int startTime, int execTime) {
		this.taskId = taskId;
		this.startTime = startTime;
		this.execTime = execTime;
	}

	/**
	 * 获取任务
	 * @return int
	 */
	public int getTaskId() {
		return this.taskId;
	}
	
	/**
	 * 获取任务开始时间
	 * @return int
	 */
	public int getStartTime() {
		return this.startTime;
	}
	
	/**
	 * 获取任务执行时间
	 * @return int
	 */
	public int getExecTime() {
		return this.execTime;
	}
}
