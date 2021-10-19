package pers.han.scheduler.io;

/**
 * ͼ���и������������ɫ
 * FileName: ChartColor.java
 * 
 * @author		hanYG
 * @createDate	2021.10.15
 * @alterDate	2021.10.19
 * @version		1.0
 *
 */
public final class ChartColor {

	/** ż��������ı�ʾ��ɫ */
	private static final String[] sporadicTaskColorStrArray = {
			"#FF0000",	// ��ɫ
			"#00FF00",	// ��ɫ
			"#0000FF",	// ��ɫ
			"#FF00FF",	// ��ɫ
			"#FFFF00",	// ��ɫ
			"#00FFFF",	// 
			// "#FFFFFF"	// ��ɫ
			"#000000"	// ��ɫ
	};
	
	/** ������������ı�ʾ��ɫ */
	private static final String[] aperiodicTaskColorStrArray = {
			"#FF0000",	// ��ɫ
			"#00FF00",	// ��ɫ
			"#0000FF",	// ��ɫ
			"#FF00FF",	// ��ɫ
			"#FFFF00",	// ��ɫ
			"#00FFFF",	// 
			// "#FFFFFF"	// ��ɫ
			"#000000"	// ��ɫ
	};
	
	/** ����������ı�ʾ��ɫ */
	private static final String[] periodicTaskColorStrArray = {
			"#FF0000",	// ��ɫ
			"#00FF00",	// ��ɫ
			"#0000FF",	// ��ɫ
			"#FF00FF",	// ��ɫ
			"#FFFF00",	// ��ɫ
			"#00FFFF",	// 
			// "#FFFFFF"	// ��ɫ
			"#000000"	// ��ɫ
	};
	
	/** windows Ĭ����ɫ r=51 g=51 b=51 */
	public static final String defaultColorStr = "#515151";
	
	/** ��ɫ */
	public static final String redStr = "#FF0000";
	
	/** ��ɫ */
	public static final String greenStr = "#00FF00";
	
	/** ��ɫ */
	public static final String blueStr = "#0000FF";

	/** ִ��ż����������ɫ�ı�� */
	private int sporadicTaskColorStrArrayIndex = 0;
	
	/** ִ���������������ɫ�ı�� */
	private int aperiodicTaskColorStrArrayIndex = 0;
	
	/** ִ��������������ɫ�ı�� */
	private int periodicTaskColorStrArrayIndex = 0;
	
	/**
	 * ��ȡż���������һ����ʾ��ɫ
	 * @return	String
	 */
	public String getSporadicTaskColorStr() {
		if (this.sporadicTaskColorStrArrayIndex >= ChartColor.sporadicTaskColorStrArray.length) {
			this.sporadicTaskColorStrArrayIndex = 0;
		}
		return ChartColor.sporadicTaskColorStrArray[this.sporadicTaskColorStrArrayIndex++];
	}
	
	/**
	 * ��ȡ���������������һ����ʾ��ɫ
	 * @return	String
	 */
	public String getAperiodicTaskColorStr() {
		if (this.aperiodicTaskColorStrArrayIndex >= ChartColor.aperiodicTaskColorStrArray.length) {
			this.aperiodicTaskColorStrArrayIndex = 0;
		}
		return ChartColor.aperiodicTaskColorStrArray[this.aperiodicTaskColorStrArrayIndex++];
	}
	
	/**
	 * ��ȡ�������������һ����ʾ��ɫ
	 * @return	String
	 */
	public String getPeriodicTaskColorStr() {
		if (this.periodicTaskColorStrArrayIndex >= ChartColor.periodicTaskColorStrArray.length) {
			this.periodicTaskColorStrArrayIndex = 0;
		}
		return ChartColor.periodicTaskColorStrArray[this.periodicTaskColorStrArrayIndex++];
	}
	
	/**
	 * ��ȡż���������ʾ����ɫ
	 * @param index	����
	 * @return	String
	 */
	public static String getSporadicTaskColorStr(int index) {
		return ChartColor.sporadicTaskColorStrArray[index % ChartColor.sporadicTaskColorStrArray.length];
	}
	
	/**
	 * ��ȡ�����������ʾ����ɫ
	 * @param index	����
	 * @return	String
	 */
	public static String getAperiodicTaskColorStr(int index) {
		return ChartColor.aperiodicTaskColorStrArray[index % ChartColor.aperiodicTaskColorStrArray.length];
	}
	
	/**
	 * ��ȡ�����������ʾ����ɫ
	 * @param index	����
	 * @return	String
	 */
	public static String getPeriodicTaskColorStr(int index) {
		return ChartColor.periodicTaskColorStrArray[index % ChartColor.periodicTaskColorStrArray.length];
	}
	
	
	/**
	 * ���캯��
	 */
	public ChartColor() { }
	
}
