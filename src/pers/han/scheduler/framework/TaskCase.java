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
 * @createDate	2022年5月24日
 * @alterDate	2022年5月24日
 * @version		1.0
 *
 */
public class TaskCase extends Check implements BaseTaskCase {

	/** 测试数据，一组任务 */
	protected Vector taskSet = null;
	/** 调度算法执行结果 */
	protected Vector schedulingResult = null;
	/** 校验算法执行结果 */
	protected CheckResultEnum checkResult = null;
	/** 调度算法类 */
	Class schedlulingAlgorithmCls = null;
	/** 执行时间 */
	long execTime;
	
	/**
	 * 构造函数
	 * @param taskSet 测试数据
	 */
	public TaskCase(Vector taskSet, Class schedlulingAlgorithmClass) {
		this.taskSet = taskSet;
		this.schedlulingAlgorithmCls = schedlulingAlgorithmClass;
	}
	
	/**
	 * 在测试数据上执行调度算法
	 */
	public void run() {
		// 执行
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
	 * 根据包名类名、方法名执行调度算法
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
			// 根据调度算法方法名、参数查找
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
	 * 获取测试数据的数目
	 * @return
	 */
	public int countTaskCase() {
		return 1;
	}
	
	/**
	 * 获取校验结果
	 * @return
	 */
	public CheckResultEnum getCheckResult() {
		return this.checkResult;
	}
	
	/**
	 * 获取调度算法执行结果
	 * @return
	 */
	public Vector getSchedulingResult() {
		return this.schedulingResult;
	}
	
	/** 获取执行时间 */
	public long getExecTime() {
		return this.execTime;
	}
	
	public static void main(String[] args) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		DynamicCompiler dynamicCompiler = new DynamicCompiler(classLoader);
		// 添加到动态编译器其的待编译源文件中
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
