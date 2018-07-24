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
