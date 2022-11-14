package pers.han.scheduler.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * 动态编译管理
 * 
 * @author		hanYG
 * @createDate	2022年10月5日
 * @alterDate	2022年10月5日
 * @version		1.0
 *
 */
public final class DynamicCompilerManager {
	
	/** 动态编译器 */
	private final DynamicCompiler dynamicCompiler;
	
	/** 编译错误 */
	private String buildErrorStr = null;
	
	/**
	 * 给构造函数，使用系统默认类加载器
	 */
	public DynamicCompilerManager() {
		// 使用系统默认类加载器 */
		this.dynamicCompiler = new DynamicCompiler(ClassLoader.getSystemClassLoader());
	}
	
	/**
	 * 构造函数，使用定义的类加载器
	 * @param classLoader 类加载器
	 */
	public DynamicCompilerManager(ClassLoader classLoader) {
		this.dynamicCompiler = new DynamicCompiler(classLoader);
	}
	
	/**
	 * 读取文件夹下所有java源文件到编译器中
	 * @param dirPath 文件夹路径
	 */
	public void addSourceDir(final String dirPath) {
		File[] sourceFileArray = new File(dirPath).listFiles((path)->path.getName().endsWith(".java"));
		if (sourceFileArray == null) {
			return;
		}
		for (File sourceFile : sourceFileArray) {
			int index = sourceFile.getName().indexOf(".java");
			String className = sourceFile.getName().substring(0, index);
			String sourceCodeStr = this.readFile(sourceFile);
			if (sourceCodeStr == null) {
				continue;
			}
			this.dynamicCompiler.addSource(className, sourceCodeStr);
		}
	}
	
	/**
	 * 读取一个java源文件到编译器中
	 * @param filePath 源文件路径
	 */
	public boolean addSourceFile(final String filePath) {
		File sourceFile = new File(filePath);
		// 保证文件存在，切是java源文件
		if (sourceFile.isFile() == false || sourceFile.getName().endsWith(".java") == false) {
			return false;
		}
		int index = sourceFile.getName().indexOf(".java");
		String className = sourceFile.getName().substring(0, index);
		String sourceCodeStr = this.readFile(sourceFile);
		if (sourceCodeStr == null) {
			return false;
		}
		this.dynamicCompiler.addSource(className, sourceCodeStr);
		return true;
	}
	
	/**
	 * 读取文件内容
	 * @param file 文件File
	 * @return String
	 */
	private String readFile(File file) {
		String sourceLineStr = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((sourceLineStr = reader.readLine()) != null) {
				stringBuilder.append(sourceLineStr);
				stringBuilder.append("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 编译，加载
	 */
	public Map<String, Class<?>> compile() {
		boolean isErr;
		try {
			isErr = this.dynamicCompiler.build();
		} catch(Exception e) {
			this.buildErrorStr = e.getMessage();
			isErr = false;
		}
		if (isErr == false) {
			this.buildErrorStr = this.dynamicCompiler.getBuildError();
			return null;
		}
		return this.dynamicCompiler.getClasses();
	}
	
	/**
	 * 获取编译错误
	 * @return String
	 */
	public String getBuildError() {
		return this.buildErrorStr;
	}
	
}
