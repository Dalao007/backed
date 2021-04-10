package com.example.service;

import com.example.entity.TConsumers;

import java.util.List;

/**
 * 用户(TConsumers)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 15:34:32
 */
public interface TConsumersService {

    /**
     * 通过ID查询单条数据
     *
     * @param conNo 主键
     * @return 实例对象
     */
    TConsumers queryById(Integer conNo);
    TConsumers queryByName(String name);


    List<TConsumers> queryAllByLimit();

    /**
     * 新增数据
     *
     * @param tConsumers 实例对象
     * @return 实例对象
     */
    TConsumers insert(TConsumers tConsumers);

    /**
     * 修改数据
     *
     * @param tConsumers 实例对象
     * @return 实例对象
     */
    boolean update(Integer conNo);
    boolean jieFeng(Integer conNo);

    /**
     * 通过主键删除数据
     *
     * @param conNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer conNo);

}