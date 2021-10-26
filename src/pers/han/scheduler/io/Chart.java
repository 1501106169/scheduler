package pers.han.scheduler.io;

import pers.han.scheduler.task.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * ���ƽ��̵���ͼ��
 * FileName: Chart.java
 * 
 * @author		hanYG
 * @createDate	2021.10.14
 * @alterDate	2021.10.19
 * @version		1.0
 *
 */
public class Chart extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** chart�Ĵ�С */
	private Dimension dime;
	
	/** ������ */
	private int taskNum;
	
	/** ��ȡ��ɫ */
	// private ChartColor chartColor = new ChartColor();
	
	/** ������Ƚ�� */
	private ArrayList<TimeBlock> timeAxis;
	
	/** ����ͼ�߶�30����λ */
	private int BAR_HEIGHT = 30;
	
	/** ÿ�����������20����λ */
	private int BAR_BAR_BORDER = 20;
	
	/** ��������canvas�ļ��10����λ */
	private int BAR_CANVAS_BORDER = 10;
	
	/** ÿ��ʱ�䵥λ�ĳ���Ϊ3����λ */
	private int PER_DATE_LEN = 3;
	
	/** ����ͼ������߽� */
	
	/** ����ͼ�����ұ߽� */
	
	/**
	 * ���캯��
	 * @param timeAxis ������Ƚ��
	 */
	public Chart(ArrayList<TimeBlock> timeAxis) {
		super();
		this.timeAxis = timeAxis;
		if (timeAxis.isEmpty()) {
			this.taskNum = -1;
			return;
		}
		this.taskNum = 0;
		for (TimeBlock timeBlock : timeAxis) {
			if (timeBlock.getId() > this.taskNum) {
				this.taskNum = timeBlock.getId();
			}
		}
		// ���û������ѡ��С
		this.dime = new Dimension(
				(timeAxis.get(timeAxis.size() - 1).getStartTime() + timeAxis.get(timeAxis.size() - 1).getExecTime()) * this.PER_DATE_LEN,
				this.BAR_CANVAS_BORDER * 2 + this.BAR_BAR_BORDER * this.taskNum + this.BAR_HEIGHT * (this.taskNum + 1)
		);
		this.setPreferredSize(this.dime);
		this.setSize(this.dime);
	}

	/**
	 * ����ͼ��
	 */
	public void paint(Graphics g) {
		// ���Ƶ���ͼ�Ŀ��
		drawFrame(g);
		
		/** ���߿�������Ч������ */
		
		for (TimeBlock timeBlock : timeAxis) {
			// ���������ţ�����������ʹ�õ���ɫ
			int taskId = timeBlock.getId(); 
			// ���û�����ɫ
			g.setColor(Color.decode(ChartColor.getPeriodicTaskColorStr(taskId)));
			g.fillRect(
					timeBlock.getStartTime() * this.PER_DATE_LEN,
					this.getHeight() - this.BAR_CANVAS_BORDER - this.BAR_HEIGHT * (taskId + 1) - this.BAR_BAR_BORDER * taskId,
					timeBlock.getExecTime() * this.PER_DATE_LEN,
					this.BAR_HEIGHT
			);
			g.setColor(Color.decode(ChartColor.defaultColorStr));
			g.drawRect(
					timeBlock.getStartTime() * this.PER_DATE_LEN,
					this.getHeight() - this.BAR_CANVAS_BORDER - this.BAR_HEIGHT * (taskId + 1) - this.BAR_BAR_BORDER * taskId,
					timeBlock.getExecTime() * this.PER_DATE_LEN,
					this.BAR_HEIGHT
			);
		}
		
	}
	
	/**
	 * ����Canvas��ܽṹ
	 * @param g
	 */
	private void drawFrame(Graphics g) {
		g.setColor(Color.decode(ChartColor.defaultColorStr));
		for (int i = 0; i <= this.taskNum; ++i) {
			g.drawLine(
					0,
					this.getHeight() - this.BAR_CANVAS_BORDER - this.BAR_HEIGHT * i - this.BAR_BAR_BORDER * i,
					this.getWidth(),
					this.getHeight() - this.BAR_CANVAS_BORDER - this.BAR_HEIGHT * i - this.BAR_BAR_BORDER * i
			);
		}
	}

}
