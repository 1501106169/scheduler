package pers.han.scheduler.framework;

import java.util.Vector;

/**
 * У���㷨
 * FileName: Check.java
 * 
 * @author		hanYG
 * @createDate	2022��5��24��
 * @alterDate	2022��5��24��
 * @version		1.0
 *
 */
public class Check {
	
	/**
	 * У���㷨
	 * @param taskSet һ��ʵʱ����
	 * @param schedulingResult �����㷨�����ĵ��Ƚ��
	 * @return ���Ƚ���Ŀ����� CheckResult
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
