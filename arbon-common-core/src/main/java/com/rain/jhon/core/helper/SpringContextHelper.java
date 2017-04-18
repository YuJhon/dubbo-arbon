package com.rain.jhon.core.helper;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * <p>功能描述</br> spring上下文获取工具类 </p>
 * 
 * @className SpringContextHelper
 * @author jhonrain
 * @date 2017年4月18日 下午3:39:32
 * @version v1.0
 */
public class SpringContextHelper implements ApplicationContextAware
{

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException
    {
        setContext(applicationContext);
    }

    private static void setContext(ApplicationContext applicationContext)
    {
        SpringContextHelper.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    /**
     * <p> 功能描述：获取bean对象</p>
     * 
     * @author jhonrain
     * @date 2017年4月18日 下午3:39:32
     * @param componentClass
     *            要加载的bean类
     * @return T 自定义的类型
     * @since v1.0
     */
    public static <T> T getComponent(Class<T> componentClass)
    {
        return SpringContextHelper.getApplicationContext().getBean(componentClass);
    }

    /**
     * <p> 功能描述：获取bean</p>
     * 
     * @author jhonrain
     * @date 2017年4月18日 下午3:39:32
     * @param componentClass
     *            对应的bean的组件类
     * @param beanName
     *            对应的bean的名称
     * @return 返回componentClass对应的类型组件实体
     * @version v1.0
     * @since V1.0
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> componentClass, String beanName)
    {
        Object obj = SpringContextHelper.getApplicationContext().getBean(beanName);
        return (T)obj;
    }
}
