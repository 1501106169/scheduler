package pers.han.scheduler.io;

import pers.han.scheduler.algroithms.SchedulingAlgorithm;

/**
 * 从文件中获取调度算法
 * 
 * @author		hanYG
 * @createDate	2022年5月29日
 * @alterDate	2022年5月29日
 * @version		1.0
 *
 */
public class InputAlgorithmFromFile implements InputAlgorithm {
	/** 文件路径 */
	String filePath;
	
	/**
	 * 构造函数
	 * @param filePath 文件路径
	 */
	public InputAlgorithmFromFile(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public SchedulingAlgorithm getAlgorithm() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 根据源代码创建对象
	 * @param algorithmCodeStr 源代码
	 * @return SchedulingAlgorithm
	 */
	public SchedulingAlgorithm getAlgorithm(String algorithmCodeStr) {
		return null;
	}

}
