package pers.han.scheduler.framework;

import pers.han.scheduler.task.*;
import java.util.ArrayList;

/**
 * �������������ܵĵ��ȿ�ܵ�ʵ��
 * FileName: BaseSchedulerFrame.java
 * 
 * @author		hanYG
 * @createDate	2021.10.08
 * @alterDate	2021.10.10	�޸�����ArrayList->ArrayList<Task>
 * @version		1.0
 * 
 */
public class BaseSchedulerFrame implements BaseSchedulerCheck {
	
	/**
	 * �м�����࣬ʵ���˽ӿڣ�����Ҫ�޸�
	 * Ӧ����inputTestCase��outputSchedulerResult��checkSchedulerAlgroithm��Ϊ���󷽷������û�ʵ��
	 * schedulerAlgroithm�û�ʵ��
	 */
	
	/** һ������ */
	protected ArrayList<Task> testCase;
	
	/** �����㷨�����Ľ�� */
	protected ArrayList<TimeBlock> timeBlockList;
	
	/** ��Ըò����������㷨����ȷ�� */
	protected boolean algroithmViable;
	
	// ���캯�����ݲ�ʵ��
	
	/**
	 * �޲ι���
	 */
	public BaseSchedulerFrame() {
		runFrame();
	}
	
	/**
	 * ���캯��������һ���������ļ���ʽ����ĵ�ַ
	 * @param filePath �ļ���ַ
	 */
	public BaseSchedulerFrame(String filePath) {
		
	}
	
	/**
	 * ��ȡ�㷨����ȷ��
	 * @return Boolean
	 */
	public boolean getVisable() {
		return this.algroithmViable;
	}
	
	/**
	 * ����ִ�п��
	 */
	private void runFrame() {
		this.testCase = inputTestCase();	// ��ȡ��������
		this.timeBlockList = schedulerAlgroithm(this.testCase);
		this.algroithmViable = checkSchedulerAlgroithm(this.testCase, this.timeBlockList);
		outputSchedulerResult(this.timeBlockList);
	}

	@Override
	public ArrayList<Task> inputTestCase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TimeBlock> schedulerAlgroithm(ArrayList<Task> taskList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void outputSchedulerResult(ArrayList<TimeBlock> timeBlock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkSchedulerAlgroithm(ArrayList<Task> taskList, ArrayList<TimeBlock> timeBlock) {
		// TODO Auto-generated method stub
		return false;
	}

}
