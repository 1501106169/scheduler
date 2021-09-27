package pers.han.scheduler.algroithms;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.TimeBlock;
import pers.han.scheduler.task.*;
import java.util.ArrayList;
// import java.util.Iterator;

/**
 * �Ե����㷨�Ľ������У��
 * FileName: CheckAlgroithmsResult.java
 * 
 * @author	hanYG
 * @date	2021.09.10
 * @version	1.0
 *
 */
public class CheckAlgroithmsResult {
	
	/**
	 * ���캯��
	 */
	public CheckAlgroithmsResult() {
		
	}
	
	/**
	 * ��̬������У�鲻����ռ����������������㷨�����Ľ��
	 * @param periodicTaskList	һ������������
	 * @param timeAxis			�����㷨�����ĵ��Ƚ��
	 * @return					Boolean
	 */
	public static boolean checkPeriodicTask(ArrayList<PeriodicTask> periodicTaskList, ArrayList<TimeBlock> timeAxis) {
		// ��֤���������ʱ����
		double axis = 0;
		// ��¼ÿһ�������������ڵ�ǰ���ڵ��ͷ�ʱ���ʱ��
		ArrayList<TimeSpan> nextStopTaskTime = new ArrayList<TimeSpan>();
		// Iterator<PeriodicTask> periodicTaskListIterator = periodicTaskList.iterator();
		for (PeriodicTask task : periodicTaskList) {
			nextStopTaskTime.add(new TimeSpan(task));
		}
		// У������������ĵ����Ƿ����
		for (TimeBlock timeBlock : timeAxis) {
			int taskId = timeBlock.getId();
			// ��һ������������Ŀ�ʼʱ����ʱ����֮���ҿ�ʼʱ��ͽ���ʱ���ڵ�ǰ���ڵķ�Χ��ʱ���������Ч
			if (timeBlock.getStartTime() >= axis && timeBlock.getStartTime() >= nextStopTaskTime.get(taskId).getStartTime() && timeBlock.getExecTime() + timeBlock.getStartTime() <= nextStopTaskTime.get(taskId).getEndTime()) {
				nextStopTaskTime.get(taskId).nextPeriodic();
				axis = timeBlock.getStartTime() + timeBlock.getExecTime();
			} else {
				return false;
			}
		}
		return true;
	}
	
}
