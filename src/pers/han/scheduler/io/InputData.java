package pers.han.scheduler.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import pers.han.scheduler.task.*;

/**
 * 读取测试用例数据
 * FileName: Inputdata.java
 * 
 * @author		hanYG
 * @createDate	2021.10.19
 * @alterDate	2021.10.19
 * @version		1.0
 *
 */
public class InputData {
	
	/**
	 * 读取文件中的任务数据
	 * @param filePath	文件路径，包含文件名
	 * @return	ArrayList<Task>
	 */
	public static ArrayList<Task> readFileDate(String filePath) {
		/*
		 * 任务类型	释放时间		周期		执行时间		时限
		 * PERIODIC
		 * 			0			40		10			40
		 * 			0			50		18			50
		 * 			0			200		10			200
		 * 			0			200		20			200
		 * 
		 * APERIODIC
		 * 			释放时间				执行时间		时限
		 * 
		 * SPORADIC
		 * 			不写在文件中 ？？？
		 */
		// ArrayList<PeriodicTask> periodicTaskList = new ArrayList<PeriodicTask>();
		ArrayList<Task> periodicTaskList = new ArrayList<Task>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String s = null;
			while ((s = br.readLine()) != null) {
				// 正则表达式匹配空格或Tab或空格和Tan
				String[] strList = s.split("\t|\s|\t\s");
				
				// 工厂模式，需要工厂帮我创建任务子类对象的实例
				
				periodicTaskList.add(new PeriodicTask(Integer.parseInt(strList[0]), Integer.parseInt(strList[1]), Integer.parseInt(strList[2]), Integer.parseInt(strList[3])));
			}
		} catch (Exception e) {
			throw new Error(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		return periodicTaskList;
	}
	
	public static void main(String[] args) {
		readFileDate("D:\\eclipse\\workspace\\scheduler\\fileData\\periodicTaskList.txt");
	}

	private InputData() {
		
	}
	
}
