/**
 * 
 */
package com.rain.jhon.user.facade.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.jhon.facade.user.entity.PmsUser;
import com.rain.jhon.facade.user.service.PmsUserFacade;
import com.rain.jhon.user.service.PmsUserBiz;


/**
 * <p>功能描述</br> 用户Dubbo服务接口实现</p>
 * 
 * @className PmsUserFacadeImpl
 * @author jhonrain
 * @date 2017年4月18日 下午4:39:53
 * @version v1.0
 */
@Service("pmsUserFacade")
public class PmsUserFacadeImpl implements PmsUserFacade
{
    @Autowired
    private PmsUserBiz pmsUserBiz;

    /**
     * 保存用户信息.
     * 
     * @param pmsUser
     */
    @Override
    public void create(PmsUser pmsUser)
    {
        pmsUserBiz.create(pmsUser);
    }

    /**
     * 根据ID获取用户信息.
     * 
     * @param userId
     * @return
     */
    @Override
    public PmsUser getById(Long userId)
    {
        return pmsUserBiz.getById(userId);
    }

    /**
     * 根据登录名取得用户对象
     */
    @Override
    public PmsUser findUserByUserNo(String userNo)
    {
        return pmsUserBiz.findUserByUserNo(userNo);
    }

    /**
     * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
     * 
     * @param id
     *            用户ID.
     */
    @Override
    public void deleteUserById(long userId)
    {
        pmsUserBiz.deleteUserById(userId);
    }

    /**
     * 更新用户信息.
     * 
     * @param user
     */
    @Override
    public void update(PmsUser user)
    {
        pmsUserBiz.update(user);
    }

    /**
     * 根据用户ID更新用户密码.
     * 
     * @param userId
     * @param newPwd
     *            (已进行SHA1加密)
     */
    @Override
    public void updateUserPwd(Long userId, String newPwd, boolean isTrue)
    {
        pmsUserBiz.updateUserPwd(userId, newPwd, isTrue);
    }
}
