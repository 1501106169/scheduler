package pers.han.scheduler.check;

import java.util.Vector;

import pers.han.scheduler.framework.CheckResultEnum;
import pers.han.scheduler.task.SporadicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * 校验算法的基类
 * 
 * @author		hanYG
 * @createDate	2022年6月1日
 * @alterDate	2022年6月1日
 * 				2022年09年28日 添加tearDown设为虚函数
 * @version		1.0
 *
 */
public abstract class CheckAlgorithm {
	/** 一组实时任务 */
	protected Vector<Task> taskSet;
	
	/** 调度结果 */
	protected Vector<TimeBlock> schedulingResult;
	
	/** 调度算法执行的时间 */
	protected int deadline;
	
	/**
	 * 构造函数
	 */
	public CheckAlgorithm() {
		
	}
	
	/**
	 * 初始化成员变量，在doCheck方法前执行
	 * @param taskSet 周期性任务和非周期性任务
	 * @param schedulingResult 调度结果
	 */
	public void setUp(final Vector<Task> taskSet, final Vector<TimeBlock> schedulingResult, final int deadline) {
		this.taskSet = new Vector<Task>();
		for (Task task : taskSet) {
			this.taskSet.add(task.clone());
		}
		this.schedulingResult = new Vector<TimeBlock>();
		for (TimeBlock tBlock : schedulingResult) {
			this.schedulingResult.add(tBlock.clone());
		}
		this.deadline = deadline;
	}
	
	/**
	 * 初始化成员变量，在doCheck方法前执行
	 * @param taskSet 周期性任务和非周期性任务
	 * @param sporadicTaskSet 偶发任务
	 * @param schedulingResult 调度结果
	 */
	public void setUp(final Vector<Task> taskSet, final Vector<SporadicTask> sporadicTaskSet, final Vector<TimeBlock> schedulingResult, final int deadline) {
		this.taskSet = new Vector<Task>();
		for (Task task : taskSet) {
			this.taskSet.add(task.clone());
		}
		for (Task task : sporadicTaskSet) {
			this.taskSet.add(task.clone());
		}
		this.schedulingResult = new Vector<TimeBlock>();
		for (TimeBlock tBlock : schedulingResult) {
			this.schedulingResult.add(tBlock.clone());
		}
		this.deadline = deadline;
	}
	
	/**
	 * 在doCheck方法后执行
	 */
	public abstract void tearDown();
	
	/**
	 * 执行校验算法
	 * @param taskSet 一组实时任务
	 * @param schedulingResult 调度结果
	 * @return CheckResultEnum
	 */
	public abstract CheckResultEnum doCheck();
	
	
}
