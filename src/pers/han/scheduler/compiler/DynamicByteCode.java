package pers.han.scheduler.compiler;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**
 * Դ�����ֽ����������
 * FileName: DynamicByteCode
 * 
 * @author		hanYG
 * @createDate	2021.10.26
 * @alterDate	2021.10.26
 * @version		1.0
 *
 */
public class DynamicByteCode extends SimpleJavaFileObject {
	
	/** Դ����������ֽ��� */
	private ByteArrayOutputStream byteArrayOutputStream;
	
	public DynamicByteCode(String className) {
		super(URI.create("byte:///" + className.replace('.', '/') + Kind.CLASS.extension), Kind.CLASS);
	}
	
	/**
	 * ��������ֽ���Ĺ��캯��
	 * @param className	����
	 * @param byteArrayOutputStream	�ֽ���
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
	 * ��ȡ�ֽ���
	 * @return Byte[]
	 */
	public byte[] getByteCode() {
		return this.byteArrayOutputStream.toByteArray();
	}
	
	/**
	 * ��ȡ����
	 * @return String
	 */
	public String getClassName() {
		String className = this.getName();
		className = className.replace('/', '.');
		className = className.substring(1, className.indexOf(".class"));
		return className;
	}
	
	
}
