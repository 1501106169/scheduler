package pers.han.scheduler.compiler;

import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**
 * 输入的源文件对象
 * FileName: DynamicSourceFile.java
 * 
 * @author		hanYG
 * @createDate	2021.10.26
 * @alterDate	2021.10.26
 * @version		1.0
 *
 */
public class DynamicSourceFile extends SimpleJavaFileObject {

	/** 源代码 */
	private final String contents;
	
	/**
	 * 用来输入源代码的构造函数
	 * @param className 类名
	 * @param contents 源代码
	 */
	protected DynamicSourceFile(String className, String contents) {
		super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
		this.contents = contents;
	}
	
	@Override
	public CharSequence getCharContent(boolean ignoreEncodeingErrors) {
		return this.contents;
	}

}
