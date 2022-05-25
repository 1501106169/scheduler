package pers.han.scheduler.framework;

/**
 * 
 * FileName: BaseTaskCase.java
 * 
 * @author		hanYG
 * @createDate	2022年5月24日
 * @alterDate	2022年5月24日
 * @version		1.0
 *
 */
public interface BaseTaskCase {
	
	/**
	 * 获取测试数据的个数
	 * @return
	 */
	public abstract int countTaskCase();
	
	/**
	 * 执行测试
	 */
	public abstract void run();

}
