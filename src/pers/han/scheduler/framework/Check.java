package pers.han.scheduler.framework;

import java.util.Vector;

/**
 * 校验算法
 * FileName: Check.java
 * 
 * @author		hanYG
 * @createDate	2022年5月24日
 * @alterDate	2022年5月24日
 * @version		1.0
 *
 */
public class Check {
	
	/**
	 * 校验算法
	 * @param taskSet 一组实时任务
	 * @param schedulingResult 调度算法产生的调度结果
	 * @return 调度结果的可行性 CheckResult
	 */
	static public CheckResultEnum doCheck(Vector taskSet, Vector schedulingResult) {
		System.out.println(taskSet);
		System.out.println(schedulingResult);
		
		return CheckResultEnum.FEASIBLE;
	}
	
	static public CheckResultEnum checkAlgorithm() {
		
		return CheckResultEnum.FEASIBLE;
	}
	
	
	static public CheckResultEnum checkAperiodicAlgorithm() {
		
		return CheckResultEnum.FEASIBLE;
	}

	
}
