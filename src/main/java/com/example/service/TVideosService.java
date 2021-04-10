package com.example.service;

import com.example.entity.TVideos;

import java.util.List;

/**
 * 视频(TVideos)表服务接口
 *
 * @author makejava
 * @since 2020-10-13 14:34:33
 */
public interface TVideosService {

    /**
     * 通过ID查询单条数据
     *
     * @param vNo 主键
     * @return 实例对象
     */
    TVideos queryById(Integer vNo);


    List<TVideos> queryAllByLimit();

    /**
     * 新增数据
     *
     * @param tVideos 实例对象
     * @return 实例对象
     */
    TVideos insert(TVideos tVideos);

    /**
     * 修改数据
     *
     * @param tVideos 实例对象
     * @return 实例对象
     */
    TVideos update(TVideos tVideos);

    /**
     * 通过主键删除数据
     *
     * @param vNo 主键
     * @return 是否成功
     */
    boolean deleteById(Integer vNo);
    boolean fengVideo(Integer vNo);

}