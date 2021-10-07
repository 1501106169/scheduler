package pers.han.scheduler.framework;

import pers.han.scheduler.task.*;
import java.util.ArrayList;

/**
 * �������롢�㷨������Ľӿ�
 * 
 * FileName: BaseSchedulerCheck.java
 * 
 * @author	hanYG
 * @date	2021.09.28
 * @version	1.0
 *
 */
public interface BaseSchedulerCheck {
	
	/**
	 * �����㷨
	 * @param taskList	ԭʼArrayList��һ������
	 * @return	���Ƚ��
	 */
	public abstract ArrayList<TimeBlock> schedulerAlgroithm(ArrayList taskList);
	
	/**
	 * ����㷨
	 * @param timeBlock	���ȵ�ʱ��Ƭ
	 */
	public abstract void outputSchedulerResult(ArrayList<TimeBlock> timeBlock);	
	
	/**
	 * У���㷨
	 * @param taskList	����
	 * @param timeBlock	���Ƚ��
	 * @return	�㷨����ȷ��
	 */
	public abstract boolean checkSchedulerAlgroithm(ArrayList taskList, ArrayList<TimeBlock> timeBlock);
	
}
