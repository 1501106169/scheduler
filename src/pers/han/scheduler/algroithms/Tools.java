package pers.han.scheduler.algroithms;

import pers.han.scheduler.task.*;
import pers.han.scheduler.algroithms.Numeric;

import java.util.Vector;

/**
 * 工具类，包含一组静态方法
 * 
 * @author		hanYG
 * @createDate	2022年10月3日
 * @alterDate	2022年10月3日
 * @version		1.0
 *
 */
public class Tools {
	
	private Tools() { }
	
	/**
	 * 计算一组任务的执行周期，
	 * 周期性任务的超周期和非周期性任务的最大deadline做比较
	 * 取超周期的倍数大于deadline时的值
	 * @param taskSet 周期性任务
	 * @return
	 */
	public static int hyperperiod(final Vector<Task> taskSet) {
		// Vector<PeriodicTask> periodicTaskSet = new Vector<PeriodicTask>();
		Vector<Integer> list = new Vector<Integer>();
		int maxDeadline = 0;
		for (Task task : taskSet) {
			if (task.getClass() == PeriodicTask.class) {
				list.add(((PeriodicTask) task).getTaskPeriodic());
			} else {
				maxDeadline = Math.max(maxDeadline, task.getJobDeadline());
			}
		}
		int hyper = Numeric.leastCommonMultiple(list);
		int res = hyper;
		// 如果执行周期小于最大的deadline，则执行周期加上超周期
		while (res < maxDeadline) {
			res += hyper;
		}
		return res;
	}
	
	/**
	 * 获取任务中作业的最早释放时间
	 * @param taskSet 任务集
	 * @return Integer
	 */
	public static int getEarlistRealseTime(final Vector<Task> taskSet) {
		if (taskSet.isEmpty()) {
			// -1 表示作业为空
			return -1;
		}
		int leastRealseTime =  Integer.MAX_VALUE;
		for (Task task : taskSet) {
			if (task.getClass() == PeriodicTask.class) {
				// 周期性任务
				leastRealseTime = Math.min(leastRealseTime, 
						((PeriodicTask) task).getCycleStartTime() + ((PeriodicTask) task).getJobReleaseTime());
			} else if (task.getRunTime() < task.getJobExecTime()) {
				// 偶发任务和非周期性任务
				leastRealseTime = Math.min(leastRealseTime, task.getJobReleaseTime());
			}
		}
		return leastRealseTime;
	}

}
