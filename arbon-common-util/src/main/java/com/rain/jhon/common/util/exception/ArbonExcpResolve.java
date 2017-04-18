package com.rain.jhon.common.util.exception;

import java.util.Map;

import org.apache.log4j.Logger;

import com.rain.jhon.common.bean.ArbonResponse;
import com.rain.jhon.common.exception.ArbonSysException;
import com.rain.jhon.common.exception.ArbonViewException;
import com.rain.jhon.common.util.response.ResponseUtil;

/**
 * <p>功能描述</br> 异常处理类  </p>
 * 
 * @className ExcpHelper
 * @author jhonrain
 * @date 2017年4月18日 下午3:01:59
 * @version v1.0
 */
public class ArbonExcpResolve
{
    private static final Logger LOG = Logger.getLogger(ArbonExcpResolve.class);
    
    /**
     * <p> 功能描述：</p>
     * 
     * @author jiangyu
     * @date 2016年11月28日 下午5:10:47
     * @param ex
     *            异常
     * @param printLog
     *            是否打印日志
     * @return
     * @version v1.0
     * @since V1.0
     */
    /**
     * <p> 功能描述：异常处理</p>
     * @author  jhonrain
     * @date  2017年4月18日 下午3:09:41
     * @param ex
     * @param printLog
     * @return
     * @version v1.0
     * @since V1.0
     */
    public ArbonResponse resolve(Exception ex)
    {
        ArbonResponse responseValue = null;
        if (null != ex && ex instanceof ArbonViewException)
        {
            ArbonViewException viewEx = (ArbonViewException)ex;
            String errCode = viewEx.getErrorCode();
            Object[] replaceVal = viewEx.getReplaceVal();
            Map<String, Object> extMap = viewEx.getExtMap();
            LOG.error("errorCode:" + errCode + " errorMsg:" + ErrorCodeUtil.getErrorDesc(errCode, replaceVal));
            responseValue = ResponseUtil.error(errCode, extMap, replaceVal);
        }
        else if (null != ex && ex instanceof ArbonSysException)
        {
            ArbonSysException sysex = (ArbonSysException)ex;
            String errCode = sysex.getErrorCode();
            Object[] replaceVal = sysex.getReplaceVal();
            Map<String, Object> extMap = sysex.getExtMap();
            LOG.error("errorCode:" + errCode + " errorMsg:" + ErrorCodeUtil.getErrorDesc(errCode, replaceVal));
            responseValue = ResponseUtil.error(errCode, extMap, replaceVal);
        }
        else
        {
            responseValue = ResponseUtil.error(ErrorCodeUtil.SYS_ERROR);
        }
        LOG.error(ex.getStackTrace(), ex);
        return responseValue;
    }
}
