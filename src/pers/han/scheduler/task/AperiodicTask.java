package pers.han.scheduler.task;

public final class AperiodicTask extends Task {
	
	private int test = 0;
	
	public AperiodicTask() {
		this.taskType = TaskType.APERIODIC;
	}
	
	public int getTest() {
		return this.test;
	}
}
