package pers.han.scheduler.io;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import pers.han.scheduler.task.*;

/**
 * 绘制进程调度图表
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
	
	/** chart的大小 */
	private Dimension dime;
	
	/** 任务数 */
	private int taskNum;
	
	/** 获取颜色 */
	// private ChartColor chartColor = new ChartColor();
	
	/** 任务调度结果 */
	private Vector<TimeBlock> timeAxis;
	
	/** 条形图高度30个单位 */
	private int BAR_HEIGHT = 30;
	
	/** 每个进度条间隔20个单位 */
	private int BAR_BAR_BORDER = 20;
	
	/** 进度条和canvas的间隔10个单位 */
	private int BAR_CANVAS_BORDER = 10;
	
	/** 每个时间单位的长度为3个单位 */
	private int PER_DATE_LEN = 3;
	
	/** 调度图距离左边界 */
	
	/** 调度图距离右边界 */
	
	/**
	 * 构造函数
	 * @param timeAxis 任务调度结果
	 */
	public Chart(Vector<TimeBlock> timeAxis) {
		super();
		this.timeAxis = timeAxis;
		if (timeAxis.isEmpty()) {
			this.taskNum = 0;
			return;
		}
		this.taskNum = 0;
		for (TimeBlock tb : timeAxis) {
			taskNum = Math.max(taskNum, tb.getTaskId());
		}
		// 设置画板的首选大小
		this.dime = new Dimension(
				(timeAxis.get(timeAxis.size() - 1).getStartTime() + timeAxis.get(timeAxis.size() - 1).getExecTime()) * this.PER_DATE_LEN,
				this.BAR_CANVAS_BORDER * 2 + this.BAR_BAR_BORDER * this.taskNum + this.BAR_HEIGHT * (this.taskNum + 1)
		);
		this.setPreferredSize(this.dime);
		this.setSize(this.dime);
	}

	/**
	 * 绘制图表
	 */
	public void paint(Graphics g) {
		// 绘制调度图的框架
		drawFrame(g);
		
		/** 画边框，填充矩形效果更好 */
		
		for (TimeBlock tb : timeAxis) {
			// 根据任务编号，设置任务所使用的颜色
			int taskId = tb.getTaskId();
			// 设置画笔颜色
			g.setColor(Color.decode(ChartColor.getPeriodicTaskColorStr(taskId)));
			g.fillRect(
					tb.getStartTime() * this.PER_DATE_LEN,
					this.getHeight() - this.BAR_CANVAS_BORDER - this.BAR_HEIGHT * (taskId + 1) - this.BAR_BAR_BORDER * taskId,
					tb.getExecTime() * this.PER_DATE_LEN,
					this.BAR_HEIGHT
			);
			g.setColor(Color.decode(ChartColor.defaultColorStr));
			g.drawRect(
					tb.getStartTime() * this.PER_DATE_LEN,
					this.getHeight() - this.BAR_CANVAS_BORDER - this.BAR_HEIGHT * (taskId + 1) - this.BAR_BAR_BORDER * taskId,
					tb.getExecTime() * this.PER_DATE_LEN,
					this.BAR_HEIGHT
			);
		}
		
	}
	
	/**
	 * 绘制Canvas框架结构
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
