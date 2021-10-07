package pers.han.scheduler.framework;

import pers.han.scheduler.task.*;
import java.util.ArrayList;

/**
 * 包含输入、算法、输出的接口
 * 
 * FileName: BaseSchedulerCheck.java
 * 
 * @author	hanYG
 * @date	2021.09.28
 * @version	1.0
 *
 */
public interface BaseSchedulerCheck {
	
	/**
	 * 调度算法
	 * @param taskList	原始ArrayList，一组任务
	 * @return	调度结果
	 */
	public abstract ArrayList<TimeBlock> schedulerAlgroithm(ArrayList taskList);
	
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
	public abstract boolean checkSchedulerAlgroithm(ArrayList taskList, ArrayList<TimeBlock> timeBlock);
	
}
