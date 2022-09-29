package pers.han.scheduler.task;

/**
 * �����ִ��ʱ���
 * 
 * @author		hanYG
 * @createDate	2022��5��29��
 * @alterDate	2022��5��29��
 * 				2022��6��5�� �޸�task Ϊ taskId 
 * 				2022��09��28�� ��ӿ����������������캯��
 * @version		2.0
 *
 */
public class TimeBlock {
	// protected Task task;
	/** ����Id */
	protected int taskId;
	
	/** ��ʼʱ�� */
	protected int startTime;
	
	/** ִ��ʱ�� */
	protected int execTime;

	/**
	 * ���캯��
	 * @param taskId ָ��ĳ������
	 * @param startTime ����ʼִ��ʱ��
	 * @param execTime ����ִ��ʱ��
	 */
	public TimeBlock(int taskId, int startTime, int execTime) {
		this.taskId = taskId;
		this.startTime = startTime;
		this.execTime = execTime;
	}
	
	/**
	 * �������캯��
	 * @param tb
	 */
	public TimeBlock(TimeBlock tb) {
		this.taskId = tb.getTaskId();
		this.startTime = tb.getStartTime();
		this.execTime = tb.getExecTime();
	}

	/**
	 * ��ȡ����
	 * @return int
	 */
	public int getTaskId() {
		return this.taskId;
	}
	
	/**
	 * ��ȡ����ʼʱ��
	 * @return int
	 */
	public int getStartTime() {
		return this.startTime;
	}
	
	/**
	 * ��ȡ����ִ��ʱ��
	 * @return int
	 */
	public int getExecTime() {
		return this.execTime;
	}
	
	/**
	 * ��������
	 */
	public TimeBlock clone() {
		TimeBlock tb = new TimeBlock(this.taskId, this.startTime, this.execTime);
		return tb;
	}
	
}
