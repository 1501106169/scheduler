package pers.han.scheduler.task;

/**
 * ��������Ļ���
 * FileName: Task.java
 * 
 * @author		hanYG
 * @createDate	2021.05.17
 * @alterDate	2021.05.17
 * @version		1.0
 *
 */
public abstract class Task {
	
	/** �������� */
	protected TaskType taskType;
	
	/** ��������ҵ����ռ */
	protected JobPreemption jobPreempt;
	
	/** ��ҵִ��ʱ�� */
	protected double jobExecTime;
	
	/** ��ҵʱ�� */
	protected double jobDeadline;
	
	/** ��ҵ�ͷ�ʱ�� */
	protected double jobReleaseTime;
	
	/** ���ȼ� */
	protected double taskPriority = 0;
	
	/** ���� */
	
	/**
	 * ��ȡ�������ȼ�
	 * @return Double
	 */
	public double getTaskPriority() {
		return this.taskPriority;
	}
	
	/**
	 * ��ȡ��������
	 * @return	ö������
	 */
	public TaskType getTaskType() {
		return this.taskType;
	}
	
	/**
	 * ��ȡ��ҵ����ռ
	 * @return	ö������
	 */
	public JobPreemption getJobPreemption() {
		return this.jobPreempt;
	}
	
	/**
	 * ��ȡ��ҵִ��ʱ��
	 * @return	Double
	 */
	public double getJobExecTime() {
		return this.jobExecTime;
	}
	
	/**
	 * ��ȡ��ҵʱ��
	 * @return	Double
	 */
	public double getJobDeadline() {
		return this.jobDeadline;
	}
	
	/**
	 * ��ȡ��ҵ�ͷ�ʱ��
	 * @return	Double
	 */
	public double getJobReleaseTime() {
		return this.jobReleaseTime;
	}
	

}
