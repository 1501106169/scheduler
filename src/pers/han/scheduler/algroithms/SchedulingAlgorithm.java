package pers.han.scheduler.algroithms;

import java.util.Vector;

import pers.han.scheduler.task.Task;

/**
 * �����㷨�Ļ���
 * 
 * @author		hanYG
 * @createDate	2022��5��29��
 * @alterDate	2022��5��29��
 * @version		1.0
 *
 */
public abstract class SchedulingAlgorithm {
	/** һ��ʵʱ���� */
	Vector<Task> TaskSet;
	
	/** ��ǰʱ�� */
	int timeAxis = 0;
	
	/** �����㷨���н���ʱ�� */
	int runEndTime;
	
	/**
	 * ���캯��
	 * @param taskSet һ��ʵʱ����
	 * @param runEndTime �㷨���н���ʱ��
	 */
	public SchedulingAlgorithm(Vector<Task> taskSet, int runEndTime) {
		this.TaskSet = taskSet;
		this.runEndTime = runEndTime;
	}
	
	/**
	 * ��ʵʱ���������һ��ż�����񡣵���ż������ĵ����㷨��ʵʱ��Ҫ��д
	 * @param sporadicTask
	 */
	public void addTask(Task sporadicTask) {
		return;
	}
	
}
