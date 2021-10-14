package pers.han.scheduler.io;

import pers.han.scheduler.task.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

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
	
	/** 任务数 */
	private int taskNum;
	
	/** 任务调度结果 */
	private ArrayList<TimeBlock> timeAxis;
	
	/**
	 * 构造函数
	 * @param timeAxis 任务调度结果
	 */
	public Chart(ArrayList<TimeBlock> timeAxis) {
		super();
		this.timeAxis = timeAxis;
		if (timeAxis.size() == 0) { return; }
		this.taskNum = 0;
		for (TimeBlock timeBlock : timeAxis) {
			if (timeBlock.getId() > this.taskNum) {
				this.taskNum = timeBlock.getId();
			}
		}
		this.setBackground(Color.ORANGE);
	}
	
	/**
	 * 绘制图表
	 */
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		int width = this.getWidth();
		int height = this.getHeight();
		
		drawFrame(g);
		
		
	}
	
	/**
	 * 绘制Canvas框架结构
	 * @param g
	 */
	private void drawFrame(Graphics g) {
		int width = this.getWidth();
		int height = this.getHeight();
		
		// Chart左边界
		g.drawLine(100, 0, 100, height);
		
		// Chart右边界
		g.drawLine(width - 150, 0, width - 150, height);
		
		// Chart上边界
		g.drawLine(0, 100, width, 100);
		
		// Chart下边界
		g.drawLine(0, height - 120, width, height - 120);
		
		// Chart名称
		g.drawLine(0, height - 150, width, height - 150);
		
		g.drawLine(100, height - 100, width - 150, height - 100);
		
		// 绘制图表区
		g.drawRect(150, 150, 450, 270);
		
		// 绘制滚动条区
		g.drawLine(150, 400, 600, 400);
		
		g.drawRect(150, 210, 600, 30);
		
		g.drawRect(150, 260, 600, 30);
		
		g.drawRect(150, 310, 600, 30);
		
		g.drawRect(150, 360, 600, 30);
		
		g.drawRect(150, 160, 600, 30);
	}

}
