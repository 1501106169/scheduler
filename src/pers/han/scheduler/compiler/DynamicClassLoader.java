package pers.han.scheduler.compiler;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 类加载器，findClass负责加载类
 * FileName: DynamicClassLoader.java
 * 
 * @author		hanYG
 * @createDate	2021.10.26
 * @alterDate	2021.10.26
 * @version		1.0
 *
 */
public class DynamicClassLoader extends ClassLoader {
	/** 类名和字节码的映射 */
	private final Map<String, DynamicByteCode> byteCodes = new HashMap<String, DynamicByteCode>();
	
	public DynamicClassLoader(ClassLoader classLoader) {
		super(classLoader);
	}
	
	@Override
	protected Class<?> findClass(String className) throws ClassNotFoundException {
		DynamicByteCode dynamicByteCode = this.byteCodes.get(className);
		if (dynamicByteCode == null) {
			return super.findClass(className);
		}
		return super.defineClass(className, dynamicByteCode.getByteCode(), 0, dynamicByteCode.getByteCode().length);
	}
	
	/**
	 * 添加类和字节码
	 * @param dynamicByteCode 字节流输出对象
	 */
	public void registerCompiledSource(DynamicByteCode dynamicByteCode) {
		this.byteCodes.put(dynamicByteCode.getClassName(), dynamicByteCode);
	}
	
	/**
	 * 获取类名和类
	 * @return Map<String, Class<?>>
	 * @throws ClassNotFoundException
	 */
	public Map<String, Class<?>> getClasses() throws ClassNotFoundException {
		Map<String, Class<?>> classes = new HashMap<String, Class<?>>();
		for (DynamicByteCode byteCode : this.byteCodes.values()) {
			classes.put(byteCode.getClassName(), this.findClass(byteCode.getClassName()));
		}
		return classes;
	}
	
	/**
	 * 获取类名和字节码
	 * @return Map<String, byte[]>
	 */
	public Map<String, byte[]> getByteCodes() {
		Map<String, byte[]> byteCodes = new HashMap<String, byte[]>(this.byteCodes.size());
		for (Entry<String, DynamicByteCode> entry : this.byteCodes.entrySet()) {
			byteCodes.put(entry.getKey(), entry.getValue().getByteCode());
		}
		return byteCodes;
	}
	
}
