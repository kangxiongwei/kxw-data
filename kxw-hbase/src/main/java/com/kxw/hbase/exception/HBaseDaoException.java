package com.kxw.hbase.exception;

/**
 * 自定义Dao层异常，改层异常应该向上抛出
 * Created by kangxiongwei on 2018/7/25 11:03
 */
public class HBaseDaoException extends RuntimeException {

    public HBaseDaoException() {
        super();
    }

    public HBaseDaoException(String message) {
        super(message);
    }

    public HBaseDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public HBaseDaoException(Throwable cause) {
        super(cause);
    }
}
