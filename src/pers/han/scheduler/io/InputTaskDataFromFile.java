package pers.han.scheduler.io;

import java.util.Vector;

import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.*;

/**
 * ���ļ��л�ȡʵʱ����
 * 
 * @author		hanYG
 * @createDate	2022��6��1��
 * @alterDate	2022��6��1��
 * @version		1.0
 *
 */
public class InputTaskDataFromFile implements InputTaskData {
	/** ����ʵʱ�����ļ����ļ���·�� */
	String dirPath;
	
	/**
	 * ���캯��
	 * @param dirPath �ļ���·��
	 */
	public InputTaskDataFromFile(String dirPath) {
		this.dirPath = dirPath;
	}
	
	@Override
	public Vector<Vector<Task>> getTaskData() {
		Vector<Vector<Task>> taskSuit = new Vector<Vector<Task>>(2);
		Vector<Task> task = new Vector<Task>();
		task.add(new PeriodicTask(0, 40, 10, 40));
		task.add(new PeriodicTask(0, 50, 18, 50));
		task.add(new PeriodicTask(0, 200, 10, 200));
		task.add(new PeriodicTask(0, 200, 20, 200));
		taskSuit.add(task);
		return taskSuit;
	}
}
