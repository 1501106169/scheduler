package pers.han.scheduler.framework;

import pers.han.scheduler.task.*;
import java.util.ArrayList;

/**
 * 仅包含基本功能的调度框架的实现
 * FileName: BaseSchedulerFrame.java
 * 
 * @author		hanYG
 * @createDate	2021.10.08
 * @alterDate	2021.10.10	修改类型ArrayList->ArrayList<Task>
 * @version		1.0
 * 
 */
public class BaseSchedulerFrame implements BaseSchedulerCheck {
	
	/**
	 * 中间抽象类，实现了接口，还需要修改
	 * 应当把inputTestCase、outputSchedulerResult、checkSchedulerAlgroithm作为抽象方法，供用户实现
	 * schedulerAlgroithm用户实现
	 */
	
	/** 一组任务 */
	protected ArrayList<Task> testCase;
	
	/** 调度算法产生的结果 */
	protected ArrayList<TimeBlock> timeBlockList;
	
	/** 针对该测试用例，算法的正确性 */
	protected boolean algroithmViable;
	
	// 构造函数，暂不实现
	
	/**
	 * 无参构造
	 */
	public BaseSchedulerFrame() {
		runFrame();
	}
	
	/**
	 * 构造函数，基于一组任务以文件形式保存的地址
	 * @param filePath 文件地址
	 */
	public BaseSchedulerFrame(String filePath) {
		
	}
	
	/**
	 * 获取算法的正确性
	 * @return Boolean
	 */
	public boolean getVisable() {
		return this.algroithmViable;
	}
	
	/**
	 * 构造执行框架
	 */
	private void runFrame() {
		this.testCase = inputTestCase();	// 读取测试用例
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
