package pers.han.scheduler.task;

/**
 * ������������
 * 
 * @author		hanYG
 * @createDate	2022��5��29��
 * @alterDate	2022��5��29��
 * @version		1.0
 *
 */
public class AperiodicTask extends Task {
	
	/**
	 * ���캯��
	 * @param jobReleaseTime �ͷ�ʱ��
	 * @param jobExecTime ִ��ʱ��
	 * @param jobDeadline ��ֹʱ��
	 * @param taskPriority ���ȼ�
	 * @param jobPreempt �Ƿ����ռ
	 */
	public AperiodicTask(int jobReleaseTime, int jobExecTime, int jobDeadline, int taskPriority, JobPreemption jobPreempt) {
		this.jobReleaseTime = jobReleaseTime;
		this.jobExecTime = jobExecTime;
		this.jobDeadline = jobDeadline;
		this.taskPriority = taskPriority;
		this.jobPreempt = jobPreempt;
	}
	
	/**
	 * ���캯������ҵ�����ȼ���������ռ
	 * @param jobReleaseTime �ͷ�ʱ��
	 * @param jobExecTime ִ��ʱ��
	 * @param jobDeadline ��ֹʱ��
	 */
	public AperiodicTask(int jobReleaseTime, int jobExecTime, int jobDeadline) {
		this.jobReleaseTime = jobReleaseTime;
		this.jobExecTime = jobExecTime;
		this.jobDeadline = jobDeadline;
		this.jobPreempt = JobPreemption.NONPREEMPTABLE;
		this.taskPriority = 0;
	}
	
}
