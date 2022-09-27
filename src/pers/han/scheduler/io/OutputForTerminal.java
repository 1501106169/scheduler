package pers.han.scheduler.io;

import pers.han.scheduler.framework.RunAlgorithm;
import pers.han.scheduler.framework.RunAlgorithmCase;
import pers.han.scheduler.task.TimeBlock;

/**
 * ������Ƚ�����ն�
 * 
 * @author		hanYG
 * @createDate	2022��6��1��
 * @alterDate	2022��6��1��
 * @version		1.0
 *
 */
public class OutputForTerminal implements OutputSchedulingResult {
	/** ����ʵ�� */
	RunAlgorithm runAlgorithm;
	
	/**
	 * �����㷨
	 * @param runAlgorithm ����ʵ��
	 */
	public OutputForTerminal(RunAlgorithm runAlgorithm) {
		this.runAlgorithm = runAlgorithm;
	}
	
	@Override
	public void outSchedulingResult() {
		RunAlgorithmCase algorithmCase = RunAlgorithmCase.class.cast(this.runAlgorithm);
		System.out.println(algorithmCase.getCheckResult());
		System.out.println(algorithmCase.getExecTime());
		for (TimeBlock t : algorithmCase.getSchedulingResult()) {
			System.out.print(algorithmCase.getTaskSet().get(t.getTaskId()));
			System.out.print("--");
			System.out.print(t.getStartTime());
			System.out.print("--");
			System.out.print(t.getExecTime());
			System.out.print("\n");
		}

	}

}
