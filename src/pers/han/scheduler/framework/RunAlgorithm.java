package pers.han.scheduler.framework;

import pers.han.scheduler.check.CheckAlgorithm;
import pers.han.scheduler.scheduling.SchedulingAlgorithm;

/**
 * 提供一组执行校验调度算法的方法
 * 
 * @author		hanYG
 * @createDate	2022年6月1日
 * @alterDate	2022年6月1日
 * @version		1.0
 *
 */
public interface RunAlgorithm {
	
	/**
	 * 设置调度算法
	 * @param schedulingAlgorithm 调度算法实例
	 */
	public void setSchedulingAlgorithm(SchedulingAlgorithm schedulingAlgorithm);
	
	/**
	 * 设置调度算法
	 * @param checkAlgorithm 校验算法实例
	 */
	public void setCheckAlgorithm(CheckAlgorithm checkAlgorithm);
	
	/**
	 * 运行调度算法并校验
	 */
	public void run();
	
	/**
	 * 运行调度算法
	 */
	public void runSchedulingAlgorithm();
	
	/**
	 * 运行校验算法
	 */
	public void runCheckAlgorithm();
	
}
