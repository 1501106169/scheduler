package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.algroithms.Tools;
import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * DM不可抢占调度算法
 * 周期性任务的固定优先级调度算法
 * 周期性任务的相对时限越短优先级越高
 * 
 * @author		hanYG
 * @createDate	2022年11月11日
 * @alterDate	2022年11月11日
 * @version		1.0
 *
 */
public class DMPeriodicSchedulingAlgorithm extends SchedulingAlgorithm {

	@Override
	public Vector<TimeBlock> doSchedule() {
		for (Task task : this.taskSet) {
			// 数字越小优先级越高
			task.setTaskPriority(task.getJobDeadline());
		}
		while (this.timeAxis < this.runEndTime) {
			int earlistReleaseTime = Tools.getEarlistRealseTime(this.taskSet);
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
			if (this.taskSet.get(nextTaskId).getClass() == PeriodicTask.class) {
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
		int priority = Integer.MAX_VALUE;
		for (int i = 0; i < taskSet.size(); ++i) {
			PeriodicTask pTask = (PeriodicTask) taskSet.get(i);
			int realseTime = pTask.getCycleStartTime() + pTask.getJobReleaseTime();
			if (realseTime <= nowTime && pTask.getTaskPriority() < priority) {
				nextTaskId = i;
				priority = pTask.getTaskPeriodic();
			}
		}
		return nextTaskId;
	}
	
}
