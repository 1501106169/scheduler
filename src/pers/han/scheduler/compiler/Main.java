package pers.han.scheduler.compiler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		
		// 动态编译器
		DynamicCompiler dynamicCompiler = new DynamicCompiler(classLoader);
		
		// 添加到动态编译器其的待编译源文件中
		dynamicCompiler.addSource("Man", "import java.util.List; import java.util.ArrayList; public class Man { public List<String> hello () { List<String> lis = new ArrayList<String>(); lis.add(\"hello\"); System.out.println(\"hello world\"); return lis; }}");
		
		System.out.println(dynamicCompiler.build());
		
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
			List<String> obj = (List<String>) method.invoke(cls.newInstance());
			System.out.println(obj);
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
