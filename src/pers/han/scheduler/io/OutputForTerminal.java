package pers.han.scheduler.io;

import pers.han.scheduler.framework.RunAlgorithm;
import pers.han.scheduler.framework.RunAlgorithmCase;
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
		RunAlgorithmCase algorithmCase = RunAlgorithmCase.class.cast(this.runAlgorithm);
		System.out.print("算法可行性: ");
		System.out.println(algorithmCase.getCheckResult());
		System.out.print("算法执行时间: ");
		System.out.println(algorithmCase.getExecTime());
		System.out.println("调度结果: ");
		for (TimeBlock t : algorithmCase.getSchedulingResult()) {
			System.out.print(algorithmCase.getTaskSet().get(t.getTaskId()));
			System.out.print("--");
			System.out.print(t.getTaskId());
			System.out.print("--");
			System.out.print(t.getStartTime());
			System.out.print("--");
			System.out.print(t.getExecTime());
			System.out.print("\n");
		}

	}

}
