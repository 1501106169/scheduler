package pers.han.scheduler.compiler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		
		// 动态编译器
		DynamicCompiler dynamicCompiler = new DynamicCompiler(classLoader);
		
		// 添加到动态编译器其的待编译源文件中
		dynamicCompiler.addSource("Man", "import pers.han.scheduler.task.*; public class Man { public PeriodicTask hello () { PeriodicTask p = new PeriodicTask(2, 3); System.out.println(\"hello world\"); return p; }}");
		
		System.out.println(dynamicCompiler.build());
		dynamicCompiler.getBuildError();
		
		Map<String, Class<?>> classes = dynamicCompiler.getClasses();
		System.out.println(classes);
		Class<?> cls = classes.get("Man");
		System.out.println(cls);
		
		Method method = null;
		try {
			method = cls.getMethod("hello");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(method.invoke(cls.newInstance()));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
