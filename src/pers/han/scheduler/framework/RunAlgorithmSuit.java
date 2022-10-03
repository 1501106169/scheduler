package pers.han.scheduler.framework;

import pers.han.scheduler.check.CheckAlgorithm;
import pers.han.scheduler.scheduling.SchedulingAlgorithm;
import pers.han.scheduler.task.Task;

import java.util.Vector;

/**
 * 在多个调度任务上执行调度算法，RunAlgorithmCase的合集
 * 
 * @author		hanYG
 * @createDate	2022年9月30日
 * @alterDate	2022年9月30日
 * @version		1.0
 *
 */
public class RunAlgorithmSuit implements RunAlgorithm {
	
	Vector<RunAlgorithm> algorithmSuit = new Vector<RunAlgorithm>();
	
	public RunAlgorithmSuit() { }
	
	/**
	 * 使用任务suit构造，需要后续添加调度算法和校验算法
	 * @param taskSuit 任务
	 */
	public RunAlgorithmSuit(Vector<Vector<Task>> taskSuit) {
		for (Vector<Task> taskSet : taskSuit) {
			this.algorithmSuit.add(new RunAlgorithmCase(taskSet));
		}
		return;
	}
	
	/**
	 * 构造函数
	 * @param taskSuit 任务
	 * @param schedulingAlgorithm 调度算法
	 * @param checkAlgorithm 校验算法
	 */
	public RunAlgorithmSuit(Vector<Vector<Task>> taskSuit, SchedulingAlgorithm schedulingAlgorithm, CheckAlgorithm checkAlgorithm) {
		// this.algorithmSuit = new Vector<RunAlgorithm>();
		for (Vector<Task> taskSet : taskSuit) {
			this.algorithmSuit.add(new RunAlgorithmCase(taskSet, schedulingAlgorithm, checkAlgorithm));
		}
		return;
	}
	
	@Override
	public void setSchedulingAlgorithm(SchedulingAlgorithm schedulingAlgorithm) {
		for (RunAlgorithm algorithm : this.algorithmSuit) {
			algorithm.setSchedulingAlgorithm(schedulingAlgorithm);
		}
		return;
	}

	@Override
	public void setCheckAlgorithm(CheckAlgorithm checkAlgorithm) {
		for (RunAlgorithm algorithm : this.algorithmSuit) {
			algorithm.setCheckAlgorithm(checkAlgorithm);
		}
		return;
	}

	@Override
	public void run() {
		
	}

	@Override
	public void runSchedulingAlgorithm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runCheckAlgorithm() {
		// TODO Auto-generated method stub
		
	}

}
