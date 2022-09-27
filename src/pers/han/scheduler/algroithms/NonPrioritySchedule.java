package pers.han.scheduler.algroithms;

import java.util.ArrayList;

import pers.han.scheduler.task.*;

/**
 * �����ȼ��㷨
 * FileName: NonPrioritySchedule.java
 * 
 * @author		hanYG
 * @createDate	2022.03.04
 * @alterDate	2022.03.04
 * @version		1.0
 *
 */
public class NonPrioritySchedule {
	
	private NonPrioritySchedule() { }
	
	/**
	 * FIFO���ȣ��Ⱦ����������ȵ���
	 * @param periodicTaskList һ������������
	 * @return ArrayList<TimeBlock> ʱ���ᣬÿ��ʱ����ִ�е�����
	 */
	public static ArrayList<TimeBlock> fifoSchedule(ArrayList<PeriodicTask> periodicTaskList) {
		ArrayList<TimeBlock> timeAxis = new ArrayList<TimeBlock>();
		
		return timeAxis;
	}
	
	/**
	 * ��ת���ȣ�Round-Robin
	 * @param periodicTaskList һ������������
	 * @return ArrayList<TimeBlock> ʱ���ᣬÿ��ʱ����ִ�е�����
	 */
	public static ArrayList<TimeBlock> roundRobin(ArrayList<PeriodicTask> periodicTaskList) {
		ArrayList<TimeBlock> timeAxis = new ArrayList<TimeBlock>();
		
		return timeAxis;
	}
	
	
}
