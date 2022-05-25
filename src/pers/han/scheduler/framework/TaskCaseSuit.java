package pers.han.scheduler.framework;

import java.util.Map;
import java.util.Vector;

import pers.han.scheduler.compiler.DynamicCompiler;
import pers.han.scheduler.task.PeriodicTask;

/**
 * 
 * FileName: TaskCaseSuit.java
 * 
 * @author		hanYG
 * @createDate	2022��5��24��
 * @alterDate	2022��5��24��
 * @version		1.0
 *
 */
public class TaskCaseSuit implements BaseTaskCase {
	
	/** �������ݼ��� */
	Vector<Vector> taskSetSuit = null;
	/** �����㷨�� */
	Class schedlulingAlgorithmCls = null;
	/** TaskCase����Ҫ����TaskCase��У���� */
	Vector taskCaseSet = new Vector();
	
	/**
	 * ���캯��
	 * @param taskSetSuit һ���������
	 * @param schedlulingAlgorithmCls �����Եĵ����㷨��
	 */
	public TaskCaseSuit(Vector<Vector> taskSetSuit, Class schedlulingAlgorithmCls) {
		this.taskSetSuit = taskSetSuit;
		this.schedlulingAlgorithmCls = schedlulingAlgorithmCls;
	}
	
	
	public void run() {
		if (this.taskSetSuit == null) {
			return;
		}
		for (Vector taskSet : this.taskSetSuit) {
			TaskCase taskCase = this.createTaskCase(taskSet);
			this.addTaskCase(taskCase);
			this.runTaskCase(taskCase);
		}
	}
	
	/**
	 * ����TaskCase����
	 * @param taskSet ��������
	 * @return
	 */
	private TaskCase createTaskCase(Vector taskSet) {
		return new TaskCase(taskSet, this.schedlulingAlgorithmCls);
	}
	
	
	/**
	 * ����TaskCase
	 * @param baseTaskCase
	 */
	public void runTaskCase(BaseTaskCase baseTaskCase) {
		baseTaskCase.run();
	}
	
	/**
	 * ���TaskCase��taskCaseSet������¼
	 * @param baseTaskCase
	 */
	private void addTaskCase(BaseTaskCase baseTaskCase) {
		this.taskCaseSet.add(baseTaskCase);
	}
	
	/**
	 * �������ݵ�����
	 * @return
	 */
	public int countTaskCase() {
		return this.taskSetSuit.size();
		
	}
	
	public static void main(String[] argc) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		DynamicCompiler dynamicCompiler = new DynamicCompiler(classLoader);
		// ��ӵ���̬��������Ĵ�����Դ�ļ���
		dynamicCompiler.addSource("testClass", "import java.util.Vector;\r\n"
				+ "\r\n"
				+ "import pers.han.scheduler.task.PeriodicTask;\r\n"
				+ "import pers.han.scheduler.task.TimeBlock;\r\n"
				+ "\r\n"
				+ "public class testClass {\r\n"
				+ "	public Vector test(Vector v) {\r\n"
				+ "		System.out.println(\"hello world, reflect\");\r\n"
				+ "		Vector s = new Vector();\r\n"
				+ "		s.add(new TimeBlock(1, 0, 3));\r\n"
				+ "		return s;\r\n"
				+ "	}\r\n"
				+ "}");
		System.out.println(dynamicCompiler.build());
		dynamicCompiler.getBuildError();
		Map<String, Class<?>> classes = dynamicCompiler.getClasses();
		System.out.println(classes);
		Class<?> cls = classes.get("testClass");
		Vector taskCaseSet = new Vector();
		Vector elem = new Vector();
		elem.add(new PeriodicTask(1, 3));
		taskCaseSet.add(elem);
		taskCaseSet.add(elem);
		TaskCaseSuit taskCaseSuit = new TaskCaseSuit(taskCaseSet, cls);
		taskCaseSuit.run();

	}
	
	
}
