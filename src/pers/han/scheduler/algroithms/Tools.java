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
			if (task.getClass() == pers.han.scheduler.task.PeriodicTask.class) {
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

}
