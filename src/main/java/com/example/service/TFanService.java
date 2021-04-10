package com.example.service;

import com.example.entity.TFan;

import java.util.List;

/**
 * 番剧(TFan)表服务接口
 *
 * @author makejava
 * @since 2020-10-13 11:21:35
 */
public interface TFanService {

    /**
     * 通过ID查询单条数据
     *
     * @param fanNo 主键
     * @return 实例对象
     */
    TFan queryById(Integer fanNo);


    List<TFan> queryAllByLimit();

    /**
     * 新增数据
     *
     * @param tFan 实例对象
     * @return 实例对象
     */
    TFan insert(TFan tFan);

    /**
     * 修改数据
     *
     * @param tFan 实例对象
     * @return 实例对象
     */
    TFan update(TFan tFan);

    /**
     * 通过主键删除数据
     *
     * @param fanNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer fanNo);

}