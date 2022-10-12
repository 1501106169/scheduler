package pers.han.scheduler.scheduling;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.TimeBlock;

import java.util.*;

public class PeriodicFIFOSchedulingAlgorithmEx extends SchedulingAlgorithm {
    class MyPeriodicTask extends PeriodicTask {
        private Integer id;

        MyPeriodicTask(PeriodicTask periodicTask, Integer taskId) {
            super(periodicTask);
            id = taskId;
        }

        MyPeriodicTask(PeriodicTask periodicTask, Integer taskId, Integer cycleStartTime) {
            super(periodicTask);
            id = taskId;
            super.cycleStartTime = cycleStartTime;
        }

    }

    class ExecuteInfo {

        private Integer executeTime;
        private Integer executedTaskId;

        ExecuteInfo(Integer executedTaskId, Integer executeTime) {
            this.executeTime = executeTime;
            this.executedTaskId = executedTaskId;
        }

    }

    private Vector<MyPeriodicTask> waitingTaskSet = new Vector<>();
    private LinkedList<MyPeriodicTask> readyTaskSet = new LinkedList<>();
    @Override
    public Vector<TimeBlock> doSchedule() {


        for (int i = 0; i < this.taskSet.size(); i++) {
            waitingTaskSet.add(new MyPeriodicTask((PeriodicTask) this.taskSet.get(i).clone(), i));
        }
        int i = 0;
        while (this.timeAxis < this.runEndTime) {
            Iterator<MyPeriodicTask> itr = waitingTaskSet.iterator();
            while (itr.hasNext()) {
                MyPeriodicTask waitingTask = itr.next();
                if (timeAxis >= waitingTask.getCycleStartTime() + waitingTask.getJobReleaseTime()) {
                    readyTaskSet.add(waitingTask);
                    itr.remove();
                }
            }
            ExecuteInfo executeInfo;
            executeInfo = executeOneJob();
            int execTime = executeInfo.executeTime;
            int executedTaskId = executeInfo.executedTaskId;
            if (execTime == 0) {
                this.timeAxis++;
            } else {
                this.schedulingResult.add(new TimeBlock(executedTaskId, this.timeAxis, execTime));
                i++;
                this.timeAxis += execTime;
            }
        }

        return this.schedulingResult;
    }

    private ExecuteInfo executeOneJob(){
        MyPeriodicTask lastTaskExecuted;
        if(readyTaskSet.isEmpty()){
            return new ExecuteInfo(-1,0);
        }
        MyPeriodicTask taskToExecute = readyTaskSet.getFirst();
        int executeTime = taskToExecute.getJobExecTime();
        taskToExecute.nextCycle();
        lastTaskExecuted = taskToExecute;
        waitingTaskSet.add(new MyPeriodicTask(lastTaskExecuted,
                lastTaskExecuted.id, lastTaskExecuted.getCycleStartTime()));
        readyTaskSet.pollFirst();
        return new ExecuteInfo(lastTaskExecuted.id, executeTime);
    }
}


