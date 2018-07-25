package com.kxw.hbase;

import com.kxw.hbase.dao.HBaseAdminDao;
import com.kxw.hbase.dao.HBaseDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kangxiongwei on 2018/7/25 13:25
 */
public class BaseDaoTest {

    HBaseAdminDao adminDao = new HBaseAdminDao();
    HBaseDao baseDao = new HBaseDao();

    String tableName = "h_user";
    String[] columnFamilies = new String[] {"base_info", "ext_info"};

    @Before
    public void setUp() {
        System.out.println("初始化数据");
    }

    @Test
    public void test() {

    }

    @After
    public void tearDown() {
        System.out.println("销毁数据");
    }
}
