package com.rain.jhon.common.bean;


import java.util.Map;


/**
 * <p>功能描述</br> 异常处理类 </p>
 * 
 * @className ArbonResponse
 * @author jhonrain
 * @date 2017年4月18日 下午2:16:39
 * @version v1.0
 */
public class ArbonResponse
{
    /**
     * 编码
     */
    private String code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 返回携带的数据
     */
    private Object data;

    /**
     * 扩展信息
     */
    private Map<String, Object> extInfoMap;

    public ArbonResponse()
    {}

    public ArbonResponse(String code, String msg)
    {
        super();
        this.code = code;
        this.msg = msg;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public Map<String, Object> getExtInfoMap()
    {
        return extInfoMap;
    }

    public void setExtInfoMap(Map<String, Object> extInfoMap)
    {
        this.extInfoMap = extInfoMap;
    }

}
