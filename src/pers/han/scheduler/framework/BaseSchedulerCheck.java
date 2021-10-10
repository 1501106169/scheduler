package pers.han.scheduler.framework;

import pers.han.scheduler.task.*;
import java.util.ArrayList;

/**
 * 包含输入、算法、输出的接口
 * 
 * FileName: BaseSchedulerCheck.java
 * 
 * @author		hanYG
 * @createDate	2021.10.08
 * @alterDate	2021.10.10	修改类型ArrayList->ArrayList<Task>
 * @version		2.0
 *
 */
public interface BaseSchedulerCheck {
	
	/**
	 * 读入测试用例
	 * @return 一组调度任务
	 */
	public abstract ArrayList<Task> inputTestCase();
	
	/**
	 * 调度算法
	 * @param taskList	原始ArrayList，一组任务
	 * @return	调度结果
	 */
	public abstract ArrayList<TimeBlock> schedulerAlgroithm(ArrayList<Task> taskList);
	
	/**
	 * 输出算法
	 * @param timeBlock	调度的时间片
	 */
	public abstract void outputSchedulerResult(ArrayList<TimeBlock> timeBlock);	
	
	/**
	 * 校验算法
	 * @param taskList	任务
	 * @param timeBlock	调度结果
	 * @return	算法的正确性
	 */
	public abstract boolean checkSchedulerAlgroithm(ArrayList<Task> taskList, ArrayList<TimeBlock> timeBlock);
	
}
