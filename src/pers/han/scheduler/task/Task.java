package pers.han.scheduler.task;

/**
 * ��������Ļ���
 * FileName: Task.java
 * 
 * @author		hanYG
 * @createDate	2021.05.17
 * @alterDate	2021.10.10	�޸�ʱ������double->int��1��ʾ��λʱ�䲻�ɲ��
 * @version		2.0
 *
 */
public abstract class Task {
	
	/** �������� */
	// protected TaskType taskType;
	
	/** ��������ҵ����ռ */
	protected JobPreemption jobPreempt;
	
	/** ��ҵִ��ʱ�� */
	protected int jobExecTime;
	
	/** ��ҵʱ�� */
	protected int jobDeadline;
	
	/** ��ҵ�ͷ�ʱ�� */
	protected int jobReleaseTime;
	
	/** ���ȼ� */
	protected int taskPriority = 0;
	
	/** ���� */
	
	/**
	 * ��ȡ�������ȼ�
	 * @return Integer
	 */
	public int getTaskPriority() {
		return this.taskPriority;
	}
	
	/**
	 * ��ȡ��������
	 * @return	ö������
	 */
	// public TaskType getTaskType() {
		// return this.taskType;
	// }
	
	/**
	 * ��ȡ��ҵ����ռ
	 * @return	ö������
	 */
	public JobPreemption getJobPreemption() {
		return this.jobPreempt;
	}
	
	/**
	 * ��ȡ��ҵִ��ʱ��
	 * @return	Integer
	 */
	public int getJobExecTime() {
		return this.jobExecTime;
	}
	
	/**
	 * ��ȡ��ҵʱ��
	 * @return	Integer
	 */
	public int getJobDeadline() {
		return this.jobDeadline;
	}
	
	/**
	 * ��ȡ��ҵ�ͷ�ʱ��
	 * @return	Integer
	 */
	public int getJobReleaseTime() {
		return this.jobReleaseTime;
	}
	

}
