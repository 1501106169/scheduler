package pers.han.scheduler.io;

import java.util.Vector;

import pers.han.scheduler.task.Task;

/**
 * �ṩһ���ȡʵʱ����ķ���
 * 
 * @author		hanYG
 * @createDate	2022��6��1��
 * @alterDate	2022��6��1��
 * @version		1.0
 *
 */
public interface InputTaskData {
	/**
	 * ��ȡһ���������
	 * @return Vector<Vector<Task>>
	 */
	public Vector<Vector<Task>> getTaskData();

}
