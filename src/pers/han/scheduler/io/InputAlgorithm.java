package pers.han.scheduler.io;

import pers.han.scheduler.scheduling.SchedulingAlgorithm;

/**
 * 获取调度算法的接口
 * 
 * @author		hanYG
 * @createDate	2022年5月29日
 * @alterDate	2022年5月29日
 * @version		1.0
 *
 */
public interface InputAlgorithm {
	/**
	 * 获取输入的调度算法
	 * @return SchedulingAlgorithm
	 */
	public abstract SchedulingAlgorithm getAlgorithm();
}
