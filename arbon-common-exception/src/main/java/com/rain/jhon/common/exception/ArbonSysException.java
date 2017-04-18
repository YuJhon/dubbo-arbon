package com.rain.jhon.common.exception;
/**
 * <p>功能描述</br> 前端不可见异常 -- 默认为系统异常 </p>
 * @className  ArbonSysException
 * @author  jhonrain
 * @date  2017年4月18日 下午2:46:10
 * @version  v1.0
 */
public class ArbonSysException extends ArbonException
{

    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 4070928923277793874L;
    
    /**
     * <p> replaceVal代表的是可替换的值 例如：异常信息可以定义为：从一个{0}状态调整到{1}状态出现异常 ,replaceVal中按顺序对应的值分别会替换{0}，{1}中的信息</p>
     * @author  jhonrain
     * @param errorCode 异常码
     * @param replaceVal 异常信息中需要替换的值
     */
    public ArbonSysException(String errorCode,Object ... replaceVal)
    {
        super(errorCode,replaceVal);
    }
}
