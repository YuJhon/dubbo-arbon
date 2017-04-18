package com.rain.jhon.common.util.http;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.log4j.Logger;

import com.rain.jhon.common.util.collection.CollectionUtil;


/**
 * <p>功能描述:</br> url编码</p>
 * 
 * @className UrlEncoderUtil
 * @author jiangyu
 * @date 2016年3月31日 下午10:01:05
 * @version v1.0
 */
public class UrlCoderUtil
{
    private static final Logger LOG = Logger.getLogger(UrlCoderUtil.class);

    /**
     * <p> 功能描述：UTF-8编码</p>
     * 
     * @author jiangyu
     * @date 2016年4月1日 下午5:37:39
     * @param params
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String UTF8Encode(String params)
    {
        String res = "";
        try
        {
            if (CollectionUtil.isEmpty(params))
            {
                return params;
            }
            res = URLEncoder.encode(params, "utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            LOG.info("encode failed ,reason is :" + e.getMessage());
            e.printStackTrace();
        }
        return res;
    }

    /**
     * <p> 功能描述：UTF-8url解码</p>
     * 
     * @author jiangyu
     * @date 2016年4月1日 下午5:37:44
     * @param params
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String UTF8Decode(String params)
    {
        String res = "";
        try
        {
            res = URLDecoder.decode(params, "utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            LOG.error("decode failed ,reason is :" + e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    /**
     * <p> 功能描述：get方式拼接Url的方式拼接参数</p>
     * @author  jiangyu
     * @date  2016年4月10日 下午2:08:03
     * @param map
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getUrlParamsFromMap(Map<String, Object> map)
    {
        if (map == null||map.size()==0)
        {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for (Map.Entry<String, Object> entry : map.entrySet())
        {
            if (index == 0)
            {
                sb.append("?");
            }
            if (entry.getValue() == null)
            {
                sb.append(entry.getKey() + "=" + UrlCoderUtil.UTF8Encode(""));
            }
            else
            {
                sb.append(entry.getKey() + "=" + UrlCoderUtil.UTF8Encode(entry.getValue().toString()));
            }
            sb.append("&");
            index++ ;
        }
        String s = sb.toString();
        s = s.substring(0, s.lastIndexOf("&"));
        return s;
    }
}
