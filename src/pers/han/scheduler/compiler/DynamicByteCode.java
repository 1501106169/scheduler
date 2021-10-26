package pers.han.scheduler.compiler;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**
 * 源代码字节流输出对象
 * FileName: DynamicByteCode
 * 
 * @author		hanYG
 * @createDate	2021.10.26
 * @alterDate	2021.10.26
 * @version		1.0
 *
 */
public class DynamicByteCode extends SimpleJavaFileObject {
	
	/** 源代码编译后的字节码 */
	private ByteArrayOutputStream byteArrayOutputStream;
	
	public DynamicByteCode(String className) {
		super(URI.create("byte:///" + className.replace('.', '/') + Kind.CLASS.extension), Kind.CLASS);
	}
	
	/**
	 * 用来输出字节码的构造函数
	 * @param className	类名
	 * @param byteArrayOutputStream	字节码
	 */
	public DynamicByteCode(String className, ByteArrayOutputStream byteArrayOutputStream) {
		this(className);
		this.byteArrayOutputStream = byteArrayOutputStream;
	}
	
	@Override
	public OutputStream openOutputStream() {
		if (this.byteArrayOutputStream == null) {
			this.byteArrayOutputStream = new ByteArrayOutputStream();
		}
		return this.byteArrayOutputStream;
	}
	
	/**
	 * 获取字节码
	 * @return Byte[]
	 */
	public byte[] getByteCode() {
		return this.byteArrayOutputStream.toByteArray();
	}
	
	/**
	 * 获取类名
	 * @return String
	 */
	public String getClassName() {
		String className = this.getName();
		className = className.replace('/', '.');
		className = className.substring(1, className.indexOf(".class"));
		return className;
	}
	
	
}
