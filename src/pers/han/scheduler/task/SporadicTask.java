package pers.han.scheduler.task;

/**
 * ż������
 * 
 * @author		hanYG
 * @createDate	2022��5��29��
 * @alterDate	2022��5��29��
 * 				2022��09��28�� ��ӿ����������������캯��
 * @version		1.0
 *
 */
public class SporadicTask extends Task {
	
	/**
	 * ���캯��
	 * @param jobReleaseTime �ͷ�ʱ��
	 * @param jobExecTime ִ��ʱ��
	 * @param jobDeadline ����ʱ��
	 * @param taskPriority ���ȼ�
	 * @param jobPreempt �Ƿ����ռ
	 */
	public SporadicTask(int jobReleaseTime, int jobExecTime, int jobDeadline, int taskPriority, JobPreemption jobPreempt) {
		this.jobReleaseTime = jobReleaseTime;
		this.jobExecTime = jobExecTime;
		this.jobDeadline = jobDeadline;
		this.taskPriority = taskPriority;
		this.jobPreempt = jobPreempt;
	}
	
	/**
	 * ���캯���������ȼ���������ռ
	 * @param jobReleaseTime �ͷ�ʱ��
	 * @param jobExecTime ִ��ʱ��
	 * @param jobDeadline ����ʱ��
	 */
	public SporadicTask(int jobReleaseTime, int jobExecTime, int jobDeadline) {
		this.jobReleaseTime = jobReleaseTime;
		this.jobExecTime = jobExecTime;
		this.jobDeadline = jobDeadline;
		this.jobPreempt = JobPreemption.NONPREEMPTABLE;
		this.taskPriority = 0;
	}
	
	/**
	 * �������캯��
	 * @param task
	 */
	public SporadicTask(SporadicTask task) {
		this.jobReleaseTime = task.getJobReleaseTime();
		this.jobExecTime = task.getJobExecTime();
		this.jobDeadline = task.getJobDeadline();
		this.taskPriority = task.getTaskPriority();
		this.jobPreempt = task.getJobPreemption();
	}

	@Override
	public Task clone() {
		SporadicTask task = new SporadicTask(this.jobReleaseTime, this.jobExecTime, this.jobDeadline, this.taskPriority, this.jobPreempt);
		return task;
	}

}
