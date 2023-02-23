FROM ubuntu

# 配置jdk11环境

ADD jdk-11.0.2_linux-x64_bin.tar.gz /usr/local/

# RUN tar zxvf /usr/local/jdk-8u311-linux-x64.tar.gz

ENV JAVA_HOME /usr/local/jdk-11.0.2

# ENV CLASSPATH $JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

ENV PATH $PATH:$JAVA_HOME/bin

# 添加scheduler.jar
ADD scheduler.jar /usr/local/scheduler/

# 挂载算法 .java文件
# 挂载测试数据文件夹 dir

# ADD Algorithm.java /usr/local/scheduler/

# ADD periodicTaskList.txt /usr/local/scheduler/

# 在容器中执行的命令

# CMD java -jar /usr/local/scheduler/scheduler.jar

