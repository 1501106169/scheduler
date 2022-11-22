package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * RM可抢占调度算法
 * 调度周期性任务
 * 
 * @author		hanYG
 * @createDate	2022年11月13日
 * @alterDate	2022年11月13日
 * @version		1.0
 *
 */
public class RMPeriodicSchedulingAlgorithmPreemptable extends SchedulingAlgorithm {

	@Override
	public Vector<TimeBlock> doSchedule() {
		for (Task task : this.taskSet) {
			task.setTaskPriority(((PeriodicTask) task).getTaskPeriodic());
		}
		// 记录上次调度任务的开始时刻
		int startTime = 0;
		// 记录上次调度任务的索引
		int index = -1;
		for ( ; this.timeAxis < this.runEndTime; ++this.timeAxis) {
			int taskIndex = getPeriodicMinTask(taskSet, this.timeAxis);
			if (taskIndex == -1) {
				if (index != -1) {
					this.schedulingResult.add(new TimeBlock(index, startTime, this.timeAxis - startTime));
					index = -1;
				}
				continue;
			}
			if (index == -1) {
				index = taskIndex;
				startTime = this.timeAxis;
			} else if (index != taskIndex) {
				this.schedulingResult.add(new TimeBlock(index, startTime, this.timeAxis - startTime));
				startTime = this.timeAxis;
				index = taskIndex;
			}
			this.taskSet.get(taskIndex).run();
			Task task = this.taskSet.get(taskIndex);
			if (task.getRunTime() >= task.getJobExecTime()) {
				this.schedulingResult.add(new TimeBlock(index, startTime, this.timeAxis - startTime + 1));
				index = -1;
				if (task.getClass() == PeriodicTask.class) {
					// 周期性任务
					((PeriodicTask) task).nextCycle();
				} 
			}
		}
		if (index != -1) {
			this.schedulingResult.add(new TimeBlock(index, startTime, this.timeAxis - startTime));
		}
		return this.schedulingResult;
	}

	/**
	 * 获取已释放且周期最短的任务
	 * @param taskSet 任务集
	 * @param nowTime 当前时刻
	 * @return Integer
	 */
	private int getPeriodicMinTask(final Vector<Task> taskSet, final int nowTime) {
		int nextTaskId = -1;
		int minPriority = Integer.MAX_VALUE;
		for (int i = 0; i < taskSet.size(); ++i) {
			PeriodicTask task = (PeriodicTask) taskSet.get(i);
			if (task.getCycleStartTime() + task.getJobReleaseTime() <= nowTime 
					&& task.getTaskPriority() <= minPriority) {
				minPriority = task.getTaskPeriodic();
				nextTaskId = i;
			}
		}
		return nextTaskId;
	}

}
