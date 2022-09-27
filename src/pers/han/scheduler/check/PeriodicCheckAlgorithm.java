package pers.han.scheduler.check;

import java.util.Vector;

import pers.han.scheduler.framework.CheckResultEnum;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.TimeBlock;

/**
 * 校验周期性任务调度结果
 * 
 * @author		hanYG
 * @createDate	2022年6月2日
 * @alterDate	2022年6月2日
 * @version		1.0
 *
 */
public class PeriodicCheckAlgorithm extends CheckAlgorithm {

	@Override
	public CheckResultEnum doCheck() {
		Vector<PeriodicTask> periodicTaskSet = new Vector<PeriodicTask>();
		for (Task task : this.taskSet) {
			periodicTaskSet.add((PeriodicTask)task);
		}

		for (TimeBlock timeBlock : this.schedulingResult) {
			if (timeBlock.getStartTime() >= periodicTaskSet.get(timeBlock.getTaskId()).getCycleStartTime()
					&& timeBlock.getStartTime() + timeBlock.getExecTime() <= periodicTaskSet.get(timeBlock.getTaskId()).getCycleStartTime() + periodicTaskSet.get(timeBlock.getTaskId()).getJobDeadline()
					&& timeBlock.getExecTime() == periodicTaskSet.get(timeBlock.getTaskId()).getJobExecTime()) {
				periodicTaskSet.get(timeBlock.getTaskId()).nextCycle();
				break;
			} else {
				return CheckResultEnum.INFEASIBLE;
			}
		}
		for (PeriodicTask periodicTask : periodicTaskSet) {
			if (periodicTask.getCycleStartTime() < this.deadline) {
				return CheckResultEnum.INFEASIBLE;
			}
		}
		return CheckResultEnum.FEASIBLE;
	}

}
