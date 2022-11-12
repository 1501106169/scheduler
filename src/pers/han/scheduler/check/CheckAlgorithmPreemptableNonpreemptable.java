package pers.han.scheduler.check;

import pers.han.scheduler.framework.CheckResultEnum;
import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * 校验不可抢占任务的校验算法
 * 
 * @author		hanYG
 * @createDate	2022年11月10日
 * @alterDate	2022年11月10日
 * @version		1.0
 *
 */
public class CheckAlgorithmPreemptableNonpreemptable extends CheckAlgorithm {
	
	@Override
	public void tearDown() {
		// TODO Auto-generated method stub
	}

	@Override
	public CheckResultEnum doCheck() {
		for (TimeBlock tb : this.schedulingResult) {
			if (this.taskSet.get(tb.getTaskId()).getClass() == pers.han.scheduler.task.PeriodicTask.class) {
				// 周期性任务
				PeriodicTask pTask = (PeriodicTask) this.taskSet.get(tb.getTaskId());
				if (tb.getStartTime() >= pTask.getCycleStartTime() + pTask.getJobReleaseTime() 
					&& tb.getStartTime() + tb.getExecTime() <= pTask.getCycleStartTime() + pTask.getJobDeadline() 
					&& tb.getExecTime() >= pTask.getJobExecTime()) {
					pTask.nextCycle();
				} else {
					return CheckResultEnum.INFEASIBLE;
				}
			} else {
				// 偶发任务和非周期性任务
				Task task = this.taskSet.get(tb.getTaskId());
				if (task.getRunTime() >= task.getJobExecTime()) {
					// 任务执行过
					return CheckResultEnum.INFEASIBLE;
				} else if (tb.getStartTime() >= task.getJobReleaseTime() 
						&& tb.getExecTime() >= task.getJobExecTime() 
						&& tb.getStartTime() + tb.getExecTime() <= task.getJobDeadline()) {
					task.run(tb.getExecTime());
				} else {
					return CheckResultEnum.INFEASIBLE;
				}
			}
		}
		for (Task task : this.taskSet) {
			if (task.getClass() == pers.han.scheduler.task.PeriodicTask.class) {
				// 周期性任务
				if (((PeriodicTask) task).getCycleStartTime() < this.deadline) {
					return CheckResultEnum.INFEASIBLE;
				}
			} else {
				// 偶发任务和非周期性任务
				if (task.getRunTime() < task.getJobExecTime()) {
					return CheckResultEnum.INFEASIBLE;
				}
			}
		}
		return CheckResultEnum.FEASIBLE;
	}
	
}
