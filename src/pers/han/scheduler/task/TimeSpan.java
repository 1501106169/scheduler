package pers.han.scheduler.task;

// import java.util.Iterator;

/**
 * 表示任务的下一个执行时间段
 * FileName: TimeSpan.java
 * 
 * @author		hanYG
 * @createDate	2021.06.18
 * @alterDate	2021.09.14
 * @version		2.0
 *
 */
public final class TimeSpan {
	
	/** 任务编号 */
	// protected int id;
	
	/** 开始时间 */
	protected double startTime;
	
	/** 结束时间 */
	protected double endTime;
	
	/** 任务周期 */
	protected double periodic;
	
	/**
	 * 构造函数
	 * @param startTime		开始时间
	 * @param endTime		结束时间
	 * @param periodic		任务周期
	 */
	public TimeSpan(double startTime, double endTime, double periodic) {
		// this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.periodic = periodic;
		return;
	}
	
	/**
	 * 构造函数
	 * @param periodicTask	一个周期性任务
	 */
	public TimeSpan(PeriodicTask periodicTask) {
		this.startTime = periodicTask.getJobReleaseTime();
		this.endTime = periodicTask.getJobDeadline();
		this.periodic = periodicTask.getTaskPeriodic();
		return;
	}

	/**
	 * 进入下一个时间周期
	 */
	public void nextPeriodic() {
		this.startTime = this.endTime;
		this.endTime += this.periodic;
		return;
	}
	
	
	/**
	 * 获取任务编号
	 * @return	Integer
	 */
	/*
	public int getId() {
		return this.id;
	}
	*/
	
	/**
	 * 获取任务的释放时间
	 * @return	Double
	 */
	public double getStartTime() {
		return this.startTime;
	}
	
	/**
	 * 获取任务的时限
	 * @return	Double
	 */
	public double getEndTime() {
		return this.endTime;
	}
	
	/**
	 * 设置任务释放时间
	 * @param startTime	任务开始时间
	 */
	/*
	public void setStartTime(double startTime) {
		this.startTime = startTime;
		return;
	}
	*/
	
	/**
	 * 设置任务的时限
	 * @param endTime	任务时限
	 */
	/*
	public void setEndTime(double endTime) {
		this.endTime = endTime;
		return;
	}
	*/

}
