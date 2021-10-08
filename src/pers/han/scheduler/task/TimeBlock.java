package pers.han.scheduler.task;

/**
 * ÿ��ʱ����ִ�е�����
 * FileName: TimeBlock.java
 * 
 * @author		hanYG
 * @createDate	2021.06.18
 * @alterDate	2021.06.17
 * @version		1.0
 *
 */
public final class TimeBlock {
	
	/** ������ */
	protected int id;
	
	/** ��ʼʱ�� */
	protected double startTime;
	
	/** ִ��ʱ�� */
	protected double execTime;
	
	/**
	 * ���캯��
	 * @param id		������
	 * @param startTime	��ʼʱ��
	 * @param execTime	ִ��ʱ��
	 */
	public TimeBlock(int id, double startTime, double execTime) {
		this.id = id;
		this.startTime = startTime;
		this.execTime = execTime;
	}
	
	/**
	 * ��ȡ������
	 * @return	Integer
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * ��ȡ����ʼʱ��
	 * @return	Double
	 */
	public double getStartTime() {
		return this.startTime;
	}
	
	/**
	 * ��ȡ����ִ��ʱ��
	 * @return	Double
	 */
	public double getExecTime() {
		return this.execTime;
	}
}
