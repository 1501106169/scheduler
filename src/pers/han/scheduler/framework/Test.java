package pers.han.scheduler.framework;

import pers.han.scheduler.algroithms.CheckAlgroithmsResult;
import pers.han.scheduler.algroithms.EarlistDeadlineFirst;
import pers.han.scheduler.io.InputData;
import pers.han.scheduler.io.OutputWindow;
import pers.han.scheduler.task.*;
import pers.han.scheduler.framework.*;
import java.util.ArrayList;

public class Test extends BaseSchedulerFrame {

	@Override
	public ArrayList<Task> inputTestCase() {
		/*
		ArrayList<Task> periodicTaskList = new ArrayList<Task>();
		periodicTaskList.add(new PeriodicTask(40, 10));
		periodicTaskList.add(new PeriodicTask(50, 18));
		periodicTaskList.add(new PeriodicTask(200, 10));
		periodicTaskList.add(new PeriodicTask(200, 20));
		return periodicTaskList;
		*/
		return InputData.readFileDate("D:\\\\eclipse\\\\workspace\\\\scheduler\\\\fileData\\\\periodicTaskList.txt");
	}

	@Override
	public ArrayList<TimeBlock> schedulerAlgroithm(ArrayList<Task> taskList) {
		
		ArrayList<PeriodicTask> periodicTaskList = new ArrayList<PeriodicTask>();
		// Task转换为PeriodicTask
		for (Task task : taskList) {
			periodicTaskList.add((PeriodicTask)task);
		}
		
		return EarlistDeadlineFirst.periodicEDF(periodicTaskList);
	}

	@Override
	public void outputSchedulerResult(ArrayList<TimeBlock> timeBlock) {
		// TODO Auto-generated method stub
		new OutputWindow(timeBlock);
	}

	@Override
	public boolean checkSchedulerAlgroithm(ArrayList<Task> taskList, ArrayList<TimeBlock> timeBlock) {
		// TODO Auto-generated method stub
		ArrayList<PeriodicTask> periodicTaskList = new ArrayList<PeriodicTask>();
		// Task转换为PeriodicTask
		for (Task task : taskList) {
			periodicTaskList.add((PeriodicTask)task);
		}
		return CheckAlgroithmsResult.checkPeriodicTask(periodicTaskList, timeBlock);
	}
	
	public static void main(String[] args) {
		BaseSchedulerFrame bsf = new Test();
		System.out.println(bsf.getVisable());
	}
	
}
