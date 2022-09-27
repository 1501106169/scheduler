package pers.han.scheduler.check;

import java.util.Vector;

import pers.han.scheduler.framework.CheckResultEnum;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

/**
 * У���㷨�Ļ���
 * 
 * @author		hanYG
 * @createDate	2022��6��1��
 * @alterDate	2022��6��1��
 * @version		1.0
 *
 */
public abstract class CheckAlgorithm {
	/** һ��ʵʱ���� */
	Vector<Task> taskSet;
	
	/** ���Ƚ�� */
	Vector<TimeBlock> schedulingResult;
	
	/** �����㷨ִ�е�ʱ�� */
	int deadline;
	
	/**
	 * ���캯��
	 */
	public CheckAlgorithm() {
		
	}
	
	/**
	 * ��ʼ����Ա��������doCheck����ǰִ��
	 * @param taskSet
	 * @param schedulingResult
	 */
	public void setUp(Vector<Task> taskSet, Vector<TimeBlock> schedulingResult, int deadline) {
		this.taskSet = taskSet;
		this.schedulingResult = schedulingResult;
		this.deadline = deadline;
	}
	
	/**
	 * ��doCheck������ִ��
	 */
	public void tearDown() {
		
	}
	
	/**
	 * ִ��У���㷨
	 * @param taskSet һ��ʵʱ����
	 * @param schedulingResult ���Ƚ��
	 * @return CheckResultEnum
	 */
	public abstract CheckResultEnum doCheck();
	
	
}
