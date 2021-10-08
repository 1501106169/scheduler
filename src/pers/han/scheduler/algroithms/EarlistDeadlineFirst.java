package pers.han.scheduler.algroithms;

import pers.han.scheduler.task.*;
import java.util.ArrayList;
// import java.util.Iterator;
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
		// ��ǰʱ��
		// double nowTime = 0;
		// timeAxis.add(new TimeBlock(1, nowTime, periodicTaskList.get(1).getJobExecTime()));
		
		// ʹ��Queue�洢TimeBlock
		
		timeAxis.add(new TimeBlock(0, 0, 1));
		timeAxis.add(new TimeBlock(1, 1, 1.8));
		timeAxis.add(new TimeBlock(2, 3, 1));
		timeAxis.add(new TimeBlock(0, 4, 1));
		timeAxis.add(new TimeBlock(1, 5, 1.8));
		timeAxis.add(new TimeBlock(3, 7, 2));
		timeAxis.add(new TimeBlock(0, 9, 1));
		timeAxis.add(new TimeBlock(1, 10, 2));
		timeAxis.add(new TimeBlock(0, 12, 1));
		timeAxis.add(new TimeBlock(1, 15, 1.8));
		timeAxis.add(new TimeBlock(0, 17, 1));
		
		return timeAxis;
	}
	
	
}
