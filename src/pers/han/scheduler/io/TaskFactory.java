package pers.han.scheduler.io;

import pers.han.scheduler.task.*;

/**
 * 简单工厂模式，根据参数个数创建Task子类
 * 
 * @author		hanYG
 * @createDate	2022年10月2日
 * @alterDate	2022年10月2日
 * @version		1.0
 *
 */
public final class TaskFactory {
	private TaskFactory() { }
	
	/**
	 * 根据参数个数创建Task子类
	 * @param strList 参数string
	 * @return Task
	 */
	public static Task createTask(String[] strList) {
		Task task = null;
		if (strList.length == 4) {
			task = new PeriodicTask(Integer.parseInt(strList[0]), Integer.parseInt(strList[1]), Integer.parseInt(strList[2]), Integer.parseInt(strList[3]));
		} else if (strList.length == 3) {
			task = new AperiodicTask(Integer.parseInt(strList[0]), Integer.parseInt(strList[1]), Integer.parseInt(strList[2]));
		}
		return task;
	}
	
	/**
	 * 根据参数个数创建Task子类
	 * @param list 参数int
	 * @return Task
	 */
	public static Task createTask(int[] intList) {
		Task task = null;
		if (intList.length == 4) {
			task = new PeriodicTask(intList[0], intList[1], intList[2], intList[3]);
		} else if (intList.length == 3) {
			task = new AperiodicTask(intList[0], intList[1], intList[3]);
		}
		return task;
	}
	
}
