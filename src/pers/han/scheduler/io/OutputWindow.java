package pers.han.scheduler.io;

import pers.han.scheduler.task.*;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class OutputWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** ����ͼ��Ŀؼ� */
	private Canvas canvas;
	
	/** ������ */
	private JScrollPane scroll;
	
	/** rootPanel���� */
	// private JPanel rootPanel;
	
	/** ��ͼ��panel */
	private JPanel panel;
	
	/** ����ͼ������� */
	private ArrayList<TimeBlock> timeAxis;
	
	/**
	 * ���캯��������ͼ����
	 * @param timeAxis	����ͼ�������
	 */
	public OutputWindow(ArrayList<TimeBlock> timeAxis) {
		super();
		this.timeAxis = timeAxis;
		this.panel = new JPanel();
		this.panel.setBackground(Color.ORANGE);
		this.panel.setLayout(null);
		this.canvas = new Chart(timeAxis);
		this.scroll = new JScrollPane();
		this.scroll.setViewportView(this.canvas);
		this.scroll.setLocation(150, 150);
		this.scroll.setSize(450, 270);
		this.panel.add(scroll);
		this.getContentPane().add(this.panel);
		
		// ���ô����С
		this.setSize(800, 600);
		// ���ô���ر�ʱ���������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ô������
		this.setTitle("CHART");
		// ���ô����ʼλ��
		this.setLocation(200, 200);
		// ���ô��崴��ʱ��ʾ
		this.setVisible(true);
		// ���ô����С���ɸı�
//		this.setResizable(false);
		// this.setLayout(null);
		this.setLocation(150, 150);
		// this.setSize(this.getWidth(), this.getHeight());
	}
	
	/**
	 * ����JFrame�ı仯�ػ�JFrame�ϵ�ͼ��
	 */
	public void paint(Graphics g) {
		// ����JFrame�޸�panel�Ĵ�С��panelʼ�����JFrame
		this.panel.setSize(this.getWidth(), this.getHeight());
		// this.rootPanel.setSize(this.getWidth(), this.getHeight());
		this.panel.repaint();
		this.canvas.repaint();
		this.scroll.repaint();
	}

}
