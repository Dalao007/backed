package com.example.service;

import com.example.entity.TFanSeries;

import java.util.List;

/**
 * 剧集(TFanSeries)表服务接口
 *
 * @author makejava
 * @since 2020-10-13 12:01:04
 */
public interface TFanSeriesService {

    /**
     * 通过ID查询单条数据
     *
     * @param fanSeriesNo 主键
     * @return 实例对象
     */
    TFanSeries queryById(Integer fanSeriesNo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TFanSeries> queryAllByLimit();

    /**
     * 新增数据
     *
     * @param tFanSeries 实例对象
     * @return 实例对象
     */
    TFanSeries insert(TFanSeries tFanSeries);

    /**
     * 修改数据
     *
     * @param tFanSeries 实例对象
     * @return 实例对象
     */
    TFanSeries update(TFanSeries tFanSeries);

    /**
     * 通过主键删除数据
     *
     * @param fanSeriesNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer fanSeriesNo);

}