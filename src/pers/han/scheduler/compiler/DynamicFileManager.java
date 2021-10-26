package pers.han.scheduler.compiler;

import java.util.ArrayList;
import java.util.List;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

/**
 * Java文件管理，getJavaFileForOutput获取输出的JavaFileObject对象
 * FileName: DynamicFileManager.java
 * 
 * @author		hanYG
 * @createDate	2021.10.26
 * @alterDate	2021.10.26
 * @version		1.0
 *
 */
public class DynamicFileManager extends ForwardingJavaFileManager<JavaFileManager> {
	
	/** 类加载器 */
	private final DynamicClassLoader dynamicClassLoader;
	
	/** 所有源代码的字节流输出对象 */
	private final List<DynamicByteCode> byteCodes = new ArrayList<DynamicByteCode>();
	
	/**
	 * 构造函数，初始化类加载器
	 * @param fileManager JavaFileManager
	 * @param dynamicClassLoader 类加载器
	 */
	public DynamicFileManager(JavaFileManager fileManager, DynamicClassLoader dynamicClassLoader) {
		super(fileManager);
		this.dynamicClassLoader = dynamicClassLoader;
	}
	
	@Override
	public JavaFileObject getJavaFileForOutput(JavaFileManager.Location location, String className, JavaFileObject.Kind kind, FileObject sibling) {
		for (DynamicByteCode byteCode : this.byteCodes) {
			if (byteCode.getClassName().equals(className)) {
				return byteCode;
			}
		}
		DynamicByteCode innerClass = new DynamicByteCode(className);
		this.byteCodes.add(innerClass);
		this.dynamicClassLoader.registerCompiledSource(innerClass);
		return innerClass;
	}
	
	
}
