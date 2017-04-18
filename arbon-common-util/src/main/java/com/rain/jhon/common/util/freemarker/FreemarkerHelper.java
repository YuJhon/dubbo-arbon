package com.rain.jhon.common.util.freemarker;


import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


/**
 * <p>功能描述</br> freeMarker的工具类 </p>
 * 
 * @className FreemarkerHelper
 * @author jiangyu
 * @date 2016年4月11日 上午11:11:55
 * @version v1.0
 */
public class FreemarkerHelper
{
    private static Configuration _tplConfig = new Configuration();
    static
    {
        _tplConfig.setClassForTemplateLoading(FreemarkerHelper.class, "/");
    }
    

    /**
     * <p> 功能描述：解析Freemarker的工具类</p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 上午11:12:21
     * @param String
     *            tplName freemarker文件的名称
     * @param String
     *            encoding 编码方式
     * @param Map
     *            <String,Object> paras 要替换的内容参数和内容
     * @return
     * @version v1.0
     * @since V1.0
     */
    public String parseTemplate(String tplName, String encoding, Map<String, Object> paras)
    {
        StringWriter swriter = new StringWriter();
        Template mytpl = null;
        try
        {
            mytpl = _tplConfig.getTemplate(tplName, encoding);
        }
        catch (IOException e0)
        {
            e0.printStackTrace();
            throw new RuntimeException("【FreeMarker File Read Exception】" + e0.getMessage());
        }

        try
        {
            mytpl.process(paras, swriter);
        }
        catch (TemplateException e)
        {
            e.printStackTrace();
            throw new RuntimeException("【FreeMarker File Parse TemplateException】"
                                       + e.getMessage());
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new RuntimeException("【FreeMarker File Parse IOException】" + e.getMessage());
        }
        return swriter.toString();
    }

    /**
     * <p> 功能描述：解析Freemarker的工具类</p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 上午11:12:21
     * @param String
     *            tplName freemarker文件的名称
     * @param Map
     *            <String,Object> paras 要替换的内容参数和内容
     * @return
     * @version v1.0
     * @since V1.0
     */
    public String parseTemplateForUTF8(String tplName, Map<String, Object> paras)
    {
        return this.parseTemplate(tplName, "utf-8", paras);
    }
    
    private FreemarkerHelper()
    {}

    private static final class FreeMarkerHelperHolder
    {
        private static FreemarkerHelper INSTANCE = new FreemarkerHelper();
    }

    public static FreemarkerHelper getInstance()
    {
        return FreeMarkerHelperHolder.INSTANCE;
    }
}