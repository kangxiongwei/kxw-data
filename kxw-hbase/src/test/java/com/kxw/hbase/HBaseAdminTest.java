package com.kxw.hbase;

import com.kxw.hbase.dao.HBaseAdminDao;
import org.junit.Test;

/**
 * Created by kangxiongwei on 2018/7/25 13:22
 */
public class HBaseAdminTest extends BaseDaoTest {

    /**
     * 测试创建表
     */
    @Test
    public void testCreateTable() {
        adminDao.createTable(tableName, columnFamilies);
    }


}
