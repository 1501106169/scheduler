package pers.han.scheduler.framework;

/**
 * 
 * FileName: BaseTaskCase.java
 * 
 * @author		hanYG
 * @createDate	2022��5��24��
 * @alterDate	2022��5��24��
 * @version		1.0
 *
 */
public interface BaseTaskCase {
	
	/**
	 * ��ȡ�������ݵĸ���
	 * @return
	 */
	public abstract int countTaskCase();
	
	/**
	 * ִ�в���
	 */
	public abstract void run();

}
