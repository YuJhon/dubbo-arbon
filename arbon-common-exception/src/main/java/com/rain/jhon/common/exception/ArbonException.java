package com.rain.jhon.common.exception;


import java.util.Map;


/**
 * <p>功能描述</br> 框架的基础异常 </p>
 * 
 * @className ArbonException
 * @author jhonrain
 * @date 2017年4月18日 下午2:34:02
 * @version v1.0
 */
public class ArbonException extends RuntimeException
{

    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 2677051913714393112L;

    /**
     * 返回码
     */
    private String errorCode;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * msg中需要替换的值
     */
    private Object[] replaceVal;

    /**
     * 额外需要抛出的信息
     */
    private Map<String, Object> extMap;

    public ArbonException()
    {}

    public ArbonException(String errorCode)
    {
        super();
        this.errorCode = errorCode;
    }
    

    public ArbonException(String errorCode, String msg)
    {
        super();
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public ArbonException(String errorCode, Object... replaceVal)
    {
        super();
        this.errorCode = errorCode;
        this.replaceVal = replaceVal;
    }

    public ArbonException(String errorCode, Map<String, Object> extMap, Object... replaceVal)
    {
        super();
        this.errorCode = errorCode;
        this.extMap = extMap;
        this.replaceVal = replaceVal;
    }

    public ArbonException(String errorCode, Map<String, Object> extMap)
    {
        super();
        this.errorCode = errorCode;
        this.extMap = extMap;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Object[] getReplaceVal()
    {
        return replaceVal;
    }

    public Map<String, Object> getExtMap()
    {
        return extMap;
    }

}
