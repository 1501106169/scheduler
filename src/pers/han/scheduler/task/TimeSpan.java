package pers.han.scheduler.task;

// import java.util.Iterator;

/**
 * ��ʾ�������һ��ִ��ʱ���
 * FileName: TimeSpan.java
 * 
 * @author		hanYG
 * @createDate	2021.06.18
 * @alterDate	2021.09.14
 * @version		2.0
 *
 */
public final class TimeSpan {
	
	/** ������ */
	// protected int id;
	
	/** ��ʼʱ�� */
	protected double startTime;
	
	/** ����ʱ�� */
	protected double endTime;
	
	/** �������� */
	protected double periodic;
	
	/**
	 * ���캯��
	 * @param startTime		��ʼʱ��
	 * @param endTime		����ʱ��
	 * @param periodic		��������
	 */
	public TimeSpan(double startTime, double endTime, double periodic) {
		// this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.periodic = periodic;
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
	 * @return	Double
	 */
	public double getStartTime() {
		return this.startTime;
	}
	
	/**
	 * ��ȡ�����ʱ��
	 * @return	Double
	 */
	public double getEndTime() {
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
