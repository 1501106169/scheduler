package pers.han.scheduler.task;

/**
 * 作业抢占类型枚举
 * 
 * @author		hanYG
 * @createDate	2021年5月17日
 * @alterDate	2021年5月17日
 * @version		1.0
 *
 */
public enum JobPreemption {
	/** 可抢占的 */
	PREEMPTABLE,
	/** 不可抢占的 */
	NONPREEMPTABLE;
}
