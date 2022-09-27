package pers.han.scheduler.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import pers.han.scheduler.task.*;

/**
 * ��ȡ������������
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
	 * ��ȡ�ļ��е���������
	 * @param filePath	�ļ�·���������ļ���
	 * @return	ArrayList<Task>
	 */
	public static ArrayList<Task> readFileDate(String filePath) {
		/*
		 * ��������	�ͷ�ʱ��		����		ִ��ʱ��		ʱ��
		 * PERIODIC
		 * 			0			40		10			40
		 * 			0			50		18			50
		 * 			0			200		10			200
		 * 			0			200		20			200
		 * 
		 * APERIODIC
		 * 			�ͷ�ʱ��				ִ��ʱ��		ʱ��
		 * 
		 * SPORADIC
		 * 			��д���ļ��� ������
		 */
		// ArrayList<PeriodicTask> periodicTaskList = new ArrayList<PeriodicTask>();
		ArrayList<Task> periodicTaskList = new ArrayList<Task>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String s = null;
			while ((s = br.readLine()) != null) {
				// ������ʽƥ��ո��Tab��ո��Tan
				String[] strList = s.split("\t|\s|\t\s");
				
				// ����ģʽ����Ҫ�������Ҵ���������������ʵ��
				
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
