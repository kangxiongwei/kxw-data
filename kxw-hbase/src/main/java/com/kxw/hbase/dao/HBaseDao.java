package com.kxw.hbase.dao;

import com.kxw.hbase.consts.ExceptionConsts;
import com.kxw.hbase.exception.HBaseDaoException;
import com.kxw.hbase.model.GetModel;
import com.kxw.hbase.model.PutModel;
import com.kxw.hbase.util.HBaseUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

/**
 * Created by kangxiongwei on 2018/7/25 11:37
 */
public class HBaseDao {

    /**
     * 往表中插入数据
     *
     * @param table 表名
     * @param puts  需要增加的数据
     * @throws HBaseDaoException
     */
    public void put(String table, List<PutModel> puts) throws HBaseDaoException {
        if (puts == null || puts.isEmpty()) return;
        try {
            Connection connection = HBaseUtil.getInstance().getConnection();
            Table t = connection.getTable(TableName.valueOf(table));
            List<Put> putList = new ArrayList<>(puts.size());
            for (PutModel put : puts) {
                Put p = new Put(Bytes.toBytes(put.getRowKey()));
                p.addColumn(Bytes.toBytes(put.getColumnFamily()), Bytes.toBytes(put.getColumn()), Bytes.toBytes(put.getData()));
                putList.add(p);
            }
            t.put(putList);
            HBaseUtil.getInstance().closeConnection(connection);
        } catch (IOException e) {
            throw new HBaseDaoException(ExceptionConsts.GET_CLOSE_CONNECTION, e);
        }
    }

    /**
     * 从某张表中查询某个key对应的数据
     *
     * @param table
     * @param rowKey
     * @return
     */
    public List<GetModel> get(String table, String rowKey) throws HBaseDaoException {
        List<GetModel> gms;
        try {
            Connection connection = HBaseUtil.getInstance().getConnection();
            Table t = connection.getTable(TableName.valueOf(table));
            gms = this.parse(t.get(new Get(Bytes.toBytes(rowKey))));
            HBaseUtil.getInstance().closeConnection(connection);
        } catch (IOException e) {
            throw new HBaseDaoException(ExceptionConsts.GET_CLOSE_CONNECTION, e);
        }
        return gms;
    }

    /**
     * 查询某张表中的所有数据
     *
     * @param table
     * @return
     * @throws HBaseDaoException
     */
    public List<GetModel> scan(String table) throws HBaseDaoException {
        List<GetModel> gms = new ArrayList<>();
        try {
            Connection connection = HBaseUtil.getInstance().getConnection();
            Table t = connection.getTable(TableName.valueOf(table));
            ResultScanner scanner = t.getScanner(new Scan());
            for (Result result : scanner) {
                List<GetModel> gm = this.parse(result);
                gms.addAll(gm);
            }
            HBaseUtil.getInstance().closeConnection(connection);
        } catch (IOException e) {
            throw new HBaseDaoException(ExceptionConsts.GET_CLOSE_CONNECTION, e);
        }
        return gms;
    }


    /**
     * 解析返回的结果
     *
     * @param result
     */
    private List<GetModel> parse(Result result) {
        List<GetModel> gms = new ArrayList<>();
        NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> resultMap = result.getMap();
        for (Map.Entry<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> entry : resultMap.entrySet()) {
            //第一层，列族
            String columnFamily = Bytes.toString(entry.getKey());
            for (Map.Entry<byte[], NavigableMap<Long, byte[]>> col : entry.getValue().entrySet()) {
                //第二层，列
                String column = Bytes.toString(col.getKey());
                for (Map.Entry<Long, byte[]> kv : col.getValue().entrySet()) {
                    //第三层，时间戳和值
                    Long timestamp = kv.getKey();
                    String data = Bytes.toString(kv.getValue());
                    GetModel gm = new GetModel(Bytes.toString(result.getRow()), columnFamily, column, data, timestamp);
                    gms.add(gm);
                }
            }
        }
        return gms;
    }

}
