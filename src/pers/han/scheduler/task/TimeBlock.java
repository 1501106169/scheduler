package pers.han.scheduler.task;

/**
 * 每段时间内执行的任务
 * FileName: TimeBlock.java
 * 
 * @author		hanYG
 * @createDate	2021.06.18
 * @alterDate	2021.06.17
 * @version		1.0
 *
 */
public final class TimeBlock {
	
	/** 任务编号 */
	protected int id;
	
	/** 开始时间 */
	protected double startTime;
	
	/** 执行时间 */
	protected double execTime;
	
	/**
	 * 构造函数
	 * @param id		任务编号
	 * @param startTime	开始时间
	 * @param execTime	执行时间
	 */
	public TimeBlock(int id, double startTime, double execTime) {
		this.id = id;
		this.startTime = startTime;
		this.execTime = execTime;
	}
	
	/**
	 * 获取任务编号
	 * @return	Integer
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * 获取任务开始时间
	 * @return	Double
	 */
	public double getStartTime() {
		return this.startTime;
	}
	
	/**
	 * 获取任务执行时间
	 * @return	Double
	 */
	public double getExecTime() {
		return this.execTime;
	}
}
