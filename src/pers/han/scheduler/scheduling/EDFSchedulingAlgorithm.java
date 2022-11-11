package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * EDF不可抢占调度算法
 * 任务的时限越早优先级越高
 * 
 * @author		hanYG
 * @createDate	2022年11月9日
 * @alterDate	2022年11月9日
 * @version		1.0
 *
 */
public class EDFSchedulingAlgorithm extends SchedulingAlgorithm {

	@Override
	public Vector<TimeBlock> doSchedule() {
		while (this.timeAxis < this.runEndTime) {
			int earlistReleaseTime = this.getEarlistRealseTime(this.taskSet);
			if (earlistReleaseTime > this.timeAxis) {
				this.timeAxis = earlistReleaseTime;
				continue;
			}
			// 获取最早可调度任务的索引
			int nextTaskId = this.getEarlistTask(this.taskSet, this.timeAxis);
			if (nextTaskId == -1) {
				break;
			}
			// 判断任务类型
			int execTime = this.taskSet.get(nextTaskId).getJobExecTime();
			this.schedulingResult.add(new TimeBlock(nextTaskId, this.timeAxis, execTime));
			this.timeAxis += execTime;
			this.taskSet.get(nextTaskId).run(execTime);
			if (this.taskSet.get(nextTaskId).getClass() == pers.han.scheduler.task.PeriodicTask.class) {
				((PeriodicTask) this.taskSet.get(nextTaskId)).nextCycle();
			}
		}
		return this.schedulingResult;
	}

	/**
	 * 从就绪的任务中选择截至时间最小的任务
	 * @param taskSet 任务集
	 * @param nowTime 当前时刻
	 * @return Integer
	 */
	private int getEarlistTask(final Vector<Task> taskSet, final int nowTime) {
		int nextTaskId = -1;
		int leastDeadline = this.runEndTime;
		for (int i = 0; i < taskSet.size(); ++i) {
			if (taskSet.get(i).getClass() == pers.han.scheduler.task.PeriodicTask.class) {
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
	
	/**
	 * 获取作业的最早释放时间
	 * @param taskSet 任务集
	 * @return Integer
	 */
	private int getEarlistRealseTime(final Vector<Task> taskSet) {
		if (taskSet.isEmpty()) {
			// -1 表示作业为空
			return -1;
		}
		int leastRealseTime =  this.runEndTime;
		for (Task task : taskSet) {
			if (task.getClass() == pers.han.scheduler.task.PeriodicTask.class) {
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
