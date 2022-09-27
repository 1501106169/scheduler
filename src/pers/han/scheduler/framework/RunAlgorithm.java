package pers.han.scheduler.framework;

import pers.han.scheduler.check.CheckAlgorithm;
import pers.han.scheduler.scheduling.SchedulingAlgorithm;

/**
 * �ṩһ��ִ��У������㷨�ķ���
 * 
 * @author		hanYG
 * @createDate	2022��6��1��
 * @alterDate	2022��6��1��
 * @version		1.0
 *
 */
public interface RunAlgorithm {
	
	/**
	 * ���õ����㷨
	 * @param schedulingAlgorithm �����㷨ʵ��
	 */
	public void setSchedulingAlgorithm(SchedulingAlgorithm schedulingAlgorithm);
	
	/**
	 * ���õ����㷨
	 * @param checkAlgorithm У���㷨ʵ��
	 */
	public void setCheckAlgorithm(CheckAlgorithm checkAlgorithm);
	
	/**
	 * ���е����㷨��У��
	 */
	public void run();
	
	/**
	 * ���е����㷨
	 */
	public void runSchedulingAlgorithm();
	
	/**
	 * ����У���㷨
	 */
	public void runCheckAlgorithm();
	
}
