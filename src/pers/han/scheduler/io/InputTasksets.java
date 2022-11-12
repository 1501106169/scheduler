package pers.han.scheduler.io;

import java.util.Vector;

import pers.han.scheduler.task.Task;

/**
 * 提供一组获取实时任务的方法
 * 
 * @author		hanYG
 * @createDate	2022年6月1日
 * @alterDate	2022年6月1日
 * @version		1.0
 *
 */
public interface InputTasksets {
	/**
	 * 获取一组调度任务
	 * @return Vector<Vector<Task>>
	 */
	public Vector<Vector<Task>> getTaskData();

}
