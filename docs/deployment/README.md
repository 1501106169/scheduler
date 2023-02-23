# 部署环境

* `操作系统`：`Ubuntu 20.04.1`
* `虚拟容器`：`Docker 20.10.18`

# Docker容器环境

* `操作系统`：`Ubuntu 20.04.1`
* `运行环境`：`JDK-11.0.2`

# 部署流程

本项目下面全部称之为`scheduler`。

## 安装Docker

在Ubuntu机器上安装`Docker`容器引擎。见文档[Docker安装手册](https://github.com/1501106169/scheduler/blob/master/docs/deployment/Docker.md)或[官方文档](https://docs.docker.com/get-docker/)。

## 创建镜像

1. 从发布版本中下载最新[shceduler.jar](https://github.com/1501106169/scheduler/releases)包。

2. 下载[Dockerfile](https://github.com/1501106169/scheduler/blob/master/docs/deployment/Dockerfile)，将`Dockerfile`与`scheduler.jar`置于同一个目录下。

3. 在`Dockerfile`同级目录下(如果是桌面版，需要打开`Terminal`)输入如下代码，在`Docker`引擎中构建镜像`scheduler-container`，镜像标签为`latest`。
```
docker build -t scheduler-container: latest . 
```

4. 使用命令`docker image list`查看镜像列表，若出现在`REPOSITORY`列出现`scheduler-container`则证明创建镜像成功。

## 运行容器

运行容器的两种方法”挂载式“和”拷贝式“。

### 文件挂载

1. 将测试数据和实时调度算法源代码挂载到容器的指定目录下，并以交互式模式启动容器。命令格式如下。
```
docker run -it -v [local_directory]:[container_directory] [image]:[tag]
```
例如
```
docker run -it -v /home/huser/scheduler/scheduler-test-data/:/usr/local/scheduler-test-data/ -v /home/huser/scheduler/scheduler-algorithm/:/usr/local/scheduler-algorithm/ scheduler-cantainer:latest
```

2. 在与容器的交互界面输入如下命令，来运行`scheduler`。得到的输出结果即为实时调度算法运行结果。
```
java -jar /usr/local/scheduler/scheduler.jar
```

### 文件拷贝

1. 将测试数据和实时调度算法拷贝到容器的指定目录下。如下命令格式。
```
docker cp [local_file_path] [container_id]:[container_file_path]
```

2. 以交互式模式启动容器。
```
docker run -it scheduler-cantainer:latest
```

2. 运行`scheduler`。
```
java -jar /usr/local/scheduler/scheduler.jar
```
