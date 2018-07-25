package com.kxw.hbase.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * 工具类，提供获取配置、连接等的单例
 * Created by kangxiongwei on 2018/7/25 10:39
 */
public final class HBaseUtil {

    private static volatile HBaseUtil instance = null;

    //私有构造方法
    private HBaseUtil() {
    }

    //共有获取实例的静态方法
    public static HBaseUtil getInstance() {
        if (instance == null) {
            synchronized (HBaseUtil.class) {
                if (instance == null) {
                    instance = new HBaseUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 获取HBase的连接
     *
     * @return
     * @throws IOException
     */
    public Connection getConnection() throws IOException {
        Configuration config = HBaseConfiguration.create();
        return ConnectionFactory.createConnection(config);
    }

    /**
     * 获取HBase的Admin
     *
     * @return
     * @throws IOException
     */
    public Admin getAdmin() throws IOException {
        Connection connection = getConnection();
        return connection.getAdmin();
    }

    /**
     * 关闭HBase的Connection连接
     *
     * @param connection
     * @throws IOException
     */
    public void closeConnection(Connection connection) throws IOException {
        if (connection != null) connection.close();
    }

    /**
     * 关闭HBase的Admin连接
     *
     * @param admin
     */
    public void closeAdmin(Admin admin) throws IOException {
        if (admin != null) admin.close();
    }

}
