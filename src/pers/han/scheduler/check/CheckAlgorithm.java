package pers.han.scheduler.check;

import java.util.Vector;

import pers.han.scheduler.framework.CheckResultEnum;
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
	Vector<Task> taskSet;
	
	/** 调度结果 */
	Vector<TimeBlock> schedulingResult;
	
	/** 调度算法执行的时间 */
	int deadline;
	
	/**
	 * 构造函数
	 */
	public CheckAlgorithm() {
		
	}
	
	/**
	 * 初始化成员变量，在doCheck方法前执行
	 * @param taskSet
	 * @param schedulingResult
	 */
	public void setUp(Vector<Task> taskSet, Vector<TimeBlock> schedulingResult, int deadline) {
		this.taskSet = taskSet;
		this.schedulingResult = schedulingResult;
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
