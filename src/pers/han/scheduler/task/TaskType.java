package pers.han.scheduler.task;

/**
 * 任务类型枚举
 * FileName: TaskTye.java
 * 
 * @author		hanYG
 * @createDate	2021.06.17
 * @alterDate	2021.06.17		弃用
 * @version		1.0
 * 
 */
public enum TaskType {
	/** 周期性任务 */
	PERIODIC,
	/** 非周期性任务 */
	APERIODIC,
	/** 偶发性任务 */
	SPORADIC;
}
