package com.kxw.hbase;

import com.kxw.hbase.dao.HBaseAdminDao;
import com.kxw.hbase.dao.HBaseDao;

/**
 * Created by kangxiongwei on 2018/7/25 13:25
 */
public class BaseDaoTest {

    HBaseAdminDao adminDao = new HBaseAdminDao();
    HBaseDao baseDao = new HBaseDao();

    String tableName = "h_user";
    String[] columnFamilies = new String[] {"base_info", "ext_info"};

}
