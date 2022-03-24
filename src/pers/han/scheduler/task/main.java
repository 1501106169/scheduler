package pers.han.scheduler.task;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PeriodicTask t = new PeriodicTask(1, 2, 3, 4);
		
		AperiodicTask at = new AperiodicTask();
		
		ArrayList<Task> taskList = new ArrayList<Task>();
		
		taskList.add(at);
		taskList.add(t);
		
		return;
	}

}
