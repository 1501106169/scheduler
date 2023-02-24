# scheduler

本软件名为 `scheduler`。

## 简介

* `scheduler`是一款用于验证和试验实时调度算法的模拟器。

scheduler使用Java编程语言开发实现。它的核心代码是一个jar包，名为scheduler.jar。

### 目录简介
```
  - docs        文档
  - fileData    部分测试数据
  - src         源代码
     - pers.han.scheduler.algorithms    通用算法和工具
     - pers.han.scheduler.check         校验算法和性能指标
     - pers.han.scheduler.compiler      动态编译部分
     - pers.han.scheduler.framework     核心框架
     - pers.han.scheduler.io            输入输出
     - pers.han.scheduler.runner        程序启动器
     - pers.han.scheduler.scheduling    调度算法
     - pers.han.scheduler.task          任务模型
```

## 输入输出

### 输入

* `测试数据`。见[数据格式](https://github.com/1501106169/scheduler/blob/master/docs/dataFormat.md)。
* `实时调度算法`，当前版本仅支持Java语言实现的算法。输入格式见[实时调度算法模板](https://github.com/1501106169/scheduler/blob/master/docs/schedulerAlgorithmModel.md)。

### 输出

所有输出信息均以标准输出形式输出到外部系统。

* `调度方案`。
* `验证结果`和 `性能指标`。

## 用户手册

### 实时任务模型

根据实时任务的周期性约束，可以将实时任务分为三类：

1. 周期任务（Periodic Task）
2. 非周期任务（Aperiodic Task）
3. 偶发任务（Sporadic Task）

`scheduler`采用上述分类方式，建立实时任务模型。详细介绍见[任务模型](https://github.com/1501106169/scheduler/blob/master/docs/taskModel.md)。

### 实时调度算法模型

基于实时任务模型，建立实时调度算法模型。用户实现的实时调度算法需要符合模型约束。
具体信息见[实时调度算法模型](https://github.com/1501106169/scheduler/blob/master/docs/schedulerAlgorithmModel.md)。

### 公共接口方法

## 原创声明

* 本软件作为学习和研究使用。
* 本软件仅支持以学习和科研为目的的二次开发或修改，不得用于以营利为目的的任何活动或进行商业用途。
* 若要进行任何商业活动请与作者联系。

作者邮箱：hanyg254@nenu.edu.cn；1501106169@qq.com
