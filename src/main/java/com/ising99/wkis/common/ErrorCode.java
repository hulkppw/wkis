package com.ising99.wkis.common;

/**
 * Created by jerry on 2014/7/25.
 */
public class ErrorCode {
    /**
     * 服务操作成功
     */
    public final static int SERVER_SUCESS = 0;
    /**
     * 服务器异常
     */
    public final static int SERVER_ERROR = 500;
    /**
     * 参数错误
     */
    public final static int PARAMETER_ERROR = 101;
    /**
     * 没有数据
     */
    public final static int NO_RECORD = 404;
    /**
     * 没有KUS服务器信息数据
     */
    public final static int NO_KUS_SERVERINFO = 405;
    /**
     * 请求数据太长
     */
    public final static int REQUEST_DATA_TOO_LONG = 102;
    /**
     * 用户账户信息错误
     */
    public final static int USER_ACCOUNT_ERROR = 301;
}
