package pers.han.scheduler.algroithms;

import pers.han.scheduler.task.*;
import java.util.ArrayList;
import java.util.Iterator;
// import java.util.Queue;

/**
 * ����ʱ�������㷨 
 * FileName: EarlistDeadlineFirst.java
 * 
 * @author		hanYG
 * @createDate	2021.06.18
 * @alterDate	2021.06.18
 * @version		1.0
 *
 */
public class EarlistDeadlineFirst {
	
	public EarlistDeadlineFirst() {
		
	}
	
	/**
	 * ����EDF����������������㷨
	 * @param periodicTaskList	��������������
	 * @return	ArrayList<TimeBlock> ʱ���ᣬÿ��ʱ����ִ�е�����
	 */
	public static ArrayList<TimeBlock> periodicEDF(ArrayList<PeriodicTask> periodicTaskList) {
		// ����ִ�е�ʱ���
		ArrayList<TimeBlock> timeAxis = new ArrayList<TimeBlock>();
		
		// timeAxis.add(new TimeBlock(1, nowTime, periodicTaskList.get(1).getJobExecTime()));
		
		// ʹ��Queue�洢TimeBlock
		/*
		timeAxis.add(new TimeBlock(0, 0, 10));
		timeAxis.add(new TimeBlock(1, 10, 18));
		timeAxis.add(new TimeBlock(2, 30, 10));
		timeAxis.add(new TimeBlock(0, 40, 10));
		timeAxis.add(new TimeBlock(1, 50, 18));
		timeAxis.add(new TimeBlock(3, 70, 20));
		timeAxis.add(new TimeBlock(0, 90, 10));
		timeAxis.add(new TimeBlock(1, 100, 20));
		timeAxis.add(new TimeBlock(0, 120, 10));
		timeAxis.add(new TimeBlock(1, 150, 18));
		timeAxis.add(new TimeBlock(0, 170, 10));
		*/
		
		// ʱ����
		int axis = 0;
		
		// ���һ������ĳ�����
		int hyperperiod = getHyperperiod(periodicTaskList);
		
		// �洢��һ������ִ�е��ͷ�ʱ�̡�ִ��ʱ�䡢ʱ��
		ArrayList<TimeSpan> nextStopTaskTime = new ArrayList<TimeSpan>();
		
		// System.out.println(getHyperperiod(periodicTaskList));
		
		for (PeriodicTask periodicTask : periodicTaskList) {
			nextStopTaskTime.add(new TimeSpan(periodicTask));
		}
		
		
		
		return timeAxis;
	}
	
	
	private static int getHyperperiod(ArrayList<PeriodicTask> periodicTaskList) {
		ArrayList<Integer> digitalList = new ArrayList<Integer>();
		for (PeriodicTask periodicTask : periodicTaskList) {
			digitalList.add(periodicTask.getTaskPeriodic());
		}
		return numeric.leastCommonMultiple(digitalList);
	}
	
}
