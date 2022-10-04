package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * 调度算法的基类
 * 
 * @author		hanYG
 * @createDate	2022年6月1日
 * @alterDate	2022年6月1日
 * @version		1.0
 *
 */
public abstract class SchedulingAlgorithm {
	
	/** 一组实时任务 */
	protected Vector<Task> taskSet;
	
	/** 算法运行结束时间 */
	protected int runEndTime;
	
	/** 算法运行的时间轴 */
	protected int timeAxis = 0;
	
	/** 调度结果 */
	protected Vector<TimeBlock> schedulingResult = new Vector<TimeBlock>();
	
	/**
	 * 构造函数
	 */
	public SchedulingAlgorithm() { }
	
	/**
	 * 初始化成员变量，在doSchedule方法执行前执行
	 * @param taskSet 一组实时任务
	 * @param runEndTime 算法执行结束时间
	 */
	public void setUp(final Vector<Task> taskSet, final int runEndTime) {
		this.taskSet = taskSet;
		this.runEndTime = runEndTime;
	}
	
	/**
	 * 在doSchedule方法执行后执行
	 */
	public void tearDown() {
		
	}
	
	/**
	 * 执行调度算法
	 * @return Vector<TimeBlock>
	 */
	public abstract Vector<TimeBlock> doSchedule();
	
	/**
	 * 向实时任务中添加一个偶发任务，调度偶发任务的调度算法需要重写此方法
	 * @param sporadicTask 偶发任务
	 * @param runEndTime 添加偶发任务后，算法执行截止时间
	 */
	public void addTask(final Task sporadicTask, final int runEndTime) {
		return;
	}
	
	/**
	 * 获取调度结果
	 * @return Vector<TimeBlock>
	 */
	public Vector<TimeBlock> getSchedulingResult() {
		return this.schedulingResult;
	}
	
}
