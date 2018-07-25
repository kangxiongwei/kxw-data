package com.kxw.hbase.model;

/**
 * Created by kangxiongwei on 2018/7/25 12:59
 */
public class GetModel extends PutModel {

    private Long timestamp;

    public GetModel() {
    }

    public GetModel(String rowKey, String columnFamily, String column, String data, Long timestamp) {
        this.setRowKey(rowKey);
        this.setColumnFamily(columnFamily);
        this.setColumn(column);
        this.setData(data);
        this.setTimestamp(timestamp);
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "GetModel{" +
                "timestamp=" + timestamp +
                "} " + super.toString();
    }
}
