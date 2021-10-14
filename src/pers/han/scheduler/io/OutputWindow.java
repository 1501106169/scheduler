package pers.han.scheduler.io;

import pers.han.scheduler.task.*;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class OutputWindow extends JFrame {
	
	/** ����ͼ��Ŀؼ� */
	private Chart ct;
	
	/** ����ͼ������� */
	private ArrayList<TimeBlock> timeAxis;
	
	/**
	 * ���캯��������ͼ����
	 * @param timeAxis	����ͼ�������
	 */
	public OutputWindow(ArrayList<TimeBlock> timeAxis) {
		super();
		// ����ͼ��ؼ�
		ct = new Chart(timeAxis);
		this.timeAxis = timeAxis;
		this.add(ct);
		// ���ô����С
		this.setSize(800, 600);
		// ���ô���ر�ʱ���������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ô������
		this.setTitle("CHART");
		// ���ô����ʼλ��
		this.setLocation(0, 0);
		// this.setLayout(null);
		// ���ô��崴��ʱ��ʾ
		this.setVisible(true);
		// ���ô����С���ɸı�
		// this.setResizable(false);
	}
	
	/**
	 * ����JFrame�޸�Chart�Ĵ�С��Chartʼ�����JFrame
	 */
	public void paint(Graphics g) {
		ct.setSize(this.getWidth(), this.getHeight());
	}

}
