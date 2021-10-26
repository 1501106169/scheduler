package pers.han.scheduler.compiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class DynamicCompiler {
	
	/** ��ȡϵͳ��Java������ */
	private final JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
	
	/** ��̬������ļ������� */
	private StandardJavaFileManager standardFileManager = null;
	
	/** ����Ĳ��� */
	private final List<String> options = new ArrayList<String>();
	
	/** ������� */
	private DynamicClassLoader dynamicClassLoader = null;
	
	/** JavaFileObject��ɵĴ������Դ�ļ��б� */
	private final Collection<JavaFileObject> compilationUnits = new ArrayList<JavaFileObject>();
	
	private JavaFileManager fileManager = null;
	
	DiagnosticCollector<JavaFileObject> collector = null;
	
	/**
	 * ���캯������ʼ��
	 * @param classLoader ������������
	 */
	public DynamicCompiler(ClassLoader classLoader) {
		this.standardFileManager = this.javaCompiler.getStandardFileManager(null, null, null);
		this.options.add("-Xlint:unchecked");
		this.dynamicClassLoader = new DynamicClassLoader(classLoader);
	}
	
	/**
	 * ��Ӵ������Դ����
	 * @param className ����
	 * @param contents Դ����
	 */
	public void addSource(String className, String contents) {
		this.addSource(new DynamicSourceFile(className, contents));
	}
	
	/**
	 * ��Ӵ������Դ�����ļ�����
	 * @param javaFileObject �����Դ�ļ�����
	 */
	public void addSource(JavaFileObject javaFileObject) {
		this.compilationUnits.add(javaFileObject);
	}
	
	/**
	 * ִ�б������
	 * @return Boolean
	 */
	public boolean build() {
		this.fileManager = new DynamicFileManager(this.standardFileManager, this.dynamicClassLoader);
		this.collector = new DiagnosticCollector<JavaFileObject>();
		JavaCompiler.CompilationTask task = this.javaCompiler.getTask(null, this.fileManager, this.collector, this.options, null, this.compilationUnits);
		return task.call();
	}
	
	/**
	 * ��ȡ���е���������
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
	 * ��ȡ���е��������ֽ���
	 * @return Map<String, byte[]>
	 */
	public Map<String, byte[]> getByteCodes() {
		return this.dynamicClassLoader.getByteCodes();
	}
	
	/**
	 * ��ȡ������Ϣ
	 * @return List<Diagnostic<? extends JavaFileObject>>
	 */
	public List<Diagnostic<? extends JavaFileObject>> getBuildError() {
		System.out.println(this.collector.getDiagnostics());
		return this.collector.getDiagnostics();
	}
	
}
