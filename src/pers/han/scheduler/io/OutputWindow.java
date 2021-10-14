package pers.han.scheduler.io;

import pers.han.scheduler.task.*;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class OutputWindow extends JFrame {
	
	/** 绘制图表的控件 */
	private Chart ct;
	
	/** 绘制图表的数据 */
	private ArrayList<TimeBlock> timeAxis;
	
	/**
	 * 构造函数，创建图表窗口
	 * @param timeAxis	绘制图表的数据
	 */
	public OutputWindow(ArrayList<TimeBlock> timeAxis) {
		super();
		// 创建图表控件
		ct = new Chart(timeAxis);
		this.timeAxis = timeAxis;
		this.add(ct);
		// 设置窗体大小
		this.setSize(800, 600);
		// 设置窗体关闭时，程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗体标题
		this.setTitle("CHART");
		// 设置窗体初始位置
		this.setLocation(0, 0);
		// this.setLayout(null);
		// 设置窗体创建时显示
		this.setVisible(true);
		// 设置窗体大小不可改变
		// this.setResizable(false);
	}
	
	/**
	 * 根据JFrame修改Chart的大小，Chart始终填充JFrame
	 */
	public void paint(Graphics g) {
		ct.setSize(this.getWidth(), this.getHeight());
	}

}
