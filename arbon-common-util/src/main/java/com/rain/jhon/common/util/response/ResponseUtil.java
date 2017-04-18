package com.rain.jhon.common.util.response;


import java.util.Map;

import com.rain.jhon.common.bean.ArbonResponse;
import com.rain.jhon.common.constants.ArbonBaseConstants;
import com.rain.jhon.common.util.exception.ErrorCodeUtil;


/**
 * <p>功能描述</br> 返回值工具 </p>
 * 
 * @className ResponseUtil
 * @author jhonrain
 * @date 2017年4月18日 下午3:11:45
 * @version v1.0
 */
public final class ResponseUtil
{
    /**
     * <p> 功能描述：统一结果处理，加入了替换符</p>
     * @author  jhonrain
     * @date  2017年4月18日 下午3:14:49
     * @param errorCode 错误异常编码
     * @param replaceVal 错误信息中的占位符替换的值
     * @return ArbonResponse
     * @version v1.0
     * @since V1.0
     */
    public static ArbonResponse error(String errorCode,Object ... replaceVal)
    {
        ArbonResponse response = new ArbonResponse();
        response.setCode(errorCode);
        response.setMsg(ErrorCodeUtil.getErrorDesc(errorCode, replaceVal));
        return response;
    }
    /**
     * <p> 功能描述：统一的错误处理</p>
     * @author  jhonrain
     * @date  2017年4月18日 下午3:14:53
     * @param errorCode 错误异常编码
     * @param retObjMap 存放的对象
     * @param replaceVal 错误信息中的占位符替换的值
     * @return ArbonResponse
     * @version v1.0
     * @since V1.0
     */
    public static ArbonResponse error(String errorCode, Map<String, Object> retObjMap, Object... replaceVal)
    {
        ArbonResponse response = new ArbonResponse();
        response.setCode(errorCode);
        response.setMsg(ErrorCodeUtil.getErrorDesc(errorCode,replaceVal)/*.replaceAll("\\d", "*")*/);
        response.setData(retObjMap);
        return response;
    }
    /**
     * <p> 功能描述：自定义异常信息 </p>
     * @author  jhonrain
     * @date  2017年4月18日 下午3:14:57
     * @param errMsg 错误信息
     * @return ArbonResponse
     * @version v1.0
     * @since V1.0
     */
    public static ArbonResponse error(String errMsg)
    {
        ArbonResponse response = new ArbonResponse();
        response.setCode(ArbonBaseConstants.DEFAULT_SYS_ERROR_CODE);
        response.setMsg(errMsg);
        return response;
    }
    /**
     * <p> 功能描述：正确返回结果处理</p>
     * @author  jhonrain
     * @date  2017年4月18日 下午3:15:02
     * @param data 返回的信息
     * @return ArbonResponse
     * @version v1.0
     * @since V1.0
     */
    public static ArbonResponse ok(Object data)
    {
        ArbonResponse response = new ArbonResponse();
        response.setCode(ArbonBaseConstants.DEFAULT_SUCCESS_CODE);
        response.setData(data);
        return response;
    }
    /**
     * <p> 功能描述：正确返回结果处理 </p>
     * @author  jhonrain
     * @date  2017年4月18日 下午3:15:07
     * @param msg 消息
     * @param data 返回的信息
     * @return ArbonResponse
     * @version v1.0
     * @since V1.0
     */
    public static ArbonResponse ok(String msg,Object data)
    {
        ArbonResponse response = new ArbonResponse();
        response.setMsg(msg);
        response.setData(data);
        return response;
    }
}
