package com.kxw.hbase.dao;

import com.kxw.hbase.consts.ExceptionConsts;
import com.kxw.hbase.exception.HBaseDaoException;
import com.kxw.hbase.util.HBaseUtil;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;

import java.io.IOException;

/**
 * HBase关于表操作的类
 * Created by kangxiongwei on 2018/7/25 10:37
 */
public class HBaseAdminDao {

    /**
     * 创建表，如果表存在会抛出表已经存在异常，否则创建表
     *
     * @param table          表名
     * @param columnFamilies 列簇
     * @throws HBaseDaoException
     */
    public void createTable(String table, String... columnFamilies) throws HBaseDaoException {
        try {
            Admin admin = HBaseUtil.getInstance().getAdmin();
            TableName tableName = TableName.valueOf(table);
            if (!admin.tableExists(tableName)) {
                HTableDescriptor descriptor = new HTableDescriptor(tableName);
                for (String col : columnFamilies) {
                    descriptor.addFamily(new HColumnDescriptor(col));
                }
                admin.createTable(descriptor);
            } else {
                throw new HBaseDaoException("表" + table + "已经存在，不能再创建");
            }
            HBaseUtil.getInstance().closeAdmin(admin);
        } catch (IOException e) {
            throw new HBaseDaoException(ExceptionConsts.GET_CLOSE_ADMIN, e);
        }
    }

    /**
     * 删除表
     *
     * @param table
     * @throws HBaseDaoException
     */
    public void dropTable(String table) throws HBaseDaoException {
        try {
            Admin admin = HBaseUtil.getInstance().getAdmin();
            TableName tableName = TableName.valueOf(table);
            if (admin.tableExists(tableName)) {
                admin.disableTable(tableName);
                admin.deleteTable(tableName);
            }
            HBaseUtil.getInstance().closeAdmin(admin);
        } catch (IOException e) {
            throw new HBaseDaoException(ExceptionConsts.GET_CLOSE_ADMIN, e);
        }
    }

    /**
     * 禁用表
     *
     * @param table
     * @throws HBaseDaoException
     */
    public void disableTable(String table) throws HBaseDaoException {
        try {
            Admin admin = HBaseUtil.getInstance().getAdmin();
            TableName tableName = TableName.valueOf(table);
            if (admin.tableExists(tableName)) {
                admin.disableTable(tableName);
            }
            HBaseUtil.getInstance().closeAdmin(admin);
        } catch (IOException e) {
            throw new HBaseDaoException(ExceptionConsts.GET_CLOSE_ADMIN, e);
        }
    }

}
