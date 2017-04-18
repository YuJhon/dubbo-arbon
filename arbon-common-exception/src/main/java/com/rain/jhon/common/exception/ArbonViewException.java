package com.rain.jhon.common.exception;


import java.util.Map;


/**
 * <p>功能描述</br> 前端可见异常，包含具体的异常信息 </p>
 * 
 * @className ArbonViewException
 * @author jhonrain
 * @date 2017年4月18日 下午2:47:34
 * @version v1.0
 */
public class ArbonViewException extends ArbonException
{

    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = -2502340161848230287L;

    /**
     * <p> replaceVal代表的是可替换的值 例如：异常信息可以定义为：从一个{0}状态调整到{1}状态出现异常 ,replaceVal中按顺序对应的值分别会替换{0}，{1}中的信息</p>
     * @author  jhonrain
     * @param errorCode 异常码
     * @param replaceVal 异常信息中需要替换的值
     */
    public ArbonViewException(String errorCode, Object... replaceVal)
    {
        super(errorCode, replaceVal);
    }

    /**
     * <p> extInfoMap是为了错误抛出之后，携带某些有用的信息 </p>
     * @param errorCode 异常码
     * @param extInfoMap 异常抛出之后需要携带的额外信息 
     */
    public ArbonViewException(String errorCode, Map<String, Object> extInfoMap)
    {
        super(errorCode, extInfoMap);
    }
}
