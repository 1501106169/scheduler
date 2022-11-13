package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.algroithms.Tools;
import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * LST不可抢占调度算法
 * 任务的松弛时间越少优先级越高
 * 
 * @author		hanYG
 * @createDate	2022年11月9日
 * @alterDate	2022年11月9日
 * @version		1.0
 *
 */
public class LSTSchedulingAlgorithm extends SchedulingAlgorithm {

	@Override
	public Vector<TimeBlock> doSchedule() {
		while (this.timeAxis < this.runEndTime) {
			int earlistReleaseTime = Tools.getEarlistRealseTime(this.taskSet);
			if (earlistReleaseTime > this.timeAxis) {
				this.timeAxis = earlistReleaseTime;
				continue;
			}
			// 获取最早可调度任务的索引
			int nextTaskId = this.getLeastSlackTimeTask(this.taskSet, this.timeAxis);
			if (nextTaskId == -1) {
				break;
			}
			// 判断任务类型
			int execTime = this.taskSet.get(nextTaskId).getJobExecTime();
			this.schedulingResult.add(new TimeBlock(nextTaskId, this.timeAxis, execTime));
			this.timeAxis += execTime;
			this.taskSet.get(nextTaskId).run(execTime);
			if (this.taskSet.get(nextTaskId).getClass() == PeriodicTask.class) {
				((PeriodicTask) this.taskSet.get(nextTaskId)).nextCycle();
			}
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
				int slackTime = pTask.getCycleStartTime() + pTask.getJobDeadline() - pTask.getJobExecTime() - nowTime;
				if (realseTime <= nowTime && slackTime <= leastSlackTime) {
					nextTaskId = i;
					leastSlackTime = slackTime;
				}
			} else {
				// 偶发任务和非周期性任务
				int slackTime = taskSet.get(i).getJobDeadline() - taskSet.get(i).getJobExecTime() - nowTime;
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
