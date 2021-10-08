package pers.han.scheduler.task;

/**
 * 作业抢占类型枚举
 * FileName: JobPreemption.java
 * 
 * @author		hanYG
 * @createDate	2021.05.17
 * @alterDate	2021.05.17
 * @version		1.0
 *
 */
public enum JobPreemption {
	/** 可抢占的 */
	PREEMPTABLE,
	/** 不可抢占的 */
	NONPREEMPTABLE;
}
