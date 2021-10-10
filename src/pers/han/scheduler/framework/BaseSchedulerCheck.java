package pers.han.scheduler.framework;

import pers.han.scheduler.task.*;
import java.util.ArrayList;

/**
 * �������롢�㷨������Ľӿ�
 * 
 * FileName: BaseSchedulerCheck.java
 * 
 * @author		hanYG
 * @createDate	2021.10.08
 * @alterDate	2021.10.10	�޸�����ArrayList->ArrayList<Task>
 * @version		2.0
 *
 */
public interface BaseSchedulerCheck {
	
	/**
	 * �����������
	 * @return һ���������
	 */
	public abstract ArrayList<Task> inputTestCase();
	
	/**
	 * �����㷨
	 * @param taskList	ԭʼArrayList��һ������
	 * @return	���Ƚ��
	 */
	public abstract ArrayList<TimeBlock> schedulerAlgroithm(ArrayList<Task> taskList);
	
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
	public abstract boolean checkSchedulerAlgroithm(ArrayList<Task> taskList, ArrayList<TimeBlock> timeBlock);
	
}
