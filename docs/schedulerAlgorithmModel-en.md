# Real-Time Scheduling Algorithm Model

 * [Chinese Manual](https://github.com/1501106169/scheduler/blob/master/docs/schedulerAlgorithmModel.md)
 * [English Manual](https://github.com/1501106169/scheduler/blob/master/docs/schedulerAlgorithmModel-en.md)

## class `SchedulingAlgorithm`

Class `SchedulingAlgorithm` is the abstract class that serves as the base class for all scheduling algorithms.

The individual member attributes are described below

 - `Vector<Task>` `taskSet` a set of real-time tasks
 - `int` `runEndTime` algorithm run end time
 - `int` `timeAxis` indicates the time of the simulation
 - `Vector<TimeBlock>` `schedulingResult` scheduling result

The individual methods are described below

 - `public void setUp(final Vector<Task> taskSet, final int runEndTime)` performing the initialisation of the algorithm
    - `param:` `taskSet` `Vector<Task>` a set of real-time tasks
    - `param:` `runEndTime` `int` algorithm run end time
 - `public void tearDown()` execution of work performed after completion of the algorithm
 - `public abstract Vector<TimeBlock> doSchedule()` run algorithm, user specific implementation required
    - `return:` `Vector<TimeBlock>` scheduling result
 - `public void addTask(final Task sporadicTask, final int runEndTime)` adding Sporadic task to the test data
    - `param:` `sporadicTask` `Task` a sporadic task
    - `param:` `runEndTime` `int` algorithm run end time
 - `public void setRunEndTime(int runEndTime)` set algorithm run end time
    - `param:` `runEndTime` `int` algorithm run end time
 - `public Vector<TimeBlock> getSchedulingResult()` get scheduling result
    - `return:` `Vector<TimeBlock>` scheduling result

## Usage

 * The user needs to extends the class `SchedulingAlgorithm` and implement the `doSchedule()` method.
 * The `doSchedule()` method needs to be executed until the end of `runEndTime`.
 * The scheduling result needs to be placed in `schedulingResult`.
 * Example, Scheduling of tasks `1` `e` times from the `s` moment, expressed as  `this.schedulingResult.add(new TimeBlock(1, s, e));`

## algorithm templates

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
## Appendix

 * The `package pers.han.scheduler.scheduling` package implements a number of real-time scheduling algorithms.
