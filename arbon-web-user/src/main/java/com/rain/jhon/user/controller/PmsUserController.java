package com.rain.jhon.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rain.jhon.common.bean.ArbonResponse;
import com.rain.jhon.common.util.response.ResponseUtil;
import com.rain.jhon.common.web.ArbonBaseController;
import com.rain.jhon.facade.user.entity.PmsUser;
import com.rain.jhon.facade.user.service.PmsUserFacade;


@Controller
@RequestMapping("/user")
public class PmsUserController extends ArbonBaseController
{
    @Autowired
    private PmsUserFacade pmsUserFacade;

    @RequestMapping(value="/getUserByNo.do",method=RequestMethod.GET)
    @ResponseBody
    public ArbonResponse getUserInfo()
    {
        PmsUser pmsUser = pmsUserFacade.findUserByUserNo("admin");
        return ResponseUtil.ok(pmsUser);
    }
}
