package com.example.dao;

import com.example.entity.TFanSeries;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 剧集(TFanSeries)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-13 12:01:04
 */
@Mapper
public interface TFanSeriesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fanSeriesNo 主键
     * @return 实例对象
     */
    @Select("select * from t_fan_series where fan_series_no=#{fan_series_no}")
    TFanSeries queryById(Integer fanSeriesNo);

    @Select("select * from t_fan_series order by fan_series_no desc")
    List<TFanSeries> queryAllByLimit();


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tFanSeries 实例对象
     * @return 对象列表
     */
    List<TFanSeries> queryAll(TFanSeries tFanSeries);

    /**
     * 新增数据
     *
     * @param tFanSeries 实例对象
     * @return 影响行数
     */
    @Insert("INSERT INTO t_fan_series (fan_no,series_num,series_pic,series_title,series_url) VALUES(#{fanNo},#{seriesNum},#{seriesPic},#{seriesTitle},#{seriesUrl})")
    int insert(TFanSeries tFanSeries);

    /**
     * 修改数据
     *
     * @param tFanSeries 实例对象
     * @return 影响行数
     */
    int update(TFanSeries tFanSeries);

    /**
     * 通过主键删除数据
     *
     * @param fanSeriesNo 主键
     * @return 影响行数
     */
    int deleteById(Integer fanSeriesNo);



}