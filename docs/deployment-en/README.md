# Deployment Environment

* `Operate System`：`Ubuntu 20.04.1`
* `Virtual Container`：`Docker 20.10.18`

# Docker Container Environment

* `Operate System`：`Ubuntu 20.04.1`
* `Runtime Environment`：`JDK-11.0.2`

# Deployment Process

In the following description this software is called `scheduler`.

## Install Docker

Install the `Docker` container engine on the `Ubuntu` manchiine. See the [Docker install manual](https://github.com/1501106169/scheduler/blob/master/docs/deployment/Docker.md) or [Official documents](https://docs.docker.com/get-docker/) for details.

## Create Image

1. Download the latest [shceduler.jar](https://github.com/1501106169/scheduler/releases) package from the release version.

2. Download [Dockerfile](https://github.com/1501106169/scheduler/blob/master/docs/deployment/Dockerfile), put `Dockerfile` and `scheduler.jar` in the same directory.

3. Enter the following code in the same level directory as `Dockerfile`, build the image `scheduler-container` int the `Docker` engine, with the image tag is `latest`.
```
docker build -t scheduler-container: latest . 
```

4. Use the command `docker image list` to see the list of images, if `scheduler-container` appears in the `REPOSITORY` column, then the create of the image is successful.

## Run Container
There are to ways to run container "mounted" and "copied".

### File Mount

1. Mount the test data and the source code of real-time scheduling algorithm to the specified directory of the container and start the container in interactive mode. The command format is as follows.
```
docker run -it -v [local_directory]:[container_directory] [image]:[tag]
```
such as 
```
docker run -it -v /home/huser/scheduler/scheduler-test-data/:/usr/local/scheduler-test-data/ -v /home/huser/scheduler/scheduler-algorithm/:/usr/local/scheduler-algorithm/ scheduler-cantainer:latest
```

2. Run `scheduler` by entering the following command in the interaction screen with the container. The output is the result of the real-time scheduling algorithm.
```
java -jar /usr/local/scheduler/scheduler.jar
```

### File Copy

1. Copy the test data and the source code of real-time scheduling algorithm to the specified directory of container. The command format is as follows.
```
docker cp [local_file_path] [container_id]:[container_file_path]
```

2. Start the container with interactive mode.
```
docker run -it scheduler-cantainer:latest
```

2. Run `scheduler`.
```
java -jar /usr/local/scheduler/scheduler.jar
```
