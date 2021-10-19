package pers.han.scheduler.io;

/**
 * 图表中各类型任务的颜色
 * FileName: ChartColor.java
 * 
 * @author		hanYG
 * @createDate	2021.10.15
 * @alterDate	2021.10.19
 * @version		1.0
 *
 */
public final class ChartColor {

	/** 偶发性任务的表示颜色 */
	private static final String[] sporadicTaskColorStrArray = {
			"#FF0000",	// 红色
			"#00FF00",	// 绿色
			"#0000FF",	// 蓝色
			"#FF00FF",	// 紫色
			"#FFFF00",	// 黄色
			"#00FFFF",	// 
			// "#FFFFFF"	// 白色
			"#000000"	// 黑色
	};
	
	/** 非周期性任务的表示颜色 */
	private static final String[] aperiodicTaskColorStrArray = {
			"#FF0000",	// 红色
			"#00FF00",	// 绿色
			"#0000FF",	// 蓝色
			"#FF00FF",	// 紫色
			"#FFFF00",	// 黄色
			"#00FFFF",	// 
			// "#FFFFFF"	// 白色
			"#000000"	// 黑色
	};
	
	/** 周期性任务的表示颜色 */
	private static final String[] periodicTaskColorStrArray = {
			"#FF0000",	// 红色
			"#00FF00",	// 绿色
			"#0000FF",	// 蓝色
			"#FF00FF",	// 紫色
			"#FFFF00",	// 黄色
			"#00FFFF",	// 
			// "#FFFFFF"	// 白色
			"#000000"	// 黑色
	};
	
	/** windows 默认颜色 r=51 g=51 b=51 */
	public static final String defaultColorStr = "#515151";
	
	/** 红色 */
	public static final String redStr = "#FF0000";
	
	/** 绿色 */
	public static final String greenStr = "#00FF00";
	
	/** 蓝色 */
	public static final String blueStr = "#0000FF";

	/** 执向偶发性任务颜色的标记 */
	private int sporadicTaskColorStrArrayIndex = 0;
	
	/** 执向非周期性任务颜色的标记 */
	private int aperiodicTaskColorStrArrayIndex = 0;
	
	/** 执向周期性任务颜色的标记 */
	private int periodicTaskColorStrArrayIndex = 0;
	
	/**
	 * 获取偶发任务的下一个表示颜色
	 * @return	String
	 */
	public String getSporadicTaskColorStr() {
		if (this.sporadicTaskColorStrArrayIndex >= ChartColor.sporadicTaskColorStrArray.length) {
			this.sporadicTaskColorStrArrayIndex = 0;
		}
		return ChartColor.sporadicTaskColorStrArray[this.sporadicTaskColorStrArrayIndex++];
	}
	
	/**
	 * 获取非周期性任务的下一个表示颜色
	 * @return	String
	 */
	public String getAperiodicTaskColorStr() {
		if (this.aperiodicTaskColorStrArrayIndex >= ChartColor.aperiodicTaskColorStrArray.length) {
			this.aperiodicTaskColorStrArrayIndex = 0;
		}
		return ChartColor.aperiodicTaskColorStrArray[this.aperiodicTaskColorStrArrayIndex++];
	}
	
	/**
	 * 获取周期性任务的下一个表示颜色
	 * @return	String
	 */
	public String getPeriodicTaskColorStr() {
		if (this.periodicTaskColorStrArrayIndex >= ChartColor.periodicTaskColorStrArray.length) {
			this.periodicTaskColorStrArrayIndex = 0;
		}
		return ChartColor.periodicTaskColorStrArray[this.periodicTaskColorStrArrayIndex++];
	}
	
	/**
	 * 获取偶发性任务表示的颜色
	 * @param index	索引
	 * @return	String
	 */
	public static String getSporadicTaskColorStr(int index) {
		return ChartColor.sporadicTaskColorStrArray[index % ChartColor.sporadicTaskColorStrArray.length];
	}
	
	/**
	 * 获取非周期任务表示的颜色
	 * @param index	索引
	 * @return	String
	 */
	public static String getAperiodicTaskColorStr(int index) {
		return ChartColor.aperiodicTaskColorStrArray[index % ChartColor.aperiodicTaskColorStrArray.length];
	}
	
	/**
	 * 获取周期性任务表示的颜色
	 * @param index	索引
	 * @return	String
	 */
	public static String getPeriodicTaskColorStr(int index) {
		return ChartColor.periodicTaskColorStrArray[index % ChartColor.periodicTaskColorStrArray.length];
	}
	
	
	/**
	 * 构造函数
	 */
	public ChartColor() { }
	
}
