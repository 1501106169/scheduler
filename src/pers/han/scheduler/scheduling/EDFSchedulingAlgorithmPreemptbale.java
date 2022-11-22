package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * EDF可抢占调度算法
 * 动态优先级调度算法
 * 任务的时限越早优先级越高
 * 
 * @author		hanYG
 * @createDate	2022年11月11日
 * @alterDate	2022年11月11日
 * @version		1.0
 *
 */
public class EDFSchedulingAlgorithmPreemptbale extends SchedulingAlgorithm{

	@Override
	public Vector<TimeBlock> doSchedule() {
		// 记录上次调度任务的开始时刻
		int startTime = 0;
		// 记录上次调度任务的索引
		int index = -1;
		for ( ; this.timeAxis < this.runEndTime; ++this.timeAxis) {
			int taskIndex = getMinDeadlineTask(taskSet, this.timeAxis);
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
			if (task.getRunTime() == task.getJobExecTime()) {
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
	 * 从就绪的任务中选择截至时间最小的任务
	 * @param taskSet 任务集
	 * @param nowTime 当前时刻
	 * @return Integer
	 */
	private int getMinDeadlineTask(final Vector<Task> taskSet, final int nowTime) {
		int nextTaskId = -1;
		int leastDeadline = Integer.MAX_VALUE;
		for (int i = 0; i < taskSet.size(); ++i) {
			if (taskSet.get(i).getClass() == PeriodicTask.class) {
				// 周期性任务
				PeriodicTask pTask = (PeriodicTask) taskSet.get(i);
				int realseTime = pTask.getCycleStartTime() + pTask.getJobReleaseTime();
				int deadline = pTask.getCycleStartTime() + pTask.getJobDeadline();
				if (realseTime <= nowTime && deadline <= leastDeadline) {
					nextTaskId = i;
					leastDeadline = deadline;
				}
			} else {
				// 偶发任务和非周期性任务
				if (taskSet.get(i).getJobDeadline() <= leastDeadline 
						&& taskSet.get(i).getRunTime() < taskSet.get(i).getJobExecTime()) {
					nextTaskId = i;
					leastDeadline = taskSet.get(i).getJobDeadline();
				}
			}
		}
		return nextTaskId;
	}
	
}
