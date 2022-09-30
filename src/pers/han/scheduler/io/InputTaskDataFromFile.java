package pers.han.scheduler.io;

import java.util.Vector;

import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.*;

/**
 * 从文件中获取实时任务
 * 
 * @author		hanYG
 * @createDate	2022年6月1日
 * @alterDate	2022年6月1日
 * @version		1.0
 *
 */
public class InputTaskDataFromFile implements InputTaskData {
	/** 包含实时任务文件的文件夹路径 */
	String dirPath;
	
	/**
	 * 构造函数
	 * @param dirPath 文件夹路径
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
