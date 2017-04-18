package com.rain.jhon.common.exception;

/**
 * <p>功能描述</br> 业务异常基类，所有业务异常都必须继承于此异常</p>
 * 
 * @className ArbonDAOException
 * @author jhonrain
 * @date 2017年4月18日 下午4:36:17
 * @version v1.0
 */
public class ArbonDAOException extends RuntimeException
{

    private static final long serialVersionUID = -5875371379845226068L;

    /**
     * 数据库操作,insert返回0
     */
    public static final ArbonDAOException DB_INSERT_RESULT_0 = new ArbonDAOException(90040001,
        "数据库操作,insert返回0");

    /**
     * 数据库操作,update返回0
     */
    public static final ArbonDAOException DB_UPDATE_RESULT_0 = new ArbonDAOException(90040002,
        "数据库操作,update返回0");

    /**
     * 数据库操作,selectOne返回null
     */
    public static final ArbonDAOException DB_SELECTONE_IS_NULL = new ArbonDAOException(90040003,
        "数据库操作,selectOne返回null");

    /**
     * 数据库操作,list返回null
     */
    public static final ArbonDAOException DB_LIST_IS_NULL = new ArbonDAOException(90040004,
        "数据库操作,list返回null");

    /**
     * Token 验证不通过
     */
    public static final ArbonDAOException TOKEN_IS_ILLICIT = new ArbonDAOException(90040005,
        "Token 验证非法");

    /**
     * 会话超时　获取session时，如果是空，throws 下面这个异常 拦截器会拦截爆会话超时页面
     */
    public static final ArbonDAOException SESSION_IS_OUT_TIME = new ArbonDAOException(90040006,
        "会话超时");

    /**
     * 异常信息
     */
    protected String msg;

    /**
     * 具体异常码
     */
    protected int code;

    public ArbonDAOException(int code, String msgFormat, Object... args)
    {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public ArbonDAOException()
    {
        super();
    }

    public String getMsg()
    {
        return msg;
    }

    public int getCode()
    {
        return code;
    }

    /**
     * 实例化异常
     * 
     * @param msgFormat
     * @param args
     * @return
     */
    public ArbonDAOException newInstance(String msgFormat, Object... args)
    {
        return new ArbonDAOException(this.code, msgFormat, args);
    }

    public ArbonDAOException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ArbonDAOException(Throwable cause)
    {
        super(cause);
    }

    public ArbonDAOException(String message)
    {
        super(message);
    }
}
