package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * ����������������㷨
 * 
 * @author		hanYG
 * @createDate	2022��6��2��
 * @alterDate	2022��6��2��
 * @version		1.0
 *
 */
public class PeriodicSchedulingAlgorithm extends SchedulingAlgorithm {

	@Override
	public Vector<TimeBlock> doSchedule() {
		Vector<PeriodicTask> periodicTaskSet = new Vector<PeriodicTask>();
		for (Task task : this.taskSet) {
			periodicTaskSet.add((PeriodicTask)task);
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
	 * �Ӿ�����������ѡ�����ʱ����С������
	 * @param periodicTaskSet ����������
	 * @param nowTime ���ڵ�ʱ��
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
	 * ��ȡ��ҵ�������ͷ�ʱ��
	 * @param periodicTaskSet ����������
	 * @return int
	 */
	private int getEarlistRealseTime(Vector<PeriodicTask> periodicTaskSet) {
		if (periodicTaskSet.isEmpty()) {
			// -1 ��ʾ��ҵΪ��
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
