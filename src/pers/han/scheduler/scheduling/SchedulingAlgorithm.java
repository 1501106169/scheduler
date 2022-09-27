package pers.han.scheduler.scheduling;

import java.util.Vector;

import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * �����㷨�Ļ���
 * 
 * @author		hanYG
 * @createDate	2022��6��1��
 * @alterDate	2022��6��1��
 * @version		1.0
 *
 */
public abstract class SchedulingAlgorithm {
	/** һ��ʵʱ���� */
	Vector<Task> taskSet;
	/** �㷨���н���ʱ�� */
	int runEndTime;
	/** �㷨���е�ʱ���� */
	int timeAxis = 0;
	/** ���Ƚ�� */
	Vector<TimeBlock> schedulingResult = new Vector<TimeBlock>();
	
	/**
	 * ���캯��
	 */
	public SchedulingAlgorithm() {
	}
	
	/**
	 * ��ʼ����Ա��������doSchedule����ִ��ǰִ��
	 * @param taskSet һ��ʵʱ����
	 * @param runEndTime �㷨ִ�н���ʱ��
	 */
	public void setUp(Vector<Task> taskSet, int runEndTime) {
		this.taskSet = taskSet;
		this.runEndTime = runEndTime;
	}
	
	/**
	 * ��doSchedule����ִ�к�ִ��
	 */
	public void tearDown() {
		
	}
	
	/**
	 * ִ�е����㷨
	 * @return Vector<TimeBlock>
	 */
	public abstract Vector<TimeBlock> doSchedule();
	
	/**
	 * ��ʵʱ���������һ��ż�����񣬵���ż������ĵ����㷨��Ҫ��д�˷���
	 * @param sporadicTask ż������
	 * @param runEndTime ���ż��������㷨ִ�н�ֹʱ��
	 */
	public void addTask(Task sporadicTask, int runEndTime) {
		return;
	}
	
	/**
	 * ��ȡ���Ƚ��
	 * @return Vector<TimeBlock>
	 */
	public Vector<TimeBlock> getSchedulingResult() {
		return this.schedulingResult;
	}
	
}
