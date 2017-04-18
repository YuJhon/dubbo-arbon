package com.rain.jhon.common.util.collection;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * <p>功能描述:</br> 集合(List,Map,Set)为空判断和基本操作的工具类</p>
 * 
 * @className CollectionUtil
 * @author jiangyu
 * @date 2016年3月23日 下午2:18:40
 * @version v1.0
 * @since v1.0
 */
@SuppressWarnings("unchecked")
public class CollectionUtil
{

    /**
     * <p> 功能描述：数组中是否存在这个元素。</p>
     * 
     * @author jiangyu
     * @param objArr
     *            数组对象
     * @param compare
     *            要判断的元素
     * @return Boolean 存在返回true，否则返回false
     * @since V1.0
     */
    public static <T> boolean arrayContain(T[] objArr, T compare)
    {
        if (isEmpty(objArr))
        {
            return false;
        }
        for (T obj : objArr)
        {
            if (obj.equals(compare))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * <p> 功能描述：向list中添加数组</p>
     * 
     * @author jiangyu
     * @param list
     *            目标List对象
     * @param array
     *            数组对象
     * @since V1.0
     */
    public static <T> void addArrayToList(List<T> list, T[] array)
    {
        if (isEmpty(list))
        {
            return;
        }
        for (T t : array)
        {
            list.add(t);
        }
    }

    /**
     * <p> 功能描述：将数组进行反转，倒置</p>
     * 
     * @author jiangyu
     * @date 2016年3月23日 下午2:21:20
     * @param objs
     *            源数组
     * @return T[] 反转后的数组
     * @since V1.0
     */
    public static <T> T[] reverseArray(T[] objs)
    {
        if (isEmpty(objs))
        {
            return null;
        }
        T[] res = (T[])java.lang.reflect.Array.newInstance(objs[0].getClass(), objs.length);
        /** 新序号 **/
        int k = 0;
        for (int i = objs.length - 1; i >= 0; i-- )
        {
            res[k++ ] = objs[i];
        }
        return res;
    }

    /**
     * <p> 功能描述：将数组转为list</p>
     * 
     * @author jiangyu
     * @date 2016年3月23日 下午2:21:54
     * @param objs
     *            源数组对象
     * @return 转换之后的List
     * @since V1.0
     */
    public static <T> List<T> arrayToList(T[] objs)
    {
        if (isEmpty(objs))
        {
            return null;
        }
        List<T> list = new LinkedList<T>();
        for (T obj : objs)
        {
            list.add(obj);
        }
        return list;
    }

    /**
     * <p> 功能描述：list转换成逗号分隔字符串</p>
     * 
     * @author jiangyu
     * @date 2016年4月19日 上午10:54:48
     * @param list
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String list2Str(List<?> list)
    {
        String ret = "";
        if (list != null && list.size() > 0)
        {
            for (Object object : list)
            {
                if (object instanceof String)
                {
                    ret += ",'" + object.toString()+"'";
                }else {
                    ret += "," + object.toString();
                }
            }
        }
        if (ret.length() >= 1)
        {
            return ret.substring(1);
        }
        return "";
    }

    /**
     * <p> 功能描述：将list转为数组</p>
     * 
     * @author jiangyu
     * @date 2016年3月23日 下午2:22:32
     * @param list
     *            源list
     * @return T[]转换之后的数组对象
     * @since V1.0
     */
    public static <T> T[] listToArray(List<T> list)
    {
        if (isEmpty(list))
        {
            return null;
        }
        T[] objs = (T[])java.lang.reflect.Array.newInstance(list.get(0).getClass(), list.size());
        int i = 0; // 数组下标。
        for (T obj : list)
        {
            objs[i++ ] = obj;
        }
        return objs;
    }

    /**
     * <p> 功能描述：将一个字符串数组的内容全部添加到另外一个数组中，并返回一个新数组</p>
     * 
     * @author jiangyu
     * @date 2016年3月23日 下午2:23:06
     * @param array1
     *            第一个数组
     * @param array2
     *            第二个数组
     * @return T[] 拼接后的新数组
     * @since V1.0
     */
    public static <T> T[] concatenateArrays(T[] array1, T[] array2)
    {
        if (isEmpty(array1))
        {
            return array2;
        }
        if (isEmpty(array2))
        {
            return array1;
        }
        T[] resArray = (T[])java.lang.reflect.Array.newInstance(array1[0].getClass(), array1.length + array2.length);
        System.arraycopy(array1, 0, resArray, 0, array1.length);
        System.arraycopy(array2, 0, resArray, array1.length, array2.length);
        return resArray;
    }

    /**
     * <p> 功能描述：将一个object添加到一个数组中，并返回一个新数组</p>
     * 
     * @author jiangyu
     * @date 2016年3月23日 下午2:26:46
     * @param array
     *            被添加到的数组
     * @param obj
     *            被添加的object
     * @return T[] 返回的新数组
     * @since V1.0
     */
    public static <T> T[] addObjectToArray(T[] array, T obj)
    {
        // 结果数组
        T[] resArray = null;
        if (isEmpty(array))
        {
            resArray = (T[])java.lang.reflect.Array.newInstance(obj.getClass(), 1);
            resArray[0] = obj;
            return resArray;
        }
        // 原数组不为空时。
        resArray = (T[])java.lang.reflect.Array.newInstance(array[0].getClass(), array.length + 1);
        System.arraycopy(array, 0, resArray, 0, array.length);
        resArray[array.length] = obj;
        return resArray;
    }

    /**
     * <p> 功能描述：功能：判断数组是不是空。（null或者length==0）</p>
     * 
     * @author jiangyu
     * @date 2016年3月23日 下午2:27:13
     * @param array
     *            数组
     * @return boolean 空返回true，否则返回false
     * @since V1.0
     */
    public static <T> boolean isEmpty(T[] array)
    {
        return (array == null || array.length == 0);
    }

    /**
     * <p> 功能描述：集合是否为空。如果传入的值为null或者集合不包含元素都认为为空</p>
     * 
     * @author jiangyu
     * @date 2016年3月23日 下午2:28:30
     * @param collection
     *            校验的目标集合对象
     * @return boolean 为空返回true，否则返回false
     * @since V1.0
     */
    public static boolean isEmpty(Collection<?> collection)
    {
        return (collection == null || collection.isEmpty());
    }

    /**
     * <p> 功能描述：Map是否为空。如果传入的值为null或者集合不包含元素都认为为空</p>
     * 
     * @author jiangyu
     * @date 2016年3月23日 下午2:29:13
     * @param map
     *            要校验的map对象
     * @return boolean 为空返回true，否则返回false
     * @version v1.0
     * @since V1.0
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Map map)
    {
        return (map == null || map.isEmpty());
    }

    /**
     * <p> 功能描述：判断个字符是否为空</p>
     * 
     * @author jiangyu
     * @date 2016年3月23日 下午2:29:53
     * @param source
     *            要判断字符串
     * @return 如果为空返回真，反之为假
     * @since V1.0
     */
    public static boolean isEmpty(String source)
    {
        return (source == null || source.trim().equals("") || "null".equals(source));
    }

    /**
     * <p> 功能描述：判断个对象是否为空</p>
     * 
     * @author jiangyu
     * @date 2016年3月23日 下午2:30:26
     * @param source
     *            要判断对
     * @return 如果为空返回真，反之为假
     * @since V1.0
     */
    public static boolean isEmpty(Object source)
    {
        if (source instanceof Collection<?> && source != null)
        {
            Collection<?> collection = (Collection<?>)source;
            return (collection == null || collection.isEmpty());
        }
        return (source == null || source.toString().trim().equals("") || "null".equals(source));
    }
    
    /**
     * <p> 功能描述：HashMap的构造方法的简写 </p>
     * @author  jiangyu
     * @date  2017年4月12日 下午5:49:03
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static <K,V> HashMap<K, V> hashMapNewInstance()
    {
        return new HashMap<K, V>();
    }
}
