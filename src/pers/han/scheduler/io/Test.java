package pers.han.scheduler.io;

import java.util.Vector;

import pers.han.scheduler.task.TimeBlock;

public class Test {

	public static void main(String[] args) {
		Vector<TimeBlock> timeAxis = new Vector<>();
		timeAxis.add(new TimeBlock(0, 0, 10));
		timeAxis.add(new TimeBlock(0, 58, 10));
		timeAxis.add(new TimeBlock(0, 86, 10));
		timeAxis.add(new TimeBlock(0, 120, 10));
		timeAxis.add(new TimeBlock(0, 168, 10));
		timeAxis.add(new TimeBlock(1, 10, 18));
		timeAxis.add(new TimeBlock(1, 68, 18));
		timeAxis.add(new TimeBlock(1, 100, 18));
		timeAxis.add(new TimeBlock(1, 150, 18));
		timeAxis.add(new TimeBlock(2, 28, 10));
		timeAxis.add(new TimeBlock(3, 38, 20));
		timeAxis.add(new TimeBlock(5, 200, 10));
		
		new OutputWindow(timeAxis);

	}

}
