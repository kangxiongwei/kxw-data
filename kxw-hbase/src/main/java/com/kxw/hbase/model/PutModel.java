package com.kxw.hbase.model;

/**
 * 添加数据的模型
 * Created by kangxiongwei on 2018/7/25 11:40
 */
public class PutModel {

    private String rowKey;
    private String columnFamily;
    private String column;
    private String data;

    public PutModel() {}

    public PutModel(String rowKey, String columnFamily, String column, String data) {
        this.rowKey = rowKey;
        this.columnFamily = columnFamily;
        this.column = column;
        this.data = data;
    }

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public String getColumnFamily() {
        return columnFamily;
    }

    public void setColumnFamily(String columnFamily) {
        this.columnFamily = columnFamily;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PutModel{" +
                "rowKey='" + rowKey + '\'' +
                ", columnFamily='" + columnFamily + '\'' +
                ", column='" + column + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
