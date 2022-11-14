package pers.han.scheduler.compiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 自定义的Java源代码编译器，实现对源代码的编译
 * FileName: DynamicCompiler.java
 * 
 * @author		hanYG
 * @createDate	2021.10.26
 * @alterDate	2021.10.26
 * @version		1.0
 * 
 */
public class DynamicCompiler {
	
	/** 获取系统的Java编译器 */
	private final JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
	
	/** 动态编译的文件管理器 */
	private StandardJavaFileManager standardFileManager = null;
	
	/** 编译的参数 */
	private final List<String> options = new ArrayList<String>();
	
	/** 类加载器 */
	private DynamicClassLoader dynamicClassLoader = null;
	
	/** JavaFileObject组成的待编译的源文件列表 */
	private final Collection<JavaFileObject> compilationUnits = new ArrayList<JavaFileObject>();
	
	private JavaFileManager fileManager = null;
	
	DiagnosticCollector<JavaFileObject> collector = null;
	
	/**
	 * 构造函数，初始化
	 * @param classLoader 基类的类加载器
	 */
	public DynamicCompiler(ClassLoader classLoader) {
		this.standardFileManager = this.javaCompiler.getStandardFileManager(null, null, null);
		this.options.add("-Xlint:unchecked");
		this.dynamicClassLoader = new DynamicClassLoader(classLoader);
	}
	
	/**
	 * 添加待编译的源代码
	 * @param className 类名
	 * @param contents 源代码
	 */
	public void addSource(String className, String contents) {
		this.addSource(new DynamicSourceFile(className, contents));
	}
	
	/**
	 * 添加待编译的源代码文件对象
	 * @param javaFileObject 输入的源文件对象
	 */
	public void addSource(JavaFileObject javaFileObject) {
		this.compilationUnits.add(javaFileObject);
	}
	
	/**
	 * 执行编译操作
	 * @return Boolean
	 */
	public boolean build() {
		this.fileManager = new DynamicFileManager(this.standardFileManager, this.dynamicClassLoader);
		this.collector = new DiagnosticCollector<JavaFileObject>();
		JavaCompiler.CompilationTask task = this.javaCompiler.getTask(null, this.fileManager, this.collector, this.options, null, this.compilationUnits);
		return task.call();
	}
	
	/**
	 * 获取所有的类名和类
	 * @return Map<String, Class<?>>
	 */
	public Map<String, Class<?>> getClasses() {
		try {
			return this.dynamicClassLoader.getClasses();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取所有的类名和字节码
	 * @return Map<String, byte[]>
	 */
	public Map<String, byte[]> getByteCodes() {
		return this.dynamicClassLoader.getByteCodes();
	}
	
	/**
	 * 获取报错信息
	 * @return String
	 */
	public String getBuildError() {
		System.out.println(this.collector.getDiagnostics());
		return this.collector.getDiagnostics().toString();
	}
	
}
