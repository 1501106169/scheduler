package pers.han.scheduler.algroithms;

import java.util.ArrayList;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.TimeBlock;
import pers.han.scheduler.task.*;
// import java.util.Iterator;

// ����


/**
 * �Ե����㷨�Ľ������У��
 * FileName: CheckAlgroithmsResult.java
 * 
 * @author		hanYG
 * @createDate	2021.09.10
 * @alterDate	2021.10.10	�޸�ʱ��������double->int
 * @version		1.1
 *
 */
public class CheckAlgroithmsResult {
	
	/**
	 * ˽�й��캯��
	 */
	private CheckAlgroithmsResult() {
		
	}
	
	/**
	 * ��̬������У�鲻����ռ����������������㷨�����Ľ��
	 * @param periodicTaskList	һ������������
	 * @param timeAxis			�����㷨�����ĵ��Ƚ��
	 * @return					Boolean
	 */
	public static boolean checkPeriodicTask(ArrayList<PeriodicTask> periodicTaskList, ArrayList<TimeBlock> timeAxis) {
		// ��ҪУ�飬��������ִ�еĴ���
		// ��֤���������ʱ����
		int axis = 0;
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
