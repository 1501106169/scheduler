package pers.han.scheduler.io;

import pers.han.scheduler.task.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JScrollPane;

/**
 * 绘制进程调度图表
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
	
	/** 任务数 */
	private int taskNum;
	
	/** 获取颜色 */
	// private ChartColor chartColor = new ChartColor();
	
	/** 任务调度结果 */
	private ArrayList<TimeBlock> timeAxis;
	
	/** 条形图高度30个单位 */
	private int BAR_HEIGHT = 30;
	
	/** 每个进度条间隔20个单位 */
	private int BAR_BORDER = 20;
	
	/** 进度条和canvas的间隔10个单位 */
	private int BAR_CANVAS_BORDER = 10;
	
	/**
	 * 构造函数
	 * @param timeAxis 任务调度结果
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
	 * 绘制图表
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
	 * 绘制Canvas框架结构
	 * @param g
	 */
	private void drawFrame(Graphics g) {
		int width = this.getWidth();
		int height = this.getHeight();
		
		/** 画边框，填充矩形效果更好 */
		
		// 第一个条形图
		
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
