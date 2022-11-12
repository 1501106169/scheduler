package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.algroithms.Tools;
import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * RM不可抢占任务调度
 * 周期性任务固定优先级调度算法
 * 任务周期越短优先级越高
 * 
 * @author		hanYG
 * @createDate	2022年11月11日
 * @alterDate	2022年11月11日
 * @version		1.0
 *
 */
public class RMPeriodicSchedulingAlgorithm extends SchedulingAlgorithm {

	@Override
	public Vector<TimeBlock> doSchedule() {
		while (this.timeAxis < this.runEndTime) {
			int earlistReleaseTime = Tools.getEarlistRealseTime(this.taskSet);
			if (earlistReleaseTime > this.timeAxis) {
				this.timeAxis = earlistReleaseTime;
				continue;
			}
			// 获取最早可调度任务的索引
			int nextTaskId = this.getPeriodicMinTask(this.taskSet, this.timeAxis);
			if (nextTaskId == -1) {
				break;
			}
			int execTime = this.taskSet.get(nextTaskId).getJobExecTime();
			this.schedulingResult.add(new TimeBlock(nextTaskId, this.timeAxis, execTime));
			this.timeAxis += execTime;
			this.taskSet.get(nextTaskId).run(execTime);
			((PeriodicTask) this.taskSet.get(nextTaskId)).nextCycle();
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
		int minPeriodic = this.runEndTime;
		for (int i = 0; i < taskSet.size(); ++i) {
			PeriodicTask task = (PeriodicTask) taskSet.get(i);
			if (task.getCycleStartTime() + task.getJobReleaseTime() <= nowTime 
					&& task.getTaskPeriodic() < minPeriodic) {
				minPeriodic = task.getTaskPeriodic();
				nextTaskId = i;
			}
		}
		return nextTaskId;
	}

}
