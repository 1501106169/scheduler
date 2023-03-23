# 调度算法模型

 * [中文文档](https://github.com/1501106169/scheduler/blob/master/docs/schedulerAlgorithmModel.md)
 * [英文文档](https://github.com/1501106169/scheduler/blob/master/docs/schedulerAlgorithmModel-en.md)

## `SchedulingAlgorithm` 类

`SchedulingAlgorithm` 类是抽象类，作为所有调度算法的基类。


各个成员属性介绍如下

 - `Vector<Task>` `taskSet` 一组实时任务
 - `int` `runEndTime` 算法运行结束时间
 - `int` `timeAxis` 表示模拟的时间
 - `Vector<TimeBlock>` `schedulingResult` 调度结果

各个方法介绍如下

 - `public void setUp(final Vector<Task> taskSet, final int runEndTime)` 执行算法的初始化工作
    - `param:` `taskSet` `Vector<Task>` 一组实时任务
    - `param:` `runEndTime` `int` 算法运行结束时间
 - `public void tearDown()` 执行算法完成后执行的工作
 - `public abstract Vector<TimeBlock> doSchedule()` 执行算法，需要用户具体实现
    - `return:` `Vector<TimeBlock>` 调度结果
 - `public void addTask(final Task sporadicTask, final int runEndTime)` 向测试任务中加入偶发任务
    - `param:` `sporadicTask` `Task` 一个偶发任务
    - `param:` `runEndTime` `int` 算法运行结束时间
 - `public void setRunEndTime(int runEndTime)` 设置算法运行结束时间
    - `param:` `runEndTime` `int` 算法运行结束时间
 - `public Vector<TimeBlock> getSchedulingResult()` 获取调度结果
    - `return:` `Vector<TimeBlock>` 调度结果

## 使用方法

 * 用户需要继承`SchedulingAlgorithm`类，实现其中的`doSchedule()`方法。
 * `doSchedule()`方法需要执行到`runEndTime`结束。
 * 调度结果需要放在`schedulingResult`中。
 * 示例，从`s`时刻开始调度任务`1``e`时间，表示为  `this.schedulingResult.add(new TimeBlock(1, s, e));`

## 算法模板

```
import java.util.Vector;

import pers.han.scheduler.task.TimeBlock;
import pers.han.scheduler.scheduling.SchedulingAlgorithm;
import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;

public class Algorithm extends SchedulingAlgorithm {
    /**
     * 一组实时任务
     * Vector<Task> taskSet
     *
     * 算法运行结束时间
     * int runEndTime
     *
     * 算法运行的时间轴
     * int timeAxis
     *
     * 调度结果
     * Vector<TimeBlock> schedulingResult
    */
    @Override
    public Vector<TimeBlock> doSchedule() {
        // write your code in here 
    }
}
```

## 附录

 * `package pers.han.scheduler.scheduling`包中实现了一些实时调度算法。

