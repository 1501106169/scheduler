package pers.han.scheduler.io;

import pers.han.scheduler.algroithms.SchedulingAlgorithm;

/**
 * ��ȡ�����㷨�Ľӿ�
 * 
 * @author		hanYG
 * @createDate	2022��5��29��
 * @alterDate	2022��5��29��
 * @version		1.0
 *
 */
public interface InputAlgorithm {
	/**
	 * ��ȡ����ĵ����㷨
	 * @return SchedulingAlgorithm
	 */
	public abstract SchedulingAlgorithm getAlgorithm();
}
