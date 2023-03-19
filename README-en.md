# scheduler

This software is called `scheduler`。
In addition, a project for a code submission sub-system for use with `scheduler` is included at the end of the document.

 * [Chinese Manual](https://github.com/1501106169/scheduler)
 * [English Manual](https://github.com/1501106169/scheduler/blob/master/README-en.md)

## Introduction

* `scheduler`is a simulator for verifying and experimenting with real-time scheduling algorithms.

`scheduler` is developed and implemented using the `Java` programming language. Its core code is a jar package called `scheduler.jar`.

### Catalogue Introduction
```
  - docs        document
  - fileData    test data section
  - src         source code
     - pers.han.scheduler.algorithms    generic algorithms and tools
     - pers.han.scheduler.check         checksum algorithms and performance indicators
     - pers.han.scheduler.compiler      dynamic compilation section
     - pers.han.scheduler.framework     core framework
     - pers.han.scheduler.io            input & output
     - pers.han.scheduler.runner        program launcher
     - pers.han.scheduler.scheduling    scheduler algorithm
     - pers.han.scheduler.task          task model
```

## Input & Output

### Input

* `test data`。see [data format](https://github.com/1501106169/scheduler/blob/master/docs/dataFormat.md)。
* `real-time scheduler algorithm`, the current version only supports algorithms implemented in the Java language. See [实时调度算法模板](https://github.com/1501106169/scheduler/blob/master/docs/schedulerAlgorithmModel.md) for input format.

### Output

All output information is output to external systems in the form of standard outputs.

* `Scheduling Programme`。
* `Validation Results` and `Performance Indicators`。


## User Manuals

### Real-time Task Model

Real-time tasks can be divided into three categories according to their periodicity constraints.

1. Periodic Task
2. Aperiodic Task
3. Sporadic Task

`scheduler` uses the above classification to build a real-time task model. see [Task Model](https://github.com/1501106169/scheduler/blob/master/docs/taskModel.md) for details.

### Real-Time Scheduling Algorithm Model

the real-time scheduling algorithm model based on a real-time task model. The user-implemented real-time scheduling algorithm needs to conform to the model constraints.
see [Real-Time Scheduling Algorithm Model](https://github.com/1501106169/scheduler/blob/master/docs/schedulerAlgorithmModel.md) for details.

### Public Interface Methods


### Deployment

 * [Chinese Deployment Manual](https://github.com/1501106169/scheduler/tree/master/docs/deployment)
 * [English Deployment Manual](https://github.com/1501106169/scheduler/tree/master/docs/deployment-en)


## Code Submission Sub-System

[Code Submission Sub-System repository link](https://github.com/1501106169/codeSubSystem)

## Original Statement

* This software is intended for study and research use.
* This software is only supported for secondary development or modification for learning and research purposes and may not be used for any activity for profit or for commercial purposes.
* For any commercial activity please contact the author.

Author's email: hanyg254@nenu.edu.cn；1501106169@qq.com
