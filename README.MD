### 数据相关的项目

## hadoop启动
```markdown
1. 格式化HDFS的NameNode：hdfs namenode -format
2. 启动HDFS：start-dfs.sh
3. 校验是否启动：jps -l，查看是否有NameNode、SecondNameNode、DataNode进程
4. 浏览器登录: http://localhost:50070

5. 启动yarn： start-yarn.sh
6. 校验是否启动：jps -l，查看是否有ResourceManager和NodeManager
7. 浏览器登录：http://localhost:8088 
```
## zookeeper启动
```markdown
1. zkServer.sh start
2. 校验：zkServer.sh status
3. 连接zk: zkCli.sh
4. help命令查看帮助
5. ls / 查看有哪些目录
6. create -e -s / kxw 创建目录
```


## hbase启动
```markdown
1. start-hbase.sh
2. hadoop fs -ls /hbase 查看HDFS中创建的目录
3. jps -l查看是否存在HMaster、HRegionServer进程
4. 浏览器访问：http://localhost:16010/
```

## hive启动
```markdown
1. 配置hive-site.xml
   javax.jdo.option.ConnectionURL,
   javax.jdo.option.ConnectionDriverName,
   javax.jdo.option.ConnectionPassword,
   javax.jdo.option.ConnectionUserName, 
   替换${system:java.io.tmpdir}为/tmp, 
   ${system:user.name}为${user.name}
2. create database hive; 
   grant all privileges on hive.* to 'hadoop'@'localhost' identified by 'hadoop';
3. 拷贝mysql-connector-java-5.1.*.jar到lib目录
   初始化： schematool -dbType mysql -initSchema 
4. $HADOOP_HOME/bin/hadoop fs -mkdir       /tmp
   $HADOOP_HOME/bin/hadoop fs -mkdir -p    /user/hive/warehouse
   $HADOOP_HOME/bin/hadoop fs -chmod g+w   /tmp
   $HADOOP_HOME/bin/hadoop fs -chmod g+w   /user/hive/warehouse
5. 启动：hive
6. 参考https://cwiki.apache.org/confluence/display/Hive/GettingStarted#GettingStarted-InstallationandConfiguration进行DML，DDL操作
```

## redis安装配置
```markdown
1. 下载文件，解压：tar -zxvf redis-4.0.1.tar.gz
2. 编译，cd redis-4.0.1 && make install
3. 检查，/usr/local/bin下是否有redis-server和redis-cli文件
4. 启动服务端，redis-server
5. 启动客户端，redis-cli
```