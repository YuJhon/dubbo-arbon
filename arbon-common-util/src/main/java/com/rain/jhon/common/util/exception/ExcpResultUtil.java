package com.rain.jhon.common.util.exception;

import java.util.Map;

import com.rain.jhon.common.exception.ArbonSysException;
import com.rain.jhon.common.exception.ArbonViewException;

/**
 * <p>功能描述</br> 校验结果的处理
 *  <ul>eg:任务处于{0}状态，不允许参与{1}任务...{n}</ul> 
 * </p>
 * @className  ExcpResultUtil
 * @author  jhonrain
 * @date  2017年4月18日 下午3:35:56
 * @version  v1.0
 */
public class ExcpResultUtil
{
    /**
     * <p> 功能描述：校验失败处理【错误信息前端可见】
     *  <ul>eg:任务处于{0}状态，不允许参与{1}任务...{n} </ul>
     * </p>
     * @author jhonrain
     * @date 2017年4月18日 下午3:35:56
     * @param errorCode 错误编码
     * @param params 附加信息    分别对应的是替换符中的值
     * @since v1.0
     */
    public static void failView(String errorCode,Object... params){
        /** eg:任务处于{0}状态，不允许参与此任务 **/
        throw new ArbonViewException(errorCode,params);
    }
    
    /**
     * <p> 功能描述：提供返回信息</p>
     * @author  jhonrain
     * @date  2017年4月18日 下午3:35:56
     * @param errorCode 错误编码
     * @param extMap 扩展信息的map
     * @version v1.0
     * @since V1.0
     */
    public static void failView(String errorCode,Map<String, Object> extMap){
        /** eg:任务处于{0}状态，不允许参与此任务 **/
        throw new ArbonViewException(errorCode,extMap);
    }
    
    /**
     * <p> 功能描述：校验失败处理【错误信息前端不可见】
     *  <ul> eg:任务处于{0}状态，不允许参与{1}任务...{n} </ul>
     * </p>
     * @author jhonrain
     * @date 2017年4月18日 下午3:35:56
     * @param errorCode 分别对应的是替换符中的值
     * @param params 附加信息    分别对应的是替换符中的值
     * @since v1.0
     */
    public static void failSys(String errorCode,Object... params){
        /** eg:任务处于{0}状态，不允许参与{1}任务 **/
        throw new ArbonSysException(errorCode,params);
    }

}
