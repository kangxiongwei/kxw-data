package com.kxw.hbase;

import com.kxw.hbase.model.GetModel;
import com.kxw.hbase.model.PutModel;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kangxiongwei on 2018/7/25 13:23
 */
public class HBaseDaoTest extends BaseDaoTest {

    /**
     * 测试插入数据
     */
    @Test
    public void testPut() {
        PutModel put1 = new PutModel("1", columnFamilies[0], "name", "kangxiongwei");
        PutModel put2 = new PutModel("1", columnFamilies[0], "nick", "亢雄伟");
        PutModel put3 = new PutModel("1", columnFamilies[0], "pass", "12345");
        PutModel put4 = new PutModel("1", columnFamilies[1], "phone", "18810886644");
        PutModel put5 = new PutModel("1", columnFamilies[1], "sex", "男");

        PutModel put6 = new PutModel("2", columnFamilies[0], "name", "zhangsan");
        PutModel put7 = new PutModel("2", columnFamilies[0], "nick", "张三");
        PutModel put8 = new PutModel("2", columnFamilies[0], "pass", "12345666");
        PutModel put9 = new PutModel("2", columnFamilies[1], "phone", "18810886699");
        PutModel put10 = new PutModel("2", columnFamilies[1], "sex", "女");

        List<PutModel> puts = Arrays.asList(put1, put2, put3, put4, put5, put6, put7, put8, put9, put10);

        baseDao.put(tableName, puts);
    }

    /**
     * 测试查询某个row的数据
     */
    @Test
    public void testGet() {
        List<GetModel> gms = baseDao.get(tableName, "1");
        gms.forEach(System.out::println);
    }

    /**
     * 测试查询某张表的数据
     */
    @Test
    public void testScan() {
        List<GetModel> gms = baseDao.scan(tableName);
        gms.forEach(System.out::println);
    }

}
