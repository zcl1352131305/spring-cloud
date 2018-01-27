package cn.zoucl.cloud.common.service;

import cn.zoucl.cloud.common.model.entity.BaseEntity;
import cn.zoucl.cloud.common.utils.Query;
import cn.zoucl.cloud.common.utils.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
public interface BaseService<T> {
    /**
     * 查询
     *
     * @param entity
     * @return
     */
    T selectOne(T entity);

    /**
     * 通过Id查询
     *
     * @param id
     * @return
     */
    T selectById(Object id);

    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    List<T> selectList(T entity);


    /**
     * 获取所有对象
     *
     * @return
     */
    List<T> selectListAll();


    /**
     * 查询总记录数
     *
     * @param entity
     * @return
     */
    Long selectCount(T entity);

    /**
     * 添加
     *
     * @param entity
     */
    void insert(T entity);


    /**
     * 插入 不插入null字段
     *
     * @param entity
     */
    int insertSelective(T entity);

    /**
     * 删除
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * 根据Id删除
     *
     * @param id
     */
    int deleteById(Object id);


    /**
     * 根据id更新
     *
     * @param entity
     */
    int updateById(T entity);


    /**
     * 不update null
     *
     * @param entity
     */
    int updateSelectiveById(T entity);

    /**
     * 分页查询带参数
     * @param query
     * @return
     */
    public Result selectPageByQuery(Query query);

    /**
     * 列表查询带参数
     * @param query
     * @return
     */
    public Result selectListByQuery(Map<String,Object> query);
}
