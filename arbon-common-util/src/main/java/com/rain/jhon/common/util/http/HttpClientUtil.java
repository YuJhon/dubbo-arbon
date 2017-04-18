package com.rain.jhon.common.util.http;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;


/**
 * <p>功能描述</br> Http请求的工具类</p>
 * 
 * @className HttpClientUtil
 * @author jiangyu
 * @date 2016年3月31日 下午9:48:58
 * @version v1.0
 */
public class HttpClientUtil
{
    private static Logger LOG = Logger.getLogger(HttpClientUtil.class);

    /**
     * <p> 功能描述： HTTP请求，默认为get请求</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:49:03
     * @param url
     *            请求的URL
     * @param map
     *            参数
     * @return
     * @throws Exception
     * @version v1.0
     * @since V1.0
     */
    public static String getResult(String url, Map<String, Object> map)
    {
        HttpClient client = new HttpClient();
        StringBuffer sb = new StringBuffer();
        sb.append(url).append(getUrlParamsFromMap(map));
        LOG.info("调用的url为：" + sb.toString());
        HttpMethod method = new GetMethod(sb.toString());
        StringBuffer stringBuffer = new StringBuffer();
        try
        {
            client.executeMethod(method);
            BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
            String str = "";
            while ((str = reader.readLine()) != null)
            {
                stringBuffer.append(str);
            }
        }
        catch (HttpException e)
        {
            LOG.error("HTTPClient Exception:" + e);
            return "";
        }
        catch (IOException e)
        {
            LOG.error("HTTPClient IOException:" + e);
            return "";
        }
        return stringBuffer.toString();
    }

    /**
     * Description: HTTP POST请求<br>
     * 
     * @param url
     *            请求的URL
     * @param map
     *            参数
     * @return
     * @throws Exception
     * @see
     */
    public static String postWay(String url, Map<String, Object> map)
        throws Exception
    {
        HttpClient client = new HttpClient();

        StringBuffer sb = new StringBuffer();
        sb.append(url);
        LOG.info("调用的url为：" + sb.toString());
        PostMethod method = new PostMethod(sb.toString());
        /** 请求参数设置 **/
        for (String key : map.keySet())
        {
            method.addParameter(key, replaceNullStr(map.get(key)));
        }
        client.executeMethod(method);
        /** 获取 post返回的IO流，从getResponseBody取值 **/
        BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String result = "";
        while ((result = reader.readLine()) != null)
        {
            stringBuffer.append(result);
        }

        return stringBuffer.toString();
    }

    /**
     * <p> 功能描述：拼接参数</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午9:49:46
     * @param map
     * @return
     * @version v1.0
     * @since V1.0
     */
    public static String getUrlParamsFromMap(Map<String, Object> map)
    {
        if (map == null)
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

    /**
     * <p> 功能描述：替换空对象为空字符串</p>
     * 
     * @author jiangyu
     * @date 2016年3月31日 下午10:05:19
     * @param value
     * @return
     * @version v1.0
     * @since V1.0
     */
    private static String replaceNullStr(Object value)
    {
        return null == value ? "" : value.toString().trim();
    }

}
