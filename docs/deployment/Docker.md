# Docker安装

以下操作中会使用到更高的权限。在用到高权限时，请自行切换，本文不做提权的展示和介绍。

## 安装环境

 * `操作系统`：`Ubuntu 20.04.1`

## 官方脚本自动安装
使用官方脚本自动安装，命令如下。
```
curl -fsSL https://get.docker.com | bash -s docker
```

## 手动安装

### 卸载旧版本

卸载旧版本的`Docker`，旧版本的`Docker`称为`docker`、`docker-engine`、`docker.io`。如有，可以使用`apt-get remove`命令进行卸载。
例如
```
apt-get remove docker docker-engine docker.io containerd runc
```

### 安装
当前版本的`Docker`称为`Docker Engine-Community`，对应的软件包为`docker-ce`。

1. 使用如下命令，更新`Ubuntu`包管理工具的包索引。
```
apt-get update
```

2. 安装依赖包
依赖包如下
 * apt-transport-https
 * ca-certificates
 * curl
 * gnupg-agent
 * software-properties-common

使用如下命令安装上述依赖包。
```
sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common
```

3. 安装官方的GPG密钥
这里使用阿里镜像安装。
```
curl -fsSL http://mirrors.aliyun.com/docker-ce/linux/ubuntu/gpg | sudo apt-key add -
```

4. 写入软件源信息
使用以下命令设置`Docker`稳定版本仓库。
```
add-apt-repository "deb [arch=amd64] http://mirrors.aliyun.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable"
```

5. 安装Docker
更新软件源索引。
```
apt-get up-date
```
安装`Docker Engine-Community`和`containerd`。
```
apt-get install docker-ce docker-ce-cli containerd.io
```

6. 测试
使用下面命令测试`Docker`是否安装成功。
```
docker run hello-world
```
如出现`Hello from Docker!`信息，则证明安装成功。

