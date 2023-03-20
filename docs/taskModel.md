
# 实时任务模型

* [中文文档](https://github.com/1501106169/scheduler/blob/master/docs/taskModel.md)
* [英文文档](https://github.com/1501106169/scheduler/blob/master/docs/taskModel-en.md)

## 基础模型（基类）

任务模型位于包`package pers.han.scheduler.task;`下。

### `JobPreemption` 枚举类型

标识作业的可抢占性。

 * `PREEMPTABLE` 标识作业可抢占
 * `NONPREEMPTABLE` 标识作业不可抢占

### `Task` 基类

各个成员属性介绍如下
 * `jobPreempt` `JobPreemption` 标识作业是否可抢占
 * `jobExecTime` `int` 标识执行时间
 * `jobDeadline` `int` 标识时限
 * `jobReleaseTime` `int` 标识施放时间
 * `taskPriority` `int` 标识优先级
 * `runTime` `int` 标识作业已经执行的时间

各个方法介绍如下
 - `public int getTaskPriority()` 获取任务优先级
    - `return:` `int` 任务优先级
 - `public void setTaskPriority(int priority)` 设置任务优先级
    - `param:` `priority` `int` 任务优先级
- `public JobPreemption getJobPreemption()` 获取作业可抢占性
    - `return:` `JobPreemption` 作业可抢占性
- `public int getJobExecTime()` 获取作业执行时间
    - `return:` `int` 作业执行时间
- `public int getJobDeadline()` 获取作业时限
    - `return:` `int` 作业时限
- `public int getJobReleaseTime()` 获取作业释放时间
    - `return:` `int` 作业释放时间
- `public String getClassName()` 获取类所属的包的名称
    - `return:` `String` 包名
- `public abstract Task clone()` 拷贝函数，深拷贝
    - `return:` `Task` 拷贝的对象
- `public void run()` 作业执行1个单位时间
- `public void run(int time)` 设置作业执行的时间
    - `param:` `time` `int` 执行时间
- `public int getRunTime()` 获取作业实际执行时间
    - `return:` `int` 作业实际执行时间

### `PeriodicTask` 类

周期任务模型，继承自`Task`。

增加的成员属性如下
 * `int` `taskPeriodic` 任务周期
 * `int` `cycleStartTime` 下一个周期开始时间

新增方法介绍如下
 - `public int getTaskPeriodic()` 获取任务周期
    - `return:` `int` 任务周期
 - `public int getCycleStartTime()` 获取下一个周期开始时间
    - `return:` `int` 下一个周期开始时间
 - `public void nextCycle()` 设置任务进入下一个周期

### `AperiodicTask` 类

非周期任务模型，继承自`Task`。

### `SporadicTask` 类

偶发任务模型，继承自`Task`。

### `TimeBlock` 类
`TimeBlock`类被定义为记录作业的每一次执行时间范围。表示`taskId`任务从`startTime`开始执行了`execTime`个时间单位。

各个成员属性介绍如下
 * `int` `taskId` 任务的Id。任务的Id取决于任务输入次序，第一个输入的任务Id为0
 * `int` `startTime` 作业开始执行时间
 * `int` `execTime` 作业执行时间

各个方法介绍如下
 - `public TimeBlock(int taskId, int startTime, int execTime)` 构造函数
    - `param:` `taskId` `int` 任务Id
    - `param:` `startTime` `int` 作业开始执行时间
    - `param:` `execTime` `int` 作业执行时间
 - `public int getTaskId()` 获取任务Id
    - `return:` `int` 任务Id 
 - `public int getStartTime()` 获取任务开始执行时间
    - `return:` `int` 任务开始执行时间
 - `public int getExecTime()` 获取任务执行时间
    - `return:` `int` 任务执行时间
 - `public TimeBlock clone()` 拷贝函数，深拷贝
    - `return:` `TimeBlock` 拷贝对象

