package pers.han.scheduler.check;

import java.util.Vector;

import pers.han.scheduler.task.*;
import pers.han.scheduler.task.TimeBlock;
import pers.han.scheduler.framework.*;

/**
 * 调度算法性能度量
 * 
 * @author		hanYG
 * @createDate	2022年9月28日
 * @alterDate	2022年9月28日
 * @version		1.0
 *
 */
public class PerformanceTest {
	
	/** test case实例 */
	private RunAlgorithmCase algorithmCase = null;
	
	/** 时间利用率 */
	private double timeUtilization;
	
	/** 平均响应时间 */
	private double avgResponseTime;
	
	/** 总响应延时 */
	private double responseTime;
	
	private PerformanceTest() { }
	
	public PerformanceTest(RunAlgorithmCase algorithmCase) {
		// 浅拷贝
		this.algorithmCase = algorithmCase;
	}
	
	public PerformanceTest(RunAlgorithm runAlgorithm) {
		// 浅拷贝
		this.algorithmCase = (RunAlgorithmCase) runAlgorithm;
	}
	
	/**
	 * 计算时间利用率
	 * @return double 
	 */
	public double calcTimeUtilization() {
		int execTime = 0;
		int endTime = 0;
		for (TimeBlock tb : this.algorithmCase.getSchedulingResult()) {
			execTime += tb.getExecTime();
			endTime = Math.max(endTime, tb.getStartTime() + tb.getExecTime());
		}
		this.timeUtilization = (double) execTime / (double) endTime;
		return this.timeUtilization;
	}
	
	/**
	 * 计算作业的平均响应时间，作业执行时间-作业施放时间差的均值
	 * 不校验调度结果的正确性
	 * @return double
	 */
	public double calcResponseTime() {
		// 深拷贝拷贝taskSet
		Vector<Task> taskSet = new Vector<Task>();
		for (Task t : this.algorithmCase.getTaskSet()) {
			taskSet.add(t.clone());
		}
		// 浅拷贝
		Vector<TimeBlock> schedulingResult = this.algorithmCase.getSchedulingResult();
		for (TimeBlock tb : schedulingResult) {
			if (taskSet.get(tb.getTaskId()).getClass() == pers.han.scheduler.task.PeriodicTask.class) {
				PeriodicTask pt = pers.han.scheduler.task.PeriodicTask.class.cast(taskSet.get(tb.getTaskId()));
				this.responseTime += tb.getStartTime() - pt.getCycleStartTime() - pt.getJobReleaseTime();
				pt.nextCycle();
			} else {
				this.responseTime += tb.getStartTime() - taskSet.get(tb.getTaskId()).getJobReleaseTime();
			}
		}
		this.avgResponseTime = this.responseTime / schedulingResult.size();
		return this.responseTime;
	}
	
	
	
}
