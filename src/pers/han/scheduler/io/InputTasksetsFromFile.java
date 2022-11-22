package pers.han.scheduler.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import pers.han.scheduler.task.*;

/**
 * 从文件中获取实时任务
 * 
 * @author		hanYG
 * @createDate	2022年6月1日
 * @alterDate	2022年6月1日
 * @version		1.0
 *
 */
public class InputTasksetsFromFile implements InputTasksets {
	/** 包含实时任务文件的文件夹路径 */
	String dirPath;
	
	/** 偶发任务分隔符 */
	private String sporadicTaskSplitStr = "SporadicTask";
	
	/**
	 * 构造函数
	 * @param dirPath 文件夹路径
	 */
	public InputTasksetsFromFile(String dirPath) {
		this.dirPath = dirPath;
	}
	
	@Override
	public Vector<Vector<Task>> getTaskData() {
		Vector<Vector<Task>> taskSuit = new Vector<Vector<Task>>();
		/**
		 * 0	40	10	40
		 * 0	50	18	50
		 * 0	200	10	200
		 * 0	200	20	200
		 */
		File[] txtFileArray = new File(this.dirPath).listFiles((path)->path.getName().endsWith(".txt"));
		if (txtFileArray == null) {
			return taskSuit;
		}
		for (File file : txtFileArray) {
			taskSuit.add(readTaskDataFromFile(file.getPath()));
		}
		return taskSuit;
	}
	
	/**
	 * 读取单个txt文件中任务
	 * @param filePath 文件路径
	 * @return Vector<Task>
	 */
	private Vector<Task> readTaskDataFromFile(String filePath) {
		Vector<Task> taskSet = new Vector<Task>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String s = null;
			while ((s = br.readLine()) != null && s.indexOf(this.sporadicTaskSplitStr) < 0) {
				if (s.length() == 0) {
					continue;
				}
				// 正则表达式匹配空格或Tab或空格和Tan
				String[] strList = s.split("\t|\s|\t\s");
				// 工厂模式，需要工厂帮我创建任务子类对象的实例
				Task task = TaskFactory.createTask(strList);
				if (task != null) {
					taskSet.add(task);
				}
			}
			while ((s = br.readLine()) != null) {
				if (s.length() == 0) {
					continue;
				}
				// 正则表达式匹配空格或Tab或空格和Tan
				String[] strList = s.split("\t|\s|\t\s");
				// 工厂模式，需要工厂帮我创建任务子类对象的实例
				Task task = TaskFactory.createSporadicTask(strList);
				if (task != null) {
					taskSet.add(task);
				}
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
		return taskSet;
	}
	
	/**
	 * 设置偶发任务分隔符
	 * @param splitStr
	 */
	public void setSporadicTaskSplitStr(String splitStr) {
		this.sporadicTaskSplitStr = splitStr;
	}
	
	
}
