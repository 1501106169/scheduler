package pers.han.scheduler.task;

/**
 * ����ʵʱ������Ļ���
 * 
 * @author		hanYG
 * @createDate	2022��5��17��
 * @alterDate	2022��10��10�� �޸�ʱ������double->int����ʾ��λʱ�䲻�ɲ��
 * @version		21.0
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
	
	/**
	 * ��ȡ�������ȼ�
	 * @return int
	 */
	public int getTaskPriority() {
		return this.taskPriority;
	}
	
	/**
	 * ��ȡ��ҵ����ռ
	 * @return JobPreemption
	 */
	public JobPreemption getJobPreemption() {
		return this.jobPreempt;
	}
	
	/**
	 * ��ȡ��ҵִ��ʱ��
	 * @return int
	 */
	public int getJobExecTime() {
		return this.jobExecTime;
	}
	
	/**
	 * ��ȡ��ҵʱ��
	 * @return int
	 */
	public int getJobDeadline() {
		return this.jobDeadline;
	}
	
	/**
	 * ��ȡ��ҵ�ͷ�ʱ��
	 * @return int
	 */
	public int getJobReleaseTime() {
		return this.jobReleaseTime;
	}
	
	/**
	 * ��ȡ����������������
	 * @return String
	 */
	public String getClassName() {
		String clsName = this.getClass().getName();
		return clsName.substring(clsName.lastIndexOf(".") + 1);
	}

}
