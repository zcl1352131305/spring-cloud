package cn.zoucl.cloud.common.service.impl;

import cn.zoucl.cloud.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
public class BaseServiceImpl<M extends Mapper<T>,T> implements BaseService<T> {

    @Autowired
    protected M mapper;

    @Override
    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

    @Override
    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }

    @Override
    public List<T> selectListAll() {
        return mapper.selectAll();
    }

    @Override
    public Long selectCount(T entity) {
        return Long.valueOf(mapper.selectCount(entity));
    }

    @Override
    public void insert(T entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(T entity) {
        mapper.insertSelective(entity);
    }

    @Override
    public void delete(T entity) {
        mapper.delete(entity);
    }

    @Override
    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(T entity) {
        mapper.updateByPrimaryKey(entity);
    }

    @Override
    public void updateSelectiveById(T entity) {
        mapper.updateByPrimaryKeySelective(entity);
    }
}
