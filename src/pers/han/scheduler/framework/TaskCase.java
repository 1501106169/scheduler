package pers.han.scheduler.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Vector;

import pers.han.scheduler.compiler.DynamicCompiler;

/**
 * 
 * FileName: TaskCase.java
 * 
 * @author		hanYG
 * @createDate	2022��5��24��
 * @alterDate	2022��5��24��
 * @version		1.0
 *
 */
public class TaskCase extends Check implements BaseTaskCase {

	/** �������ݣ�һ������ */
	protected Vector taskSet = null;
	/** �����㷨ִ�н�� */
	protected Vector schedulingResult = null;
	/** У���㷨ִ�н�� */
	protected CheckResultEnum checkResult = null;
	/** �����㷨�� */
	Class schedlulingAlgorithmCls = null;
	/** ִ��ʱ�� */
	long execTime;
	
	/**
	 * ���캯��
	 * @param taskSet ��������
	 */
	public TaskCase(Vector taskSet, Class schedlulingAlgorithmClass) {
		this.taskSet = taskSet;
		this.schedlulingAlgorithmCls = schedlulingAlgorithmClass;
	}
	
	/**
	 * �ڲ���������ִ�е����㷨
	 */
	public void run() {
		// ִ��
		if (this.runSchedulingAlgorithm() == null) {
			return;
		}
		long startTime = System.currentTimeMillis();
		this.checkResult = Check.doCheck(this.taskSet, this.schedulingResult);
		long endTime = System.currentTimeMillis();
		this.execTime = endTime - startTime;
		System.out.println(this.checkResult);
		System.out.println(this.execTime);
	}
	
	/**
	 * ���ݰ���������������ִ�е����㷨
	 * @return
	 */
	private Vector runSchedulingAlgorithm() {
		if (this.schedlulingAlgorithmCls == null) {
			return null;
		}
		Object schedlulingAlgorithmClassObj = null;
		try {
			schedlulingAlgorithmClassObj = this.schedlulingAlgorithmCls.newInstance();
		} catch (InstantiationException | IllegalAccessException e2) {
			e2.printStackTrace();
			return null;
		}
		Method schedulingAlgorithmMethod = null;
		try {
			// ���ݵ����㷨����������������
			schedulingAlgorithmMethod = this.schedlulingAlgorithmCls.getDeclaredMethod("test", Vector.class);
		} catch (NoSuchMethodException | SecurityException e1) {
			e1.printStackTrace();
			return null;
		}
		Object schedulingResultObj = null;
		try {
			schedulingResultObj = schedulingAlgorithmMethod.invoke(schedlulingAlgorithmClassObj, this.taskSet);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
		this.schedulingResult = (Vector)schedulingResultObj;
		return this.schedulingResult;
	}
	
	/**
	 * ��ȡ�������ݵ���Ŀ
	 * @return
	 */
	public int countTaskCase() {
		return 1;
	}
	
	/**
	 * ��ȡУ����
	 * @return
	 */
	public CheckResultEnum getCheckResult() {
		return this.checkResult;
	}
	
	/**
	 * ��ȡ�����㷨ִ�н��
	 * @return
	 */
	public Vector getSchedulingResult() {
		return this.schedulingResult;
	}
	
	/** ��ȡִ��ʱ�� */
	public long getExecTime() {
		return this.execTime;
	}
	
	public static void main(String[] args) {
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
		TaskCase t = new TaskCase(null, cls);
		t.run();
		System.out.print(t.getCheckResult());
	}
	
}
