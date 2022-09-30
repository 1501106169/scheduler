package pers.han.scheduler.io;

import java.util.Vector;

import pers.han.scheduler.task.*;

public class main {
	public static void main(String[] agrv) {
		InputTaskDataFromFile in = new InputTaskDataFromFile("");
		Vector<Vector<Task>> v = in.getTaskData();
		System.out.println(v.get(0).get(0));
		System.out.println(v.get(0).get(1));
		System.out.println(v.get(0).get(2));
		System.out.println(v.get(0).get(3));
	}
}
