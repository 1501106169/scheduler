package pers.han.scheduler.framework;

import java.util.Vector;

import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;
import pers.han.scheduler.scheduling.SchedulingAlgorithm;
import pers.han.scheduler.check.CheckAlgorithm;

/**
 * �����㷨��һ������������
 * 
 * @author		hanYG
 * @createDate	2022��6��2��
 * @alterDate	2022��6��2��
 * @version		1.0
 *
 */
public class RunAlgorithmCase implements RunAlgorithm {
	/** һ��ʵʱ���� */
	Vector<Task> taskSet;
	
	/** ���Ƚ�� */
	Vector<TimeBlock> schedulingResult;
	
	/** У�������㷨������ */
	CheckResultEnum checkResult;
	
	/** �����㷨 */
	SchedulingAlgorithm schedulingAlgorithm = null;
	
	/** У���㷨 */
	CheckAlgorithm checkAlgorithm = null;
	
	/** �����㷨ִ��ʱ�� */
	long execTime;
	
	/** �����㷨���н���ʱ�� */
	int deadline;

	@Override
	public void run() {
		this.runSchedulingAlgorithm();
		this.runCheckAlgorithm();
	}

	@Override
	public void runSchedulingAlgorithm() {
		long startTime = System.currentTimeMillis();		
		// ����ָ���㷨����ʱ�䣬����ʱ��Ϊһ��������
		this.schedulingAlgorithm.setUp(this.taskSet, this.deadline);
		Vector<TimeBlock> result = this.schedulingAlgorithm.doSchedule();
		this.schedulingResult = result;
		this.schedulingAlgorithm.tearDown();
		long endTime = System.currentTimeMillis();
		this.execTime = endTime - startTime;
	}

	@Override
	public void runCheckAlgorithm() {
		this.checkAlgorithm.setUp(this.taskSet, this.schedulingResult, this.deadline);
		CheckResultEnum result = this.checkAlgorithm.doCheck();
		this.checkResult = result;
		this.checkAlgorithm.tearDown();
	}
	
	/**
	 * ���캯����ָ�����񡢵����㷨��У���㷨
	 * @param taskSet ����
	 * @param schedulingAlgorithm �����㷨����
	 * @param checkAlgorithm У���㷨����
	 * @param deadline �����㷨���н���ʱ��
	 */
	public RunAlgorithmCase(Vector<Task> taskSet, SchedulingAlgorithm schedulingAlgorithm, CheckAlgorithm checkAlgorithm, int deadline) {
		this.taskSet = taskSet;
		this.schedulingAlgorithm = schedulingAlgorithm;
		this.checkAlgorithm = checkAlgorithm;
		this.deadline = deadline;
	}
	
	/**
	 * ���캯����ָ������
	 * @param taskSet ����
	 * @param deadline �����㷨����ʱ��
	 */
	public RunAlgorithmCase(Vector<Task> taskSet, int deadline) {
		this.taskSet = taskSet;
		this.deadline = deadline;
	}
	
	@Override
	public void setSchedulingAlgorithm(SchedulingAlgorithm schedulingAlgorithm) {
		this.schedulingAlgorithm = schedulingAlgorithm;
	}
	
	/**
	 * ��ȡ�����㷨
	 * @return SchedulingAlgorithm 
	 */
	public SchedulingAlgorithm getSchedulingAlgorithm() {
		return this.schedulingAlgorithm;
	}
	

	@Override
	public void setCheckAlgorithm(CheckAlgorithm checkAlgorithm) {
		this.checkAlgorithm = checkAlgorithm;
	}
	
	/**
	 * ��ȡУ���㷨
	 * @return CheckAlgorithm
	 */
	public CheckAlgorithm getCheckAlgorithm() {
		return this.checkAlgorithm;
	}
	
	/**
	 * ��ȡ���Ƚ��
	 * @return Vector<TimeBlock>
	 */
	public Vector<TimeBlock> getSchedulingResult() {
		return this.schedulingResult;
	}
	
	/**
	 * ��ȡУ����
	 * @return CheckResultEnum
	 */
	public CheckResultEnum getCheckResult() {
		return this.checkResult;
	}
	
	/**
	 * ��ȡ��������
	 * @return Vector<Task>
	 */
	public Vector<Task> getTaskSet() {
		return this.taskSet;
	}
	
	/**
	 * ��ȡ�����㷨ִ��ʱ��
	 * @return long
	 */
	public long getExecTime() {
		return this.execTime;
	}

}
