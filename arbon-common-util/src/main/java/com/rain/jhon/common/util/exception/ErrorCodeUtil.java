package com.rain.jhon.common.util.exception;


import java.util.Properties;

import com.rain.jhon.common.constants.ArbonBaseConstants;


/**
 * <p>功能描述</br> 错误码工具类 </p>
 * 
 * @className ErrorCodeUtil
 * @author jhonrain
 * @date 2017年4月18日 下午3:17:07
 * @version v1.0
 */
public class ErrorCodeUtil
{
    private static Properties errProps;

    private static final String ERROR_DESC_NOT_FOUND = "未找到异常描述";

    private ErrorCodeUtil()
    {}
    /**
     * 系统异常 
     */
    public static final String SYS_ERROR = ArbonBaseConstants.DEFAULT_SYS_ERROR_CODE;
    /**
     * 默认成功的编码
     */
    public static final String SUCCESS = ArbonBaseConstants.DEFAULT_SUCCESS_CODE;

    public void setErrProps(Properties errProps)
    {
        ErrorCodeUtil.errProps = errProps;
    }

    
    public static String getErrorDesc(String errorCode)
    {
        return errProps.getProperty(errorCode, ERROR_DESC_NOT_FOUND);
    }

    /**
     * <p> 功能描述：扩展错误信息的组织方式，获取错误码对应的描述</p>
     * 
     * @author jhonrain
     * @date 2017年4月18日 下午3:17:55
     * @param errorCode
     *            错误编码
     * @param replaceVal
     *            进行替换的实际值
     * @return String 错误码对应的描述
     * @version v1.0
     * @since V1.0
     */
    public static String getErrorDesc(String errorCode, Object... replaceVal)
    {
        String errorMsg = errProps.getProperty(errorCode, ERROR_DESC_NOT_FOUND);
        if (replaceVal != null && replaceVal.length > 0)
        {
            for (int i = 0; i < replaceVal.length; i++ )
            {
                errorMsg = errorMsg.replace("{" + i + "}",
                    replaceVal[i] == null ? "" : replaceVal[i].toString());
            }
        }
        return errorMsg;
    }
}
