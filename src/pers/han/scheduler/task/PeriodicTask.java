package pers.han.scheduler.task;

/**
 * ������ռ������������
 * FileName: PeriodicTask.java
 * 
 * @author	hanYG
 * @date	2021.06.17
 * @version	1.0
 *
 */
public class PeriodicTask extends Task {
	
	/** �������� */
	protected double taskPeriodic;
	
	/**
	 * ���캯��
	 * @param taskPhase		�������������λ
	 * @param taskPeriodic	���������������
	 * @param jobExecTime	�����������ִ��ʱ��
	 * @param jobDeadline	�����������ʱ��
	 */
	public PeriodicTask(double taskPhase, double taskPeriodic, double jobExecTime, double jobDeadline) {
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
	public PeriodicTask(double taskPeriodic, double jobExecTime, double jobDeadline) {
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
	public PeriodicTask(double taskPeriodic, double jobExecTime) {
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
	 * @return	Double
	 */
	public double getTaskPeriodic() {
		return this.taskPeriodic;
	}

}
