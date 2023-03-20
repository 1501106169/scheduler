# Real-Time Task Model

 * [Chinese Manual](https://github.com/1501106169/scheduler/blob/master/docs/taskModel.md)
 * [English Manual](https://github.com/1501106169/scheduler/blob/master/docs/taskModel-en.md)


## Base Model

The Task Model is located under the Package `package pers.han.scheduler.task;`。

### Enum `JobPreemption`

Indicates the preemption of the job.

 * `PREEMPTABLE` indicates the preemptable of the job
 * `NONPREEMPTABLE` indicates the non-preemptable of the job

### Base Class `Task`

The individual member attributes are described below

 * `jobPreempt` `JobPreemption` indicates the preemption of the job
 * `jobExecTime` `int` indicates the execution time of the job
 * `jobDeadline` `int` indicates the deadline of the job
 * `jobReleaseTime` `int` indicates the release time of the job
 * `taskPriority` `int` indicates the priority of the job
 * `runTime` `int` indicates the executed time of the job

The individual methods are described below

 - `public int getTaskPriority()` get task priority
    - `return:` `int` task priority
 - `public void setTaskPriority(int priority)` set task priority
    - `param:` `priority` `int` task priority
- `public JobPreemption getJobPreemption()` get job preemption
    - `return:` `JobPreemption` job preemption
- `public int getJobExecTime()` get job execution time
    - `return:` `int` job execution time
- `public int getJobDeadline()` get job deadline
    - `return:` `int` job deadline
- `public int getJobReleaseTime()` get job release time
    - `return:` `int` job release time
- `public String getClassName()` get the name of the package to which the class belongs
    - `return:` `String` package name
- `public abstract Task clone()` deep copy based copy functions
    - `return:` `Task` new object
- `public void run()` job execute 1 unit time
- `public void run(int time)` job execute `time` unit time
    - `param:` `time` `int` executed time
- `public int getRunTime()` get job executed time
    - `return:` `int` job executed time

### Class `PeriodicTask`

Periodic task model, extends class `Task`.

The new member attributes are described below

 * `int` `taskPeriodic` task periodic
 * `int` `cycleStartTime` start time of the next periodic

The new methods added are described below

 - `public int getTaskPeriodic()` get task periodic
    - `return:` `int` task periodic
 - `public int getCycleStartTime()` get start time of next periodic
    - `return:` `int` start time of next periodic
 - `public void nextCycle()` set the task to go to the next periodic(cycle)

### Class `AperiodicTask`

APeriodic task model, extends class `Task`.

### Class `SporadicTask` 

Sporadic task model, extends class `Task`.

### Class `TimeBlock` 

class `TimeBlock` is defined as the time range for each execution of the job. Indicates that the `taskId` task has been executed for `execTime` units of time since `startTime`.

The individual member attributes are described below

 * `int` `taskId` task Id. The task Id depends on the task input order, the first input task Id is 0
 * `int` `startTime` job start execution time
 * `int` `execTime` job executed time

The individual methods are described below

 - `public TimeBlock(int taskId, int startTime, int execTime)` Constructors
    - `param:` `taskId` `int` task Id
    - `param:` `startTime` `int` job start execution time
    - `param:` `execTime` `int` job executed time
 - `public int getTaskId()` get task Id
    - `return:` `int` task Id
 - `public int getStartTime()` get job start execution time
    - `return:` `int` job start execution time
 - `public int getExecTime()` get job executed time
    - `return:` `int` job executed time
 - `public TimeBlock clone()` deep copy based copy functions
    - `return:` `TimeBlock` new object

