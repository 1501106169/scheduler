package pers.han.scheduler.task;

/**
 * ����������
 * 
 * @author		hanYG
 * @createDate	2021��6��17��
 * @alterDate	2021��10��10��
 * 				2022��6��19��	�������cycleStartTime
 * 				2022��09��28�� ��ӿ�������
 * @version		1.0
 *
 */
public class PeriodicTask extends Task {
	
	/** �������� */
	protected int taskPeriodic;
	
	/** ��һ�����ڵĿ�ʼʱ�� */
	protected int cycleStartTime = 0;
	
	/**
	 * ���캯��
	 * @param taskPhase ��λ
	 * @param taskPeriodic ����
	 * @param jobExecTime ִ��ʱ��
	 * @param jobDeadline ����ʱ��
	 * @param taskPriority ���ȼ�
	 * @param jobPreempt �Ƿ����ռ
	 */
	public PeriodicTask(int taskPhase, int taskPeriodic, int jobExecTime, int jobDeadline, int taskPriority, JobPreemption jobPreempt) {
		// ��λ���ͷ�ʱ��
		this.jobReleaseTime = taskPhase;
		this.jobDeadline = jobDeadline;
		this.taskPeriodic = taskPeriodic;
		this.jobExecTime = jobExecTime;
		this.taskPriority = taskPriority;
		this.jobPreempt = jobPreempt;
	}
	
	
	/**
	 * ���캯���������ȼ���������ռ
	 * @param taskPhase		�������������λ
	 * @param taskPeriodic	���������������
	 * @param jobExecTime	�����������ִ��ʱ��
	 * @param jobDeadline	�����������ʱ��
	 */
	public PeriodicTask(int taskPhase, int taskPeriodic, int jobExecTime, int jobDeadline) {
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
		this.taskPriority = 0;
	}

	/**
	 * ���캯���������ȼ���������ռ
	 * @param taskPeriodic	���������������
	 * @param jobExecTime	�����������ִ��ʱ��
	 * @param jobDeadline	�����������ʱ��
	 */
	public PeriodicTask(int taskPeriodic, int jobExecTime, int jobDeadline) {
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
		this.taskPriority = 0;
	}
	
	/**
	 * ���캯���������ȼ���������ռ
	 * @param taskPeriodic	���������������
	 * @param jobExecTime	�����������ִ��ʱ��
	 */
	public PeriodicTask(int taskPeriodic, int jobExecTime) {
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
		this.taskPriority = 0;
	}
	
	/**
	 * �������캯��
	 * @param periodicTask ����������
	 */
	public PeriodicTask(PeriodicTask periodicTask) {
		this.jobDeadline = periodicTask.getJobDeadline();
		this.jobExecTime = periodicTask.getJobExecTime();
		this.jobPreempt = periodicTask.getJobPreemption();
		this.jobReleaseTime = periodicTask.getJobReleaseTime();
		this.taskPeriodic = periodicTask.getTaskPeriodic();
		this.taskPriority = periodicTask.getTaskPriority();
	}
	
	/**
	 * ��ȡ��������������
	 * @return int
	 */
	public int getTaskPeriodic() {
		return this.taskPeriodic;
	}
	
	/**
	 * ��ȡ�������������һ�����ڿ�ʼʱ��
	 * @return
	 */
	public int getCycleStartTime() {
		return this.cycleStartTime;
	}
	
	/**
	 * ���������������һ������
	 */
	public void nextCycle() {
		this.cycleStartTime += this.taskPeriodic;
	}

	@Override
	public Task clone() {
		PeriodicTask task = new PeriodicTask(this.jobReleaseTime, this.taskPeriodic, this.jobExecTime, this.jobDeadline, this.taskPriority, this.jobPreempt);
		return task;
	}

}
