package com.rain.jhon.common.web;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.jhon.common.bean.ArbonResponse;
import com.rain.jhon.common.util.exception.ArbonExcpResolve;
import com.rain.jhon.common.util.time.TimeUtil;


/*
 * <p>功能描述</br> 基础的控制器，提供顶层的异常处理，封装了异常情况下的返回值 </p>
 * @className ArbonBaseController
 * @author jhonrain
 * @date 2017年4月18日 下午2:11:01
 * @version v1.0
 */
@Controller
public class ArbonBaseController extends ArbonExcpResolve
{
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        DateFormat dateFormat = new SimpleDateFormat(TimeUtil.PATTERN_DATE_7);
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * <p> 功能描述：<br> 对所有经过Controller的异常进行了统一处理 <note> <ul>
     * <li>如果抛出的是ArbonViewException，向前端返回错误码和错误信息</li>
     * <li>如果抛出的是ArbonSysException，向前端返回系统异常，具体异常信息不可见</li> </ul> </note> </p>
     * 
     * @author jhonrain
     * @date 2017年4月18日 下午4:12:31
     * @param request
     *            HTTP请求
     * @param response
     *            HTTP响应
     * @param ex
     *            捕捉到的异常
     * @return ArbonResponse 通用返回值
     * @see ArbonResponse
     * @version v1.0
     * @since V1.0
     */
    @ExceptionHandler
    @ResponseBody
    public ArbonResponse resolveException(HttpServletRequest request,
                                          HttpServletResponse response, Exception ex)
    {
        return super.resolve(ex);
    }
}
