package com.rain.jhon.core.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rain.jhon.common.entity.BaseEntity;
import com.rain.jhon.common.exception.ArbonDAOException;


/**
 * @描述: 数据访问层基础支撑类.
 * @作者: WuShuicheng .
 * @创建时间: 2013-7-22,下午4:52:52 .
 * @版本: 1.0 .
 * @param <T>
 */
public abstract class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T>
{

    protected static final Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);

    public static final String SQL_INSERT = "insert";

    public static final String SQL_BATCH_INSERT = "batchInsert";

    public static final String SQL_UPDATE = "update";

    public static final String SQL_BATCH_UPDATE = "batchUpdate";

    public static final String SQL_GET_BY_ID = "getById";

    public static final String SQL_DELETE_BY_ID = "deleteById";

    public static final String SQL_LIST_PAGE = "listPage";

    public static final String SQL_LIST_PAGE_COUNT = "listPageCount";

    public static final String SQL_LIST_BY = "listBy";

    public static final String SQL_COUNT_BY_PAGE_PARAM = "countByPageParam"; // 根据当前分页参数进行统计

    /**
     * 注入SqlSessionTemplate实例(要求Spring中进行SqlSessionTemplate的配置).<br/> 可以调用sessionTemplate完成数据库操作.
     */
    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public SqlSessionTemplate getSessionTemplate()
    {
        return sessionTemplate;
    }

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate)
    {
        this.sessionTemplate = sessionTemplate;
    }

    public SqlSession getSqlSession()
    {
        return super.getSqlSession();
    }

    /**
     * 保存对象.
     * 
     * @param entity
     *            .
     * @return id .
     */
    public long insert(T entity)
    {

        int result = sessionTemplate.insert(getStatement(SQL_INSERT), entity);

        if (result <= 0)
        {
            throw ArbonDAOException.DB_INSERT_RESULT_0.newInstance("数据库操作,insert返回0.{%s}",
                getStatement(SQL_INSERT));
        }

        if (entity != null && entity.getId() != null && result > 0)
        {
            return entity.getId();
        }

        return result;
    }

    /**
     * 批量保存对象.
     * 
     * @param entity
     *            .
     * @return id .
     */
    public long insert(List<T> list)
    {

        if (list == null || list.size() <= 0)
        {
            return 0;
        }

        int result = sessionTemplate.insert(getStatement(SQL_BATCH_INSERT), list);

        if (result <= 0)
        {
            throw ArbonDAOException.DB_INSERT_RESULT_0.newInstance("数据库操作,insert返回0.{%s}",
                getStatement(SQL_INSERT));
        }

        return result;
    }

    /**
     * 更新对象.
     * 
     * @param entity
     *            .
     * @return int .
     */
    public int update(T entity)
    {
        int result = sessionTemplate.update(getStatement(SQL_UPDATE), entity);
        if (result <= 0)
        {
            throw ArbonDAOException.DB_UPDATE_RESULT_0.newInstance("数据库操作,update返回0.{%s}",
                getStatement(SQL_UPDATE));
        }
        return result;
    }

    /**
     * 批量更新对象.
     * 
     * @param entity
     *            .
     * @return int .
     */
    public int update(List<T> list)
    {

        if (list == null || list.size() <= 0)
        {
            return 0;
        }

        int result = sessionTemplate.update(getStatement(SQL_BATCH_UPDATE), list);
        if (result <= 0)
        {
            throw ArbonDAOException.DB_UPDATE_RESULT_0.newInstance("数据库操作,update返回0.{%s}",
                getStatement(SQL_UPDATE));
        }
        return result;
    }

    /**
     * 根据ID查找对象.
     * 
     * @param id
     *            .
     * @return T .
     */
    public T getById(long id)
    {
        return sessionTemplate.selectOne(getStatement(SQL_GET_BY_ID), id);
    }

    /**
     * 根据ID删除对象.
     * 
     * @param id
     *            .
     * @return intNum .
     */
    public int deleteById(long id)
    {
        return (int)sessionTemplate.delete(getStatement(SQL_DELETE_BY_ID), id);
    }

    /**
     * 根据条件查询 listBy: <br/>
     * 
     * @param paramMap
     * @return
     */
    public List<T> listBy(Map<String, Object> paramMap)
    {
        return sessionTemplate.selectList(getStatement(SQL_LIST_BY), paramMap);
    }

    /**
     * 根据条件查询 getBy: selectOne <br/>
     * 
     * @param paramMap
     * @return
     */
    public T getBy(Map<String, Object> paramMap)
    {
        if (paramMap == null || paramMap.isEmpty())
        {
            return null;
        }

        return sessionTemplate.selectOne(getStatement(SQL_LIST_BY), paramMap);
    }

    /**
     * 获取Mapper命名空间.
     * 
     * @param sqlId
     * @return
     */
    public String getStatement(String sqlId)
    {
        String name = this.getClass().getName();
        StringBuffer sb = new StringBuffer();
        sb.append(name).append(".").append(sqlId);
        String statement = sb.toString();

        return statement;
    }

}
