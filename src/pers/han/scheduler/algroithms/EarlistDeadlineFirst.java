package pers.han.scheduler.algroithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
// import java.util.Queue;

import pers.han.scheduler.task.*;

// ����

/**
 * ����ʱ�������㷨 
 * FileName: EarlistDeadlineFirst.java
 * 
 * @author		hanYG
 * @createDate	2021.06.18
 * @alterDate	2021.10.11
 * @version		1.0
 *
 */
public class EarlistDeadlineFirst {
	
	private EarlistDeadlineFirst() {
		
	}
	
	/**
	 * ����EDF����������������㷨����Сʱ�����ִ��ʱ������
	 * @param periodicTaskList	��������������
	 * @return ArrayList<TimeBlock> ʱ���ᣬÿ��ʱ����ִ�е�����
	 */
	public static ArrayList<TimeBlock> periodicEDF(ArrayList<PeriodicTask> periodicTaskList) {
		// ����ִ�е�ʱ���
		ArrayList<TimeBlock> timeAxis = new ArrayList<TimeBlock>();
		
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
		for (PeriodicTask periodicTask : periodicTaskList) {
			nextStopTaskTime.add(new TimeSpan(periodicTask));
		}
		
		while (axis < hyperperiod) {
			// ��δ�������ͷ�ʱ�䣬���񲻿�ִ��
			int leastTaskIndex = getLeastDeadlineIndex(nextStopTaskTime, axis);
			if (leastTaskIndex == -1) {
				leastTaskIndex = getLeastStartTimeIndex(nextStopTaskTime);
				axis = nextStopTaskTime.get(leastTaskIndex).getStartTime();
			}
			if (axis >= hyperperiod) {
				break;
			}
			timeAxis.add(new TimeBlock(leastTaskIndex, axis, nextStopTaskTime.get(leastTaskIndex).getExecTime()));
			axis += nextStopTaskTime.get(leastTaskIndex).getExecTime();
			nextStopTaskTime.get(leastTaskIndex).nextPeriodic();
		}
		return timeAxis;
	}
	
	/**
	 * ��ȡһ����������ĳ�����
	 * @param periodicTaskList	һ������������
	 * @return Integer
	 */
	private static int getHyperperiod(ArrayList<PeriodicTask> periodicTaskList) {
		ArrayList<Integer> digitalList = new ArrayList<Integer>();
		for (PeriodicTask periodicTask : periodicTaskList) {
			digitalList.add(periodicTask.getTaskPeriodic());
		}
		return Numeric.leastCommonMultiple(digitalList);
	}
	
	/**
	 * ��ȡһ���������������ͷ�ʱ��֮�����Сʱ��������������
	 * @param timeSpanList	һ���������������һ��ִ�н׶�
	 * @param axis	��ǰʱ����ʱ��
	 * @return	Integer
	 */
	private static int getLeastDeadlineIndex(ArrayList<TimeSpan> timeSpanList, int axis) {
		int leastDeadlineIndex = -1;
		for (int index = 0; index < timeSpanList.size(); ++index) {
			if (timeSpanList.get(index).getStartTime() > axis) {
				continue;
			}
			if (leastDeadlineIndex == -1) {
				leastDeadlineIndex = index;
			}else if (timeSpanList.get(leastDeadlineIndex).getEndTime() > timeSpanList.get(index).getEndTime()) {
				leastDeadlineIndex = index;
			} else if (timeSpanList.get(leastDeadlineIndex).getEndTime() == timeSpanList.get(index).getEndTime()) {
				leastDeadlineIndex = timeSpanList.get(leastDeadlineIndex).getExecTime() > timeSpanList.get(index).getExecTime() ? index : leastDeadlineIndex; 
			}
		}
		return leastDeadlineIndex;
	}
	
	/**
	 * ��ȡ�ͷ�ʱ����С����������
	 * @param timeSpanList	һ���������������һ��ִ�н׶�
	 * @return	Integer
	 */
	private static int getLeastStartTimeIndex(ArrayList<TimeSpan> timeSpanList) {
		int leastStartTimeIndex = 0;
		for (int index = 1; index < timeSpanList.size(); ++index) {
			if (timeSpanList.get(index).getStartTime() < timeSpanList.get(leastStartTimeIndex).getStartTime()) {
				leastStartTimeIndex = index;
			}
		}
		return leastStartTimeIndex;
	}
	
}
