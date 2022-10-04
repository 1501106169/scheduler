package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * 调度周期性任务的算法
 * 
 * @author		hanYG
 * @createDate	2022年6月2日
 * @alterDate	2022年6月2日
 * @version		1.0
 *
 */
public class PeriodicSchedulingAlgorithm extends SchedulingAlgorithm {

	@Override
	public Vector<TimeBlock> doSchedule() {
		Vector<PeriodicTask> periodicTaskSet = new Vector<PeriodicTask>();
		for (Task task : this.taskSet) {
			periodicTaskSet.add((PeriodicTask)task.clone());
		}
		while (this.timeAxis < this.runEndTime) {
			int earlistReleaseTime = this.getEarlistRealseTime(periodicTaskSet);
			if (earlistReleaseTime > this.timeAxis) {
				this.timeAxis = earlistReleaseTime;
				continue;
			}
			
			int nextTaskId = this.getEarlistTask(periodicTaskSet, this.timeAxis);
			int execTime = periodicTaskSet.get(nextTaskId).getJobExecTime();
			this.schedulingResult.add(new TimeBlock(nextTaskId, this.timeAxis, execTime));
			this.timeAxis += execTime;
			periodicTaskSet.get(nextTaskId).nextCycle();
		}
		return this.schedulingResult;
	}
	
	/**
	 * 从就绪的任务中选择截至时间最小的任务
	 * @param periodicTaskSet 周期性任务集
	 * @param nowTime 现在的时间
	 * @return int
	 */
	private int getEarlistTask(Vector<PeriodicTask> periodicTaskSet, int nowTime) {
		int nextTaskId = -1;
		for (int i = 0; i < periodicTaskSet.size(); ++i) {
			if (nextTaskId == -1 && periodicTaskSet.get(i).getCycleStartTime() + periodicTaskSet.get(i).getJobReleaseTime() <= nowTime) {
				nextTaskId = i;
			} else if (nextTaskId != -1 && periodicTaskSet.get(i).getCycleStartTime() + periodicTaskSet.get(i).getJobDeadline() < periodicTaskSet.get(nextTaskId).getCycleStartTime() + periodicTaskSet.get(nextTaskId).getJobDeadline()) {
				nextTaskId = i;
			}
		}
		return nextTaskId;
	}
	
	/**
	 * 获取作业的最早释放时间
	 * @param periodicTaskSet 周期性任务集
	 * @return int
	 */
	private int getEarlistRealseTime(Vector<PeriodicTask> periodicTaskSet) {
		if (periodicTaskSet.isEmpty()) {
			// -1 表示作业为空
			return -1;
		}
		int realseTime =  periodicTaskSet.get(0).getCycleStartTime() + periodicTaskSet.get(0).getJobReleaseTime();
		for (PeriodicTask periodicTask : periodicTaskSet) {
			int time = periodicTask.getCycleStartTime() + periodicTask.getJobReleaseTime(); 
			if (time < realseTime) {
				realseTime = time;
			}
		}
		return realseTime;
	}
	
	
}
