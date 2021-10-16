package pers.han.scheduler.algroithms;

import java.util.ArrayList;

/**
 * ����һ����ѧ�㷨
 * FileName: numeric.java
 * 
 * @author		hanYG
 * @createDate	2021.10.10
 * @alterDate	2021.10.10
 * @version		1.0
 *
 */
public class Numeric {
	/**
	 * ˽�й��캯�������಻��ʵ����
	 */
	private Numeric() {
		
	}
	
	/**
	 * ��̬������������С������
	 * @param digitalList
	 * @return
	 */
	public static int leastCommonMultiple(ArrayList<Integer> digitalList) {
		int digitalListLen = digitalList.size();
		if (digitalListLen < 2) {
			throw new Error("���鳤��С��2��");
		}
		int lcm = digitalList.get(0);
		for (int i = 1; i < digitalListLen; ++i) {
			lcm = leastCommonMultiple(lcm, digitalList.get(i));
		}
		return lcm;
	}
	
	/**
	 * ��������������С������
	 * @param a	����a
	 * @param b	����b
	 * @return	Integer
	 */
	public static int leastCommonMultiple(int a, int b) {
		if (a == 0 || b == 0) {
			throw new Error("����С��������������������Ϊ0��");
		}
		return a * b / greatestCommonDivisor(a, b);
	}
	
	/**
	 * �������Լ��
	 * @return	Integer
	 */
	public static int greatestCommonDivisor(ArrayList<Integer> digitalList) {
		
		return 0;
	}
	
	/**
	 * ���������������Լ��
	 * @param a	����a
	 * @param b	����b
	 * @return	Integer
	 */
	public static int greatestCommonDivisor(int a, int b) {
		if (a == 0 || b == 0) {
			throw new Error("�����Լ����������������Ϊ0��");
		}
		int max = a > b ? a : b;
		int min = max == a ? b : a;
		if (max % min == 0) {
			return min;
		} else {
			return greatestCommonDivisor(min, max % min);
		}
	}
	
	
}
