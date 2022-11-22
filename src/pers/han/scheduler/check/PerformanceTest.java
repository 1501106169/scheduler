package pers.han.scheduler.check;

import java.util.Vector;

import pers.han.scheduler.task.*;
import pers.han.scheduler.task.TimeBlock;
import pers.han.scheduler.framework.*;
import pers.han.scheduler.algroithms.Numeric;

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
	private final RunAlgorithmTestCase algorithmCase;
	
	/** 时间利用率 */
	private double timeUtilization;
	
	/** 平均响应时间 */
	private double avgResponseTime;
	
	/** 总响应延时 */
	private double responseTime;
	
	/** 响应时间的方差 */
	private double varianceResponseTime;
	
	/** 响应时间标准差 */
	private double standardDeviation;
	
	/**
	 * 构造函数
	 * @param algorithmCase
	 */
	public PerformanceTest(final RunAlgorithmTestCase algorithmCase) {
		// 浅拷贝
		this.algorithmCase = algorithmCase;
	}
	
	/**
	 * 构造函数
	 * @param runAlgorithm
	 */
	public PerformanceTest(final RunAlgorithm runAlgorithm) {
		// 浅拷贝
		this.algorithmCase = (RunAlgorithmTestCase) runAlgorithm;
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
		for (Task t : this.algorithmCase.getSporadicTaskSet()) {
			taskSet.add(t.clone());
		}
		// 浅拷贝
		Vector<TimeBlock> schedulingResult = this.algorithmCase.getSchedulingResult();
		for (TimeBlock tb : schedulingResult) {
			if (taskSet.get(tb.getTaskId()).getClass() == PeriodicTask.class) {
				PeriodicTask pt = PeriodicTask.class.cast(taskSet.get(tb.getTaskId()));
				this.responseTime += tb.getStartTime() - pt.getCycleStartTime() - pt.getJobReleaseTime();
				pt.nextCycle();
			} else {
				this.responseTime += tb.getStartTime() - taskSet.get(tb.getTaskId()).getJobReleaseTime();
			}
		}
		this.avgResponseTime = this.responseTime / schedulingResult.size();
		return this.responseTime;
	}
	
	/**
	 * 计算作业的响应时间的方差，标准差
	 * @return
	 */
	public double calcVarianceResponseTime() {
		Vector<Double> reponseTimeList = new Vector<Double>();
		Vector<Task> taskSet = new Vector<Task>();
		for (Task t : this.algorithmCase.getTaskSet()) {
			taskSet.add(t.clone());
		}
		for (Task t : this.algorithmCase.getSporadicTaskSet()) {
			taskSet.add(t.clone());
		}
		// 浅拷贝
		Vector<TimeBlock> schedulingResult = this.algorithmCase.getSchedulingResult();
		for (TimeBlock tb : schedulingResult) {
			if (taskSet.get(tb.getTaskId()).getClass() == PeriodicTask.class) {
				PeriodicTask pt = PeriodicTask.class.cast(taskSet.get(tb.getTaskId()));
				reponseTimeList.add((double) (tb.getStartTime() - pt.getCycleStartTime() - pt.getJobReleaseTime()));
				pt.nextCycle();
			} else {
				reponseTimeList.add((double) (tb.getStartTime() - taskSet.get(tb.getTaskId()).getJobReleaseTime()));
			}
		}
		this.varianceResponseTime = Numeric.variance(reponseTimeList);
		this.standardDeviation = Math.pow(this.varianceResponseTime, 0.5);
		return this.varianceResponseTime;
	}
	
}
