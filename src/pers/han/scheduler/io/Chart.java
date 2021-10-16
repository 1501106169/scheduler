package pers.han.scheduler.io;

import pers.han.scheduler.task.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JScrollPane;

/**
 * ���ƽ��̵���ͼ��
 * FileName: Chart.java
 * 
 * @author		hanYG
 * @createDate	2021.10.14
 * @alterDate	2021.10.14
 * @version		1.0
 *
 */
public class Chart extends Canvas {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JScrollPane scroll;
	
	/** ������ */
	private int taskNum;
	
	/** ��ȡ��ɫ */
	// private ChartColor chartColor = new ChartColor();
	
	/** ������Ƚ�� */
	private ArrayList<TimeBlock> timeAxis;
	
	/** ����ͼ�߶�30����λ */
	private int BAR_HEIGHT = 30;
	
	/** ÿ�����������20����λ */
	private int BAR_BORDER = 20;
	
	/** ��������canvas�ļ��10����λ */
	private int BAR_CANVAS_BORDER = 10;
	
	/**
	 * ���캯��
	 * @param timeAxis ������Ƚ��
	 */
	public Chart(ArrayList<TimeBlock> timeAxis) {
		super();
		this.setBackground(Color.PINK);
		this.timeAxis = timeAxis;
		this.setSize(1000, 1000);
		if (timeAxis.size() == 0) { return; }
		this.taskNum = 0;
		for (TimeBlock timeBlock : timeAxis) {
			if (timeBlock.getId() > this.taskNum) {
				this.taskNum = timeBlock.getId();
			}
		}
	}

	/**
	 * ����ͼ��
	 */
	public void paint(Graphics g) {
		// g.setColor(Color.RED);
		// g.setColor(Color.decode("#ff0000"));		
		int width = this.getWidth();
		int height = this.getHeight();
		// drawFrame(g);
		g.drawLine(100, 100, 900, 900);
		g.drawLine(100, 900, 900, 100);
	}
	
	/**
	 * ����Canvas��ܽṹ
	 * @param g
	 */
	private void drawFrame(Graphics g) {
		int width = this.getWidth();
		int height = this.getHeight();
		
		/** ���߿�������Ч������ */
		
		// ��һ������ͼ
		
		g.setColor(Color.RED);
		for (int i = 0; i < 5; ++i) {
			g.drawRect(
					50, 
					height - this.BAR_CANVAS_BORDER - this.BAR_HEIGHT * (i + 1) - this.BAR_BORDER * i, 
					600, 
					this.BAR_HEIGHT
			);
		}
	}

}
