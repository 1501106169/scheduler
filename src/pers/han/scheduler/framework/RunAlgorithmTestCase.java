package pers.han.scheduler.framework;

import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;
import pers.han.scheduler.scheduling.SchedulingAlgorithm;
import pers.han.scheduler.check.CheckAlgorithm;
import pers.han.scheduler.algroithms.Tools;

import java.util.Vector;

/**
 * 运行算法在一份任务数据上
 * 
 * @author		hanYG
 * @createDate	2022年6月2日
 * @alterDate	2022年6月2日
 * @version		1.0
 *
 */
public class RunAlgorithmTestCase implements RunAlgorithm {
	/** 一组实时任务 */
	private final Vector<Task> taskSet;
	
	/** 调度结果 */
	private Vector<TimeBlock> schedulingResult;
	
	/** 校验结果，算法可行性 */
	private CheckResultEnum checkResult;
	
	/** 调度算法 */
	private SchedulingAlgorithm schedulingAlgorithm = null;
	
	/** 校验算法 */
	private CheckAlgorithm checkAlgorithm = null;
	
	/** 调度算法执行时间 */
	private long execTime;
	
	/** 调度算法运行截至时间 */
	private int deadline = 0;

	@Override
	public void run() {
		this.runSchedulingAlgorithm();
		this.runCheckAlgorithm();
	}

	@Override
	public void runSchedulingAlgorithm() {
		if (this.deadline == 0) {
			this.deadline = Tools.hyperperiod(this.taskSet);
		}
		long startTime = System.currentTimeMillis();		
		// 若不指定算法运行时间，运行时间为一个超周期
		this.schedulingAlgorithm.setUp(this.taskSet, this.deadline);
		Vector<TimeBlock> result = this.schedulingAlgorithm.doSchedule();
		this.schedulingResult = result;
		this.schedulingAlgorithm.tearDown();
		long endTime = System.currentTimeMillis();
		this.execTime = endTime - startTime;
	}

	@Override
	public void runCheckAlgorithm() {
		this.checkAlgorithm.setUp(this.taskSet, this.schedulingResult, this.deadline);
		CheckResultEnum result = this.checkAlgorithm.doCheck();
		this.checkResult = result;
		this.checkAlgorithm.tearDown();
	}
	
	/**
	 * 构造函数，指定任务、调度算法、校验算法
	 * @param taskSet 任务集
	 * @param schedulingAlgorithm 调度算法对象
	 * @param checkAlgorithm 校验算法对象
	 * @param deadline 调度算法运行截至时间
	 */
	public RunAlgorithmTestCase(final Vector<Task> taskSet, final SchedulingAlgorithm schedulingAlgorithm, final CheckAlgorithm checkAlgorithm, final int deadline) {
		this.taskSet = taskSet;
		this.schedulingAlgorithm = schedulingAlgorithm;
		this.checkAlgorithm = checkAlgorithm;
		this.deadline = deadline;
	}
	
	/**
	 * 构造函数，指定任务
	 * @param taskSet 任务集
	 * @param deadline 调度算法运行时长
	 */
	public RunAlgorithmTestCase(final Vector<Task> taskSet, final int deadline) {
		this.taskSet = taskSet;
		this.deadline = deadline;
	}
	
	/**
	 * 构造函数，指定任务、调度算法、校验算法
	 * @param taskSet 任务集
	 * @param schedulingAlgorithm 调度算法对象
	 * @param checkAlgorithm 校验算法对象
	 */
	public RunAlgorithmTestCase(final Vector<Task> taskSet, final SchedulingAlgorithm schedulingAlgorithm, final CheckAlgorithm checkAlgorithm) {
		this.taskSet = taskSet;
		this.schedulingAlgorithm = schedulingAlgorithm;
		this.checkAlgorithm = checkAlgorithm;
		// this.deadline = Tools.hyperperiod(taskSet);
	}
	
	/**
	 * 构造函数，指定任务
	 * @param taskSet 任务集
	 */
	public RunAlgorithmTestCase(final Vector<Task> taskSet) {
		this.taskSet = taskSet;
		// this.deadline = Tools.hyperperiod(taskSet);
	}
	
	@Override
	public void setSchedulingAlgorithm(SchedulingAlgorithm schedulingAlgorithm) {
		this.schedulingAlgorithm = schedulingAlgorithm;
	}
	
	/**
	 * 获取调度算法
	 * @return SchedulingAlgorithm 
	 */
	public SchedulingAlgorithm getSchedulingAlgorithm() {
		return this.schedulingAlgorithm;
	}
	

	@Override
	public void setCheckAlgorithm(CheckAlgorithm checkAlgorithm) {
		this.checkAlgorithm = checkAlgorithm;
	}
	
	/**
	 * 获取校验算法
	 * @return CheckAlgorithm
	 */
	public CheckAlgorithm getCheckAlgorithm() {
		return this.checkAlgorithm;
	}
	
	/**
	 * 获取调度结果
	 * @return Vector<TimeBlock>
	 */
	public Vector<TimeBlock> getSchedulingResult() {
		return this.schedulingResult;
	}
	
	/**
	 * 获取校验结果
	 * @return CheckResultEnum
	 */
	public CheckResultEnum getCheckResult() {
		return this.checkResult;
	}
	
	/**
	 * 获取调度任务
	 * @return Vector<Task>
	 */
	public Vector<Task> getTaskSet() {
		return this.taskSet;
	}
	
	/**
	 * 获取调度算法执行时间
	 * @return long
	 */
	public long getExecTime() {
		return this.execTime;
	}

}
