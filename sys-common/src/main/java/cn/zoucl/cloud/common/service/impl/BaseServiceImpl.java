package cn.zoucl.cloud.common.service.impl;

import cn.zoucl.cloud.common.service.BaseService;
import cn.zoucl.cloud.common.utils.Query;
import cn.zoucl.cloud.common.utils.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

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
    public int insertSelective(T entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public void delete(T entity) {
        mapper.delete(entity);
    }

    @Override
    public int deleteById(Object id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateById(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public void updateSelectiveById(T entity) {
        mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public Result selectPageByQuery(Query query) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        for (Map.Entry<String, Object> entry : query.entrySet()) {
            criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
        }
        PageHelper.startPage(query.getPage(), query.getLimit());
        List<T> list = mapper.selectByExample(example);
        return Result.success(new PageInfo<>(list));
    }

    @Override
    public Result selectListByQuery(Map<String,Object> query) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        for (Map.Entry<String, Object> entry : query.entrySet()) {
            criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
        }
        List<T> list = mapper.selectByExample(example);
        return Result.success(list);
    }
}
