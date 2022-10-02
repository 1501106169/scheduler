package pers.han.scheduler.scheduling;

import pers.han.scheduler.task.PeriodicTask;
import pers.han.scheduler.task.Task;
import pers.han.scheduler.task.TimeBlock;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class PeriodicRMSchedulingAlgorithm extends SchedulingAlgorithm {
    private Vector<PeriodicTask> waitingTaskSet = new Vector<>();
    @Override
    public Vector<TimeBlock> doSchedule() {
        //TODO Pass isPreemptive Value
        boolean isPreemptive = false;
        ReadyTaskSet readyTaskSet = new ReadyTaskSet(isPreemptive);

        for(Task task: this.taskSet){
            waitingTaskSet.add((PeriodicTask) task.clone());
        }
        if(isPreemptive){

        }else{
            int i = 0;
            while (this.timeAxis < this.runEndTime) {
//                if(this.timeAxis != 0 && lastExecutedTask != null && this.timeAxis % lastExecutedTask.getTaskPeriodic() == 0){
//                if(lastExecutedTask != null && this.timeAxis == lastExecutedTask.getCycleStartTime()){
//                    readyTaskSet.addTask(lastExecutedTask);
//                }
                Iterator<PeriodicTask> itr = waitingTaskSet.iterator();
                while (itr.hasNext()){
                    PeriodicTask waitingTask = itr.next();
                    /*
                        If current time == waitingTask, including their values are both 0, add it;
                        If current time != waitingTask:
                            if current time == 0 : wait directly, because 0 mod every number is 0;
                            else : if currentTime mod waitingTask.releaseTime == 0, add it
                     */
                    if(timeAxis >= waitingTask.getJobReleaseTime()){
                        readyTaskSet.addTask(waitingTask);
                        itr.remove();
                    }
                }
//                for(PeriodicTask waitingTask: waitingTaskSet){
//                    if(this.timeAxis % waitingTask.getJobReleaseTime() == 0){
//                        readyTaskSet.addTask(waitingTask);
//                        ConcurrentModificationException
//                        //waitingTaskSet.remove(waitingTask);
//                    }
//                }
                int execTime;
                execTime = readyTaskSet.executeOneJob();
//            int nextTaskId = this.getEarlistTask(periodicTaskSet, this.timeAxis);
//            int execTime = periodicTaskSet.get(nextTaskId).getJobExecTime();

                if(execTime == 0){
                    this.timeAxis++;
                }else{
                    this.schedulingResult.add(new TimeBlock(0, this.timeAxis, execTime));
                    i++;
                    this.timeAxis += execTime;
                }

//                periodicTaskSet.get(nextTaskId).nextCycle();
            }
        }

        return this.schedulingResult;
    }
    public class ReadyTaskSet{
        PeriodicTask lastTaskExecuted;
        LinkedList<PeriodicTask> readyTaskSet;
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
            PeriodicTask taskToExecute = readyTaskSet.getFirst();
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
        int executeOneJob(){
            if(readyTaskSet.isEmpty()){
                return 0;
            }
            PeriodicTask taskToExecute = readyTaskSet.getFirst();
            int executeTime = taskToExecute.getJobExecTime();
            timeLapsed += executeTime;
            taskToExecute.nextCycle();
            lastTaskExecuted = taskToExecute;
            //lastExecutedTask = taskToExecute;
//            if(timeLapsed >= lastTaskExecuted.getCycleStartTime())
                waitingTaskSet.add(new PeriodicTask(
                    lastTaskExecuted.getCycleStartTime(),
                    lastTaskExecuted.getTaskPeriodic(),
                    lastTaskExecuted.getJobExecTime(),
                    lastTaskExecuted.getJobDeadline()
                    ));
            readyTaskSet.pollFirst();
            return executeTime;
        }

        boolean addTask(PeriodicTask task){
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
