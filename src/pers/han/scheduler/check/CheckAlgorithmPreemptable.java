package pers.han.scheduler.check;

import pers.han.scheduler.framework.CheckResultEnum;
import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * 校验可抢占任务的校验算法
 * 
 * @author		hanYG
 * @createDate	2022年11月11日
 * @alterDate	2022年11月11日
 * @version		1.0
 *
 */
public class CheckAlgorithmPreemptable extends CheckAlgorithm {

	@Override
	public void tearDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CheckResultEnum doCheck() {
		int nowTime = 0;
		for (TimeBlock tb : this.schedulingResult) {
			// 可行调度的条件
			if (this.taskSet.get(tb.getTaskId()).getClass() == PeriodicTask.class) {
				// 周期性任务
				PeriodicTask pTask = (PeriodicTask) this.taskSet.get(tb.getTaskId());
				if (tb.getStartTime() >= nowTime
						&& tb.getStartTime() >= pTask.getCycleStartTime() + pTask.getJobReleaseTime()
						&& tb.getStartTime() + tb.getExecTime() <= pTask.getCycleStartTime() + pTask.getJobDeadline()) {
					nowTime = tb.getStartTime() + tb.getExecTime();
					pTask.run(tb.getExecTime());
					if (pTask.getRunTime() >= pTask.getJobExecTime()) {
						pTask.nextCycle();
					}
				} else {
					return CheckResultEnum.INFEASIBLE;
				}
			} else {
				Task task = this.taskSet.get(tb.getTaskId());
				if (tb.getStartTime() >= nowTime
						&& tb.getStartTime() >= task.getJobReleaseTime()
						&& tb.getStartTime() + tb.getExecTime() <= task.getJobDeadline()) {
					nowTime = tb.getStartTime() + tb.getExecTime();
					task.run(tb.getExecTime());
				} else {
					return CheckResultEnum.INFEASIBLE;
				}
			}
		}
		for (Task task : this.taskSet) {
			if (task.getClass() == PeriodicTask.class) {
				// 周期性任务
				PeriodicTask pTask = (PeriodicTask) task;
				if (pTask.getCycleStartTime() < this.deadline) {
					return CheckResultEnum.INFEASIBLE;
				}
			} else {
				// 偶发任务和非周期性任务
				if (task.getJobExecTime() > task.getRunTime()) {
					return CheckResultEnum.INFEASIBLE;
				}
			}
		}
		if (nowTime > this.deadline) {
			return CheckResultEnum.INFEASIBLE;
		}
		return CheckResultEnum.FEASIBLE;
	}
	
}
