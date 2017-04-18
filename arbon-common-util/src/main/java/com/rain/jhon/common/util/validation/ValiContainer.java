package com.rain.jhon.common.util.validation;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.rain.jhon.common.enums.ExcpTypeEnum;
import com.rain.jhon.common.util.collection.CollectionUtil;
import com.rain.jhon.common.util.exception.ExcpResultUtil;
import com.rain.jhon.common.util.validation.ExcpHelper.Condition;


/**
 * <p>功能描述</br> 校验容器类</p>
 * 
 * @className ValiContainer
 * @author jiangyu
 * @date 2016年3月17日 下午7:00:00
 * @version v1.0
 * @since v1.0
 */
public class ValiContainer
{
    /** 无参构造器 **/
    private ValiContainer()
    {}

    private static class ValiContainerHolder
    {
        private static final ValiContainer INSTANCE = new ValiContainer();
    }

    /**
     * <p> 功能描述：获取校验的容器实例</p>
     * 
     * @author jiangyu
     * @date 2016年3月17日 下午11:22:23
     * @return ValiContainer 获取校验的容器实例
     * @since V1.0
     */
    public static ValiContainer getInstance()
    {
        return ValiContainerHolder.INSTANCE.clear();
    }

    /**
     * 存储校验对象
     */
    private static Set<ExcpHelper> exceptions = Collections.synchronizedSet(new HashSet<ExcpHelper>());

    /**
     * <p> 功能描述：注册校验的对象</p>
     * 
     * @author jiangyu
     * @date 2016年3月17日 下午7:00:13
     * @param excp
     *            异常校验对象
     * @return ValiContainer 校验的容器类
     * @since v1.0
     */
    public synchronized ValiContainer registerExcep(ExcpHelper excp)
    {
        exceptions.add(excp);
        return this;
    }

    /**
     * <p> 功能描述：注册校验对象</p>
     * 
     * @author jiangyu
     * @date 2016年3月17日 下午7:00:32
     * @param obj
     *            校验的内容
     * @param errorCode
     *            校验不通过的异常编码
     * @param condition
     *            校验的条件（校验的标准）
     * @return ValiContainer 校验的容器类
     * @since v1.0
     */
    public synchronized ValiContainer registerExcep(Object obj, String errorCode,
                                                    Condition condition)
    {
        ExcpHelper excp = new ExcpHelper(obj, errorCode, condition);
        exceptions.add(excp);
        return this;
    }

    public synchronized ValiContainer registerExcep(Object obj, String errorCode,
                                                    Condition condition, Object... objs)
    {
        ExcpHelper excp = new ExcpHelper(obj, errorCode, condition, objs);
        exceptions.add(excp);
        return this;
    }

    public synchronized ValiContainer clear()
    {
        exceptions.clear();
        return this;
    }

    /**
     * <p> 功能描述：校验异常对象</p>
     * 
     * @author jiangyu
     * @date 2016年3月17日 下午7:00:59
     * @param excpType
     * @since v1.0
     */
    public synchronized void validate(ExcpTypeEnum... excpType)
    {

        if (exceptions != null && exceptions.size() > 0)
        {
            for (ExcpHelper excp : exceptions)
            {
                boolean flag = false;
                if (Condition.EMPTY.getValue().equals(excp.getCondition().getValue()))
                {
                    if (CollectionUtil.isEmpty(excp.getObj()))
                    {
                        flag = true;
                    }
                }
                else if (Condition.LE_0.getValue().equals(excp.getCondition().getValue()))
                {
                    if (excp.getObj() instanceof Long)
                    {
                        if (((Long)excp.getObj()).intValue() <= 0)
                        {
                            flag = true;
                        }
                    }

                    if (excp.getObj() instanceof Integer)
                    {
                        if ((int)excp.getObj() <= 0)
                        {
                            flag = true;
                        }
                    }

                }
                else if (Condition.NOT_MATCH.getValue().equals(excp.getCondition().getValue()))
                {
                    if ((boolean)excp.getObj())
                    {
                        flag = true;
                    }
                }

                if (flag)
                {
                    validateExcpHandler(excp, excpType);
                }
            }
        }
    }

    /**
     * <p> 功能描述：校验异常对象</p>
     * 
     * @author jiangyu
     * @date 2016年3月17日 下午7:00:59
     * @param excpType
     * @since v1.0
     */
    public synchronized void validate(boolean isview, ExcpTypeEnum... excpType)
    {

        if (exceptions != null && exceptions.size() > 0)
        {
            for (ExcpHelper excp : exceptions)
            {
                boolean flag = false;
                if (Condition.EMPTY.getValue().equals(excp.getCondition().getValue()))
                {
                    if (CollectionUtil.isEmpty(excp.getObj()))
                    {
                        flag = true;
                    }
                }
                else if (Condition.LE_0.getValue().equals(excp.getCondition().getValue()))
                {
                    if (excp.getObj() == null
                        || (Long.valueOf(excp.getObj().toString())).intValue() <= 0)
                    {
                        flag = true;
                    }
                }
                else if (Condition.NOT_MATCH.getValue().equals(excp.getCondition().getValue()))
                {
                    if ((boolean)excp.getObj())
                    {
                        flag = true;
                    }
                }

                if (flag)
                {
                    if (isview)
                    {
                        validateExcpHandler(isview, excp, excpType);
                    }
                    else
                    {
                        validateExcpHandler(excp, excpType);
                    }
                }
            }
        }
    }

    /**
     * <p> 功能描述：校验的时候异常信息的出来</p>
     * 
     * @author jiangyu
     * @date 2016年3月17日 下午7:01:14
     * @param excp
     * @param excpType
     * @since v1.0
     */
    private void validateExcpHandler(ExcpHelper excp, ExcpTypeEnum... excpType)
    {
        if (excpType != null && excpType.length > 0)
        {
            ExcpTypeEnum type = excpType[0];

            String codeCode = type.getCode();
            /** 错误编码 **/
            if (ExcpTypeEnum.CONTROLLER.getCode().equals(codeCode))
            {
                /** 控制器层校验抛出异常 **/
                ExcpResultUtil.failSys(excp.getErrorCode(), excp.getParamInfo());

            }
            else if (ExcpTypeEnum.SERVICE.getCode().equals(codeCode))
            {
                /** 控制器层校验抛出异常 **/
                ExcpResultUtil.failSys(excp.getErrorCode(), excp.getParamInfo());

            }
            else if (ExcpTypeEnum.COMPONENT.getCode().equals(codeCode))
            {
                /** 控制器层校验抛出异常 **/
                ExcpResultUtil.failSys(excp.getErrorCode(), excp.getParamInfo());
            }
            else
            {
                ExcpResultUtil.failSys(excp.getErrorCode(), excp.getParamInfo());
            }
        }
    }

    /**
     * <p> 功能描述：校验的时候异常信息的出来</p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 下午8:41:34
     * @param isview
     *            是否可见
     * @param excp
     * @param excpType
     * @version v1.0
     * @since V1.0
     */
    private void validateExcpHandler(boolean isview, ExcpHelper excp, ExcpTypeEnum... excpType)
    {
        if (isview)
        {
            if (excpType != null && excpType.length > 0)
            {
                ExcpTypeEnum type = excpType[0];

                String codeCode = type.getCode();
                /** 错误编码 **/
                if (ExcpTypeEnum.CONTROLLER.getCode().equals(codeCode))
                {
                    /** 控制器层校验抛出异常 **/
                    ExcpResultUtil.failView(excp.getErrorCode(), excp.getParamInfo());

                }
                else if (ExcpTypeEnum.SERVICE.getCode().equals(codeCode))
                {
                    /** 控制器层校验抛出异常 **/
                    ExcpResultUtil.failView(excp.getErrorCode(), excp.getParamInfo());

                }
                else if (ExcpTypeEnum.COMPONENT.getCode().equals(codeCode))
                {
                    /** 控制器层校验抛出异常 **/
                    ExcpResultUtil.failView(excp.getErrorCode(), excp.getParamInfo());

                }
                else
                {
                    ExcpResultUtil.failSys(excp.getErrorCode(), excp.getParamInfo());
                }
            }
        }
        else
        {
            validateExcpHandler(excp, excpType);
        }
    }


    /**
     * <p> 功能描述：为空的判断，为空的话抛出可视化的异常信息</p>
     * 
     * @author jiangyu
     * @date 2016年3月17日 下午7:02:33
     * @param obj
     *            校验的对象
     * @param errorCode
     *            对应错误异常的异常编码
     * @since v1.0
     */
    public void validateEmpty(Object obj, String errorCode)
    {
        /** 校验是否存在记录 **/
        if (CollectionUtil.isEmpty(obj))
        {
            /** 任务实例不存在 **/
            ExcpResultUtil.failView(errorCode);
        }
    }
}
