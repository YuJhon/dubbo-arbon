package com.rain.jhon.user.dao.impl;


import org.springframework.stereotype.Repository;

import com.rain.jhon.core.dao.BaseDaoImpl;
import com.rain.jhon.facade.user.entity.PmsUser;
import com.rain.jhon.user.dao.PmsUserDao;


/**
 * <p>功能描述</br> 用户表数据访问层接口实现类</p>
 * 
 * @className PmsUserDaoImpl
 * @author jhonrain
 * @date 2017年4月18日 下午4:58:41
 * @version v1.0
 */
@Repository("pmsUserDao")
public class PmsUserDaoImpl extends BaseDaoImpl<PmsUser> implements PmsUserDao
{

    /**
     * 根据用户登录名获取用户信息.
     * 
     * @param loginName
     *            .
     * @return user .
     */

    public PmsUser findByUserNo(String userNo)
    {
        return super.getSqlSession().selectOne(getStatement("findByUserNo"), userNo);
    }
}
