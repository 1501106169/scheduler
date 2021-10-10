package pers.han.scheduler.task;

/**
 * ÿ��ʱ����ִ�е�����
 * FileName: TimeBlock.java
 * 
 * @author		hanYG
 * @createDate	2021.06.18
 * @alterDate	2021.10.10	�޸�ʱ������double->int
 * @version		2.0
 *
 */
public final class TimeBlock {
	
	/** ������ */
	protected int id;
	
	/** ��ʼʱ�� */
	protected int startTime;
	
	/** ִ��ʱ�� */
	protected int execTime;
	
	/**
	 * ���캯��
	 * @param id		������
	 * @param startTime	��ʼʱ��
	 * @param execTime	ִ��ʱ��
	 */
	public TimeBlock(int id, int startTime, int execTime) {
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
	 * @return	Integer
	 */
	public int getStartTime() {
		return this.startTime;
	}
	
	/**
	 * ��ȡ����ִ��ʱ��
	 * @return	Integer
	 */
	public int getExecTime() {
		return this.execTime;
	}
}
