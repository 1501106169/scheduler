package pers.han.scheduler.algroithms;

import java.util.ArrayList;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.TimeBlock;
import pers.han.scheduler.task.*;
// import java.util.Iterator;

// 弃用


/**
 * 对调度算法的结果进行校验
 * FileName: CheckAlgroithmsResult.java
 * 
 * @author		hanYG
 * @createDate	2021.09.10
 * @alterDate	2021.10.10	修改时间轴类型double->int
 * @version		1.1
 *
 */
public class CheckAlgroithmsResult {
	
	/**
	 * 私有构造函数
	 */
	private CheckAlgroithmsResult() {
		
	}
	
	/**
	 * 静态方法，校验不可抢占的周期性任务调度算法产生的结果
	 * @param periodicTaskList	一组周期性任务
	 * @param timeAxis			调度算法产生的调度结果
	 * @return					Boolean
	 */
	public static boolean checkPeriodicTask(ArrayList<PeriodicTask> periodicTaskList, ArrayList<TimeBlock> timeAxis) {
		// 需要校验，各个任务执行的次数
		// 验证调度任务的时间轴
		int axis = 0;
		// 记录每一个周期性任务在当前周期的释放时间和时限
		ArrayList<TimeSpan> nextStopTaskTime = new ArrayList<TimeSpan>();
		// Iterator<PeriodicTask> periodicTaskListIterator = periodicTaskList.iterator();
		for (PeriodicTask task : periodicTaskList) {
			nextStopTaskTime.add(new TimeSpan(task));
		}
		// 校验周期性任务的调度是否合理
		for (TimeBlock timeBlock : timeAxis) {
			int taskId = timeBlock.getId();
			// 当一个周期性任务的开始时间在时间轴之后，且开始时间和结束时间在当前周期的范围内时任务调度有效
			if (timeBlock.getStartTime() >= axis && timeBlock.getStartTime() >= nextStopTaskTime.get(taskId).getStartTime() && timeBlock.getExecTime() + timeBlock.getStartTime() <= nextStopTaskTime.get(taskId).getEndTime()) {
				nextStopTaskTime.get(taskId).nextPeriodic();
				axis = timeBlock.getStartTime() + timeBlock.getExecTime();
			} else {
				return false;
			}
		}
		return true;
	}
	
}
