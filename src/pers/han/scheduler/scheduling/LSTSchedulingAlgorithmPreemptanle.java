package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * LST可抢占调度算法
 * 
 * @author		hanYG
 * @createDate	2022年11月13日
 * @alterDate	2022年11月13日
 * @version		1.0
 *
 */
public class LSTSchedulingAlgorithmPreemptanle extends SchedulingAlgorithm {

	@Override
	public Vector<TimeBlock> doSchedule() {
		int nowTime = 0;
		// 记录上次调度任务的开始时刻
		int startTime = 0;
		// 记录上次调度任务的索引
		int index = -1;
		for (nowTime = 0 ; nowTime < this.runEndTime; ++nowTime) {
			int taskIndex = getLeastSlackTimeTask(taskSet, nowTime);
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
		return this.schedulingResult;
	}
	
	/**
	 * 从就绪的任务中选择松弛时间时间最小的任务
	 * @param taskSet 任务集
	 * @param nowTime 当前时刻
	 * @return Integer
	 */
	private int getLeastSlackTimeTask(final Vector<Task> taskSet, final int nowTime) {
		int nextTaskId = -1;
		int leastSlackTime = this.runEndTime;
		for (int i = 0; i < taskSet.size(); ++i) {
			if (taskSet.get(i).getClass() == PeriodicTask.class) {
				// 周期性任务
				PeriodicTask pTask = (PeriodicTask) taskSet.get(i);
				int realseTime = pTask.getCycleStartTime() + pTask.getJobReleaseTime();
				int slackTime = pTask.getCycleStartTime() + pTask.getJobDeadline() - pTask.getJobExecTime() - nowTime + pTask.getRunTime();
				if (realseTime <= nowTime && slackTime <= leastSlackTime) {
					nextTaskId = i;
					leastSlackTime = slackTime;
				}
			} else {
				// 偶发任务和非周期性任务
				int slackTime = taskSet.get(i).getJobDeadline() - taskSet.get(i).getJobExecTime() - nowTime + taskSet.get(i).getRunTime();
				if (taskSet.get(i).getRunTime() < taskSet.get(i).getJobExecTime() 
						&& slackTime <= leastSlackTime) {
					nextTaskId = i;
					leastSlackTime = slackTime;
				}
			}
		}
		return nextTaskId;
	}

}
