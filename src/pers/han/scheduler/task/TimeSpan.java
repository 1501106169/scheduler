package pers.han.scheduler.task;

// import java.util.Iterator;

// ����

/**
 * ��ʾ�������һ��ִ��ʱ���
 * FileName: TimeSpan.java
 * 
 * @author		hanYG
 * @createDate	2021.06.18
 * @alterDate	2021.10.10	�޸�ʱ������double->int
 * 							���ִ��ʱ��
 * @version		2.0
 *
 */
public final class TimeSpan {
	
	/** ������ */
	// protected int id;
	
	/** ��ʼʱ�� */
	protected int startTime;
	
	/** ����ʱ�� */
	protected int endTime;
	
	/** ִ��ʱ�� */
	protected int execTime;
	
	/** �������� */
	protected int periodic;
	
	/**
	 * ���캯��
	 * @param startTime		��ʼʱ��
	 * @param endTime		����ʱ��
	 * @param periodic		��������
	 */
	public TimeSpan(int startTime, int endTime, int execTime, int periodic) {
		// this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.periodic = periodic;
		this.execTime = execTime;
		return;
	}
	
	/**
	 * ���캯��
	 * @param periodicTask	һ������������
	 */
	public TimeSpan(PeriodicTask periodicTask) {
		this.startTime = periodicTask.getJobReleaseTime();
		this.endTime = periodicTask.getJobDeadline();
		this.periodic = periodicTask.getTaskPeriodic();
		this.execTime = periodicTask.getJobExecTime();
		return;
	}

	/**
	 * ������һ��ʱ������
	 */
	public void nextPeriodic() {
		this.startTime = this.endTime;
		this.endTime += this.periodic;
		return;
	}
	
	/**
	 * ��ȡ��ҵִ��ʱ��
	 * @return	Integer
	 */
	public int getExecTime() {
		return this.execTime;
	}
	
	/**
	 * ��ȡ������
	 * @return	Integer
	 */
	/*
	public int getId() {
		return this.id;
	}
	*/
	
	/**
	 * ��ȡ������ͷ�ʱ��
	 * @return	Integer
	 */
	public int getStartTime() {
		return this.startTime;
	}
	
	/**
	 * ��ȡ�����ʱ��
	 * @return	Integer
	 */
	public int getEndTime() {
		return this.endTime;
	}
	
	/**
	 * ���������ͷ�ʱ��
	 * @param startTime	����ʼʱ��
	 */
	/*
	public void setStartTime(double startTime) {
		this.startTime = startTime;
		return;
	}
	*/
	
	/**
	 * ���������ʱ��
	 * @param endTime	����ʱ��
	 */
	/*
	public void setEndTime(double endTime) {
		this.endTime = endTime;
		return;
	}
	*/

}
