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
