package pers.han.scheduler.io;

import pers.han.scheduler.algroithms.SchedulingAlgorithm;

/**
 * ���ļ��л�ȡ�����㷨
 * 
 * @author		hanYG
 * @createDate	2022��5��29��
 * @alterDate	2022��5��29��
 * @version		1.0
 *
 */
public class InputAlgorithmFromFile implements InputAlgorithm {
	/** �ļ�·�� */
	String filePath;
	
	/**
	 * ���캯��
	 * @param filePath �ļ�·��
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
	 * ����Դ���봴������
	 * @param algorithmCodeStr Դ����
	 * @return SchedulingAlgorithm
	 */
	public SchedulingAlgorithm getAlgorithm(String algorithmCodeStr) {
		return null;
	}

}
