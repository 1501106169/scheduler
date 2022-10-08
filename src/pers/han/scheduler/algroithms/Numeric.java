package pers.han.scheduler.algroithms;

import java.util.Vector;

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
	private Numeric() { }
	
	/**
	 * 静态函数，计算最小公倍数
	 * @param digitalList 一组正整数
	 * @return Integer
	 */
	public static int leastCommonMultiple(final Vector<Integer> digitalList) {
		int digitalListLen = digitalList.size();
		if (digitalListLen == 0) {
			return 1;
		}
		if (digitalListLen == 1) {
			return digitalList.get(0);
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
	public static int leastCommonMultiple(final int a, int b) {
		if (a == 0 || b == 0) {
			throw new Error("求最小公倍数的两个数均不可为0！");
		}
		return a * b / greatestCommonDivisor(a, b);
	}
	
	/**
	 * 计算最大公约数
	 * @return	Integer
	 */
	public static int greatestCommonDivisor(final Vector<Integer> digitalList) {
		
		return 0;
	}
	
	/**
	 * 计算两个数的最大公约数
	 * @param a	数字a
	 * @param b	数字b
	 * @return	Integer
	 */
	public static int greatestCommonDivisor(final int a, final int b) {
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
	
	/**
	 * 求数列方差
	 * @param nums double类型的数列
	 * @return Double
	 */
	public static double variance(final Vector<Double> nums) {
		int numsLen = nums.size();
		double numsSum = 0;
		double numsAvg;
		double squareSum = 0;
		for(double d : nums) {
			numsSum += d;
		}
		numsAvg = numsSum / numsLen;
		for (double d : nums) {
			squareSum += Math.pow(d - numsAvg, 2);
		}
		return squareSum / numsLen;
	}
	
}
