package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * LETF可抢占调度算法
 * 固定优先级算法
 * LETF最长执行时间优先
 * 
 * @author		hanYG
 * @createDate	2022年11月14日
 * @alterDate	2022年11月14日
 * @version		1.0
 *
 */
public class LETFSchedulingAlgorithmPreemptable extends SchedulingAlgorithm {

	@Override
	public Vector<TimeBlock> doSchedule() {
		for (Task task : this.taskSet) {
			// 数字越大优先级越高
			task.setTaskPriority(task.getJobExecTime());
		}
		int nowTime = 0;
		// 记录上次调度任务的开始时刻
		int startTime = 0;
		// 记录上次调度任务的索引
		int index = -1;
		for (nowTime = 0 ; nowTime < this.runEndTime; ++nowTime) {
			int taskIndex = getPriorityTask(taskSet, nowTime);
			if (taskIndex == -1) {
				if (index != -1) {
					this.schedulingResult.add(new TimeBlock(index, startTime, nowTime - startTime));
					index = -1;
				}
				continue;
			}
			if (index == -1) {
				index = taskIndex;
				startTime = nowTime;
			} else if (index != taskIndex) {
				this.schedulingResult.add(new TimeBlock(index, startTime, nowTime - startTime));
				startTime = nowTime;
				index = taskIndex;
			}
			this.taskSet.get(taskIndex).run();
			Task task = this.taskSet.get(taskIndex);
			if (task.getRunTime() == task.getJobExecTime()) {
				this.schedulingResult.add(new TimeBlock(index, startTime, nowTime - startTime + 1));
				index = -1;
				if (task.getClass() == PeriodicTask.class) {
					// 周期性任务
					((PeriodicTask) task).nextCycle();
				} 
			}
		}
		if (index != -1) {
			this.schedulingResult.add(new TimeBlock(index, startTime, nowTime - startTime));
		}
		return null;
	}

	/**
	 * 从就绪的任务中选择优先级最高的任务
	 * @param taskSet 任务集
	 * @param nowTime 当先时刻
	 * @return Integer
	 */
	private int getPriorityTask(final Vector<Task> taskSet, final int nowTime) {
		int nextTaskId = -1;
		// 数字越大优先级越高
		int priority = 0;
		for (int i = 0; i < taskSet.size(); ++i) {
			if (taskSet.get(i).getJobReleaseTime() <= nowTime 
					&& taskSet.get(i).getRunTime() < taskSet.get(i).getJobExecTime()
					&& taskSet.get(i).getTaskPriority() > priority) {
				nextTaskId = i;
				priority = taskSet.get(i).getTaskPriority();
			}
		}		
		return nextTaskId;
	}
	
}
