package com.example.service.impl;

import com.example.dao.TConsumersDao;
import com.example.entity.TConsumers;
import com.example.service.TConsumersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户(TConsumers)表服务实现类
 *
 * @author makejava
 * @since 2020-10-11 15:34:32
 */
@Service("tConsumersService")
public class TConsumersServiceImpl implements TConsumersService {
    @Resource
    private TConsumersDao tConsumersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param conNo 主键
     * @return 实例对象
     */
    @Override
    public TConsumers queryById(Integer conNo) {
        return tConsumersDao.queryById(conNo);
    }

    @Override
    public TConsumers queryByName(String name) {
        String sql = "select * from t_consumers where name like "+"'%"+"#{name}"+"%'";

        return tConsumersDao.queryByName(name);
    }

    @Override
    public List<TConsumers> queryAllByLimit() {
        return tConsumersDao.queryAllByLimit();
    }

    /**
     * 新增数据
     *
     * @param tConsumers 实例对象
     * @return 实例对象
     */
    @Override
    public TConsumers insert(TConsumers tConsumers) {
        this.tConsumersDao.insert(tConsumers);
        return tConsumers;
    }

    /**
     * 修改数据
     *
     * @return 实例对象
     */
    @Override
    public boolean update(Integer conNo) {
        return this.tConsumersDao.update(conNo);
    }

    @Override
    public boolean jieFeng(Integer conNo) {
        return this.tConsumersDao.jieFeng(conNo);
    }

    /**
     * 通过主键删除数据
     *
     * @param conNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer conNo) {
        return tConsumersDao.deleteById(conNo) > 0;
    }
}