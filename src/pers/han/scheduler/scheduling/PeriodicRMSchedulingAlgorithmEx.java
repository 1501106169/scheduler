package pers.han.scheduler.scheduling;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.TimeBlock;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class PeriodicRMSchedulingAlgorithmEx extends SchedulingAlgorithm {
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
    class ExecuteInfo{

        private Integer executeTime;
        private Integer executedTaskId;
        ExecuteInfo(Integer executedTaskId, Integer executeTime){
            this.executeTime = executeTime;
            this.executedTaskId = executedTaskId;
        }

    }

    private Vector<MyPeriodicTask> waitingTaskSet = new Vector<>();
    @Override
    public Vector<TimeBlock> doSchedule() {
        //TODO Pass isPreemptive Value
        boolean isPreemptive = false;
        ReadyTaskSet readyTaskSet = new ReadyTaskSet(isPreemptive);

        for(int i = 0; i < this.taskSet.size(); i++){
            waitingTaskSet.add(new MyPeriodicTask((PeriodicTask) this.taskSet.get(i).clone(),i));
        }
        if(isPreemptive){

        }else{
            int i = 0;
            while (this.timeAxis < this.runEndTime) {
//                if(this.timeAxis != 0 && lastExecutedTask != null && this.timeAxis % lastExecutedTask.getTaskPeriodic() == 0){
//                if(lastExecutedTask != null && this.timeAxis == lastExecutedTask.getCycleStartTime()){
//                    readyTaskSet.addTask(lastExecutedTask);
//                }
                Iterator<MyPeriodicTask> itr = waitingTaskSet.iterator();
                while (itr.hasNext()){
                    MyPeriodicTask waitingTask = itr.next();
                    /*
                        If current time == waitingTask, including their values are both 0, add it;
                        If current time != waitingTask:
                            if current time == 0 : wait directly, because 0 mod every number is 0;
                            else : if currentTime mod waitingTask.releaseTime == 0, add it
                     */
//                    if(timeAxis >= waitingTask.getJobReleaseTime()){
                    if(timeAxis >= waitingTask.getCycleStartTime()){
                        readyTaskSet.addTask(waitingTask);
                        itr.remove();
                    }
                }
//                for(MyPeriodicTask waitingTask: waitingTaskSet){
//                    if(this.timeAxis % waitingTask.getJobReleaseTime() == 0){
//                        readyTaskSet.addTask(waitingTask);
//                        ConcurrentModificationException
//                        //waitingTaskSet.remove(waitingTask);
//                    }
//                }
                ExecuteInfo executeInfo;
//
                executeInfo = readyTaskSet.executeOneJob();
                int execTime = executeInfo.executeTime;
                int executedTaskId = executeInfo.executedTaskId;
//            int nextTaskId = this.getEarlistTask(periodicTaskSet, this.timeAxis);
//            int execTime = periodicTaskSet.get(nextTaskId).getJobExecTime();

                if(execTime == 0){
                    this.timeAxis++;
                }else{
                    this.schedulingResult.add(new TimeBlock(executedTaskId, this.timeAxis, execTime));
                    i++;
                    this.timeAxis += execTime;
                }

//                periodicTaskSet.get(nextTaskId).nextCycle();
            }
        }

        return this.schedulingResult;
    }
    public class ReadyTaskSet{
        MyPeriodicTask lastTaskExecuted;
        LinkedList<MyPeriodicTask> readyTaskSet;
        int timeLapsed;
        boolean isPreemptive;
        ReadyTaskSet(boolean isPreemptive){
            lastTaskExecuted = null;
            timeLapsed = 0;
            readyTaskSet = new LinkedList<>();
            this.isPreemptive = isPreemptive;
        }

        int executeOneTimeUnit() throws Exception{
            if(readyTaskSet.isEmpty()){
                timeLapsed ++;
                return 0;
            }
            timeLapsed ++;
            MyPeriodicTask taskToExecute = readyTaskSet.getFirst();
            if(isPreemptive){
                //TODO remainingtime
//                if(taskToExecute.remainingTime <= 0){
//                    throw new Exception();
//                }
//                taskToExecute.remainingTime--;
//                if(taskToExecute.remainingTime == taskToExecute.getJobExecTime()
//                   || (taskToExecute != lastTaskExecuted && lastTaskExecuted != null)){
//                    System.out.println("At time" + (timeLapsed - 1) + "task started");
//                }
//                lastTaskExecuted = taskToExecute;
//                if(taskToExecute.remainingTime == 0){
//                    if(taskToExecute.getJobReleaseTime() + taskToExecute.getTaskPeriodic() >= timeLapsed){
//                        System.out.println("At time" + timeLapsed + "Task finished");
//                        readyTaskSet.pollFirst();
//                        return FINISHED;
//                    }
//                    else{
//                        System.out.println("At time" + timeLapsed + "Task finished But Missed Deadline");
//                        readyTaskSet.pollFirst();
//                        return DEADLINE_MISSED;
//                    }
//                }
            }
            else{

            }
            return -100;
        }
        ExecuteInfo executeOneJob(){
            if(readyTaskSet.isEmpty()){
                return new ExecuteInfo(-1,0);
            }
            MyPeriodicTask taskToExecute = readyTaskSet.getFirst();
            int executeTime = taskToExecute.getJobExecTime();
            timeLapsed += executeTime;
            taskToExecute.nextCycle();
            lastTaskExecuted = taskToExecute;
            //lastExecutedTask = taskToExecute;
//            if(timeLapsed >= lastTaskExecuted.getCycleStartTime())
//                waitingTaskSet.add(new MyPeriodicTask(new PeriodicTask(
//                                lastTaskExecuted.getCycleStartTime(),
//                                lastTaskExecuted.getTaskPeriodic(),
//                                lastTaskExecuted.getJobExecTime(),
//                                lastTaskExecuted.getJobDeadline() + lastTaskExecuted.getCycleStartTime()),
//                                lastTaskExecuted.id));
                waitingTaskSet.add(new MyPeriodicTask(lastTaskExecuted,
                                lastTaskExecuted.id, lastTaskExecuted.getCycleStartTime()));

            readyTaskSet.pollFirst();
            return new ExecuteInfo(lastTaskExecuted.id, executeTime);
        }

        boolean addTask(MyPeriodicTask task){
            if(readyTaskSet.isEmpty()){
                /*
                    ReadyTaskSet is empty. So add it in the first of the set.
                 */
                readyTaskSet.addFirst(task);
                return true;
            }

            if(task.getTaskPeriodic() == readyTaskSet.getFirst().getTaskPeriodic()){
                /*
                    The period of new task is the same as the period of first task,
                    so add it after the first task.
                 */
                readyTaskSet.add(1, task);
                return true;
            }

            if(task.getTaskPeriodic() < readyTaskSet.getFirst().getTaskPeriodic()){
                if(!isPreemptive){
                    readyTaskSet.addFirst(task);
                    return true;
                }
                else{
                    boolean isPreempted = true;
                    //TODO remainingTime
//                    readyTaskSet.getFirst().getJobExecTime() != readyTaskSet.getFirst().remainingTime;
                    readyTaskSet.addFirst(task);
                    if(!isPreempted) return true;
                    else{
                        System.out.println("Task is preempted");
                        return true;
                    }
                }
            }

            if(task.getTaskPeriodic() > readyTaskSet.getFirst().getTaskPeriodic()){
                if(readyTaskSet.size() == 1){
                    readyTaskSet.add(task);
                    return true;
                }
            }
            for(int i = 1; i < readyTaskSet.size(); i++){
                if(task.getTaskPeriodic() < readyTaskSet.get(i).getTaskPeriodic()){
                    readyTaskSet.add(i, task);
                    return true;
                }else{
                    if(i == readyTaskSet.size() - 1){
                        //This task has lowest priority.
                        readyTaskSet.add(task);
                        return true;
                    }
                }
            }

            return false;
        }

    }
}
