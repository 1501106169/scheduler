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
	
	/** 绘制图表的控件 */
	private Canvas canvas;
	
	/** 滚动条 */
	private JScrollPane scroll;
	
	/** rootPanel容器 */
	// private JPanel rootPanel;
	
	/** 绘图的panel */
	private JPanel panel;
	
	/** 绘制图表的数据 */
	private ArrayList<TimeBlock> timeAxis;
	
	/**
	 * 构造函数，创建图表窗口
	 * @param timeAxis	绘制图表的数据
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
		
		// 设置窗体大小
		this.setSize(800, 600);
		// 设置窗体关闭时，程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗体标题
		this.setTitle("CHART");
		// 设置窗体初始位置
		this.setLocation(200, 200);
		// 设置窗体创建时显示
		this.setVisible(true);
		// 设置窗体大小不可改变
//		this.setResizable(false);
		// this.setLayout(null);
		this.setLocation(150, 150);
		// this.setSize(this.getWidth(), this.getHeight());
	}
	
	/**
	 * 根据JFrame的变化重绘JFrame上的图像
	 */
	public void paint(Graphics g) {
		// 根据JFrame修改panel的大小，panel始终填充JFrame
		this.panel.setSize(this.getWidth(), this.getHeight());
		// this.rootPanel.setSize(this.getWidth(), this.getHeight());
		this.panel.repaint();
		this.canvas.repaint();
		this.scroll.repaint();
	}

}
