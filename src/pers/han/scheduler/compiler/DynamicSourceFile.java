package pers.han.scheduler.compiler;

import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**
 * �����Դ�ļ�����
 * FileName: DynamicSourceFile.java
 * 
 * @author		hanYG
 * @createDate	2021.10.26
 * @alterDate	2021.10.26
 * @version		1.0
 *
 */
public class DynamicSourceFile extends SimpleJavaFileObject {

	/** Դ���� */
	private final String contents;
	
	/**
	 * ��������Դ����Ĺ��캯��
	 * @param className ����
	 * @param contents Դ����
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
