package com.kxw.spark.hive;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.List;

/**
 * Created by kangxiongwei on 2018/7/25 17:19
 */
public class SparkHiveClient {

    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("spark_h_user")
                .master("spark://127.0.0.1:7077")
                .enableHiveSupport()
                .getOrCreate();
        Dataset<Row> result = spark.sql("select * from h_user");
        List<Row> rowList = result.collectAsList();
        rowList.forEach(System.out::println);
    }


}
