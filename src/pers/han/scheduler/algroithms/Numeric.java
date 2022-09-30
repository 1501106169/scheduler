package pers.han.scheduler.algroithms;

import java.util.ArrayList;

/**
 * 包含一组数学算法
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
	 * 私有构造函数，该类不可实例化
	 */
	private Numeric() {
		
	}
	
	/**
	 * 静态函数，计算最小公倍数
	 * @param digitalList
	 * @return
	 */
	public static int leastCommonMultiple(ArrayList<Integer> digitalList) {
		int digitalListLen = digitalList.size();
		if (digitalListLen < 2) {
			throw new Error("数组长度小于2！");
		}
		int lcm = digitalList.get(0);
		for (int i = 1; i < digitalListLen; ++i) {
			lcm = leastCommonMultiple(lcm, digitalList.get(i));
		}
		return lcm;
	}
	
	/**
	 * 计算两个数的最小公倍数
	 * @param a	数字a
	 * @param b	数字b
	 * @return	Integer
	 */
	public static int leastCommonMultiple(int a, int b) {
		if (a == 0 || b == 0) {
			throw new Error("求最小公倍数的两个数均不可为0！");
		}
		return a * b / greatestCommonDivisor(a, b);
	}
	
	/**
	 * 计算最大公约数
	 * @return	Integer
	 */
	public static int greatestCommonDivisor(ArrayList<Integer> digitalList) {
		
		return 0;
	}
	
	/**
	 * 计算两个数的最大公约数
	 * @param a	数字a
	 * @param b	数字b
	 * @return	Integer
	 */
	public static int greatestCommonDivisor(int a, int b) {
		if (a == 0 || b == 0) {
			throw new Error("求最大公约数的两个数均不可为0！");
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
