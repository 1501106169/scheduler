package pers.han.scheduler.task;

/**
 * �������������һ������
 * 
 * @author		hanYG
 * @createDate	2022��5��29��
 * @alterDate	2022��5��29��
 * 				2022��6��5��		���taskId
 * 				2022��6��29��	����
 * @version		1.1
 *
 */
public class NextCycle extends Task {
	/** ���������� */
	protected PeriodicTask periodicTask;
	
	/** ����Id */
	protected int taskId;
	
	/** ��һ�����ڵĿ�ʼʱ�� */
	protected int cycleStartTime = 0;
	
	/**
	 * ���캯��������������������
	 * @param periodicTask ����������
	 */
	public NextCycle(PeriodicTask periodicTask, int taskId) {
		this.periodicTask = periodicTask;
		this.cycleStartTime = 0;
		this.jobPreempt = periodicTask.getJobPreemption();
		this.jobExecTime = periodicTask.getJobExecTime();
		this.jobDeadline = periodicTask.getJobDeadline();
		this.jobReleaseTime = periodicTask.getJobReleaseTime();
		this.taskPriority = periodicTask.getTaskPriority();
		this.taskId = taskId;
	}
	
	/**
	 * ��ȡ�������������һ�����ڿ�ʼʱ��
	 * @return
	 */
	public int getCycleStartTime() {
		return this.cycleStartTime;
	}
	
	/**
	 * ������������������ڽ�����һ������
	 */
	public void setNextCycle() {
		this.cycleStartTime += this.periodicTask.getTaskPeriodic();
		this.jobReleaseTime = this.cycleStartTime + this.periodicTask.getJobReleaseTime();
		this.jobDeadline = this.cycleStartTime + this.periodicTask.getJobDeadline();
	}
	
	/**
	 * ��ȡ����
	 * @return PeriodicTask
	 */
	public PeriodicTask getTask() {
		return this.periodicTask;
	}
	
	/**
	 * ��ȡ����id
	 */
	public int getTaskId() {
		return this.taskId;
	}
	
}
