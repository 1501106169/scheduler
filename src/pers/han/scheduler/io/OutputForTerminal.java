package pers.han.scheduler.io;

import pers.han.scheduler.framework.RunAlgorithm;
import pers.han.scheduler.framework.RunAlgorithmTestCase;
import pers.han.scheduler.task.TimeBlock;

/**
 * 输出调度结果到终端
 * 
 * @author		hanYG
 * @createDate	2022年6月1日
 * @alterDate	2022年6月1日
 * @version		1.0
 *
 */
public class OutputForTerminal implements OutputSchedulingResult {
	/** 调度实例 */
	RunAlgorithm runAlgorithm;
	
	/**
	 * 构造算法
	 * @param runAlgorithm 调度实例
	 */
	public OutputForTerminal(RunAlgorithm runAlgorithm) {
		this.runAlgorithm = runAlgorithm;
	}
	
	@Override
	public void outSchedulingResult() {
		RunAlgorithmTestCase algorithmCase = RunAlgorithmTestCase.class.cast(this.runAlgorithm);
		System.out.print("FEASIBILITY: ");
		System.out.println(algorithmCase.getCheckResult());
		System.out.print("EXECTION TIME: ");
		System.out.println(algorithmCase.getExecTime());
		System.out.println("SCHEDULE TIME: ");
		for (TimeBlock t : algorithmCase.getSchedulingResult()) {
			System.out.print(t.getTaskId());
			System.out.print("--");
			System.out.print(t.getStartTime());
			System.out.print("--");
			System.out.print(t.getExecTime());
			System.out.print("\n");
		}

	}

}
