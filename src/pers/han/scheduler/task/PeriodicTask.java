package pers.han.scheduler.task;

/**
 * ������ռ������������
 * FileName: PeriodicTask.java
 * 
 * @author		hanYG
 * @createDate	2021.06.17
 * @alterDate	2021.10.10
 * @version		1.0
 *
 */
public final class PeriodicTask extends Task {
	
	/** �������� */
	protected int taskPeriodic;
	
	/**
	 * ���캯��
	 * @param taskPhase		�������������λ
	 * @param taskPeriodic	���������������
	 * @param jobExecTime	�����������ִ��ʱ��
	 * @param jobDeadline	�����������ʱ��
	 */
	public PeriodicTask(int taskPhase, int taskPeriodic, int jobExecTime, int jobDeadline) {
		// ����������
		this.taskType = TaskType.PERIODIC;
		// ������ռ
		this.jobPreempt = JobPreemption.NONPREEMPTABLE;
		// ʱ��
		this.jobDeadline = jobDeadline;
		// ����
		this.taskPeriodic = taskPeriodic;
		// ִ��ʱ��
		this.jobExecTime = jobExecTime;
		// ��λ
		this.jobReleaseTime = taskPhase;
	}
	
	/**
	 * ���캯��
	 * @param taskPeriodic	���������������
	 * @param jobExecTime	�����������ִ��ʱ��
	 * @param jobDeadline	�����������ʱ��
	 */
	public PeriodicTask(int taskPeriodic, int jobExecTime, int jobDeadline) {
		// ����������
		this.taskType = TaskType.PERIODIC;
		// ������ռ
		this.jobPreempt = JobPreemption.NONPREEMPTABLE;
		// ʱ��
		this.jobDeadline = jobDeadline;
		// ����
		this.taskPeriodic = taskPeriodic;
		// ִ��ʱ��
		this.jobExecTime = jobExecTime;
		// ��λ��λ����0
		this.jobReleaseTime = 0;
	}
	
	/**
	 * ���캯��
	 * @param taskPeriodic	���������������
	 * @param jobExecTime	�����������ִ��ʱ��
	 */
	public PeriodicTask(int taskPeriodic, int jobExecTime) {
		// ����������
		this.taskType = TaskType.PERIODIC;
		// ������ռ
		this.jobPreempt = JobPreemption.NONPREEMPTABLE;
		// ʱ�޵�������
		this.jobDeadline = taskPeriodic;
		// ����
		this.taskPeriodic = taskPeriodic;
		// ִ��ʱ��
		this.jobExecTime = jobExecTime;
		// ��λ����0
		this.jobReleaseTime = 0;
	}
	
	/**
	 * ��ȡ��������������
	 * @return	Integer
	 */
	public int getTaskPeriodic() {
		return this.taskPeriodic;
	}

}
