package com.example.dao;

import com.example.entity.TVideos;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 视频(TVideos)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-13 14:34:33
 */
@Mapper
public interface TVideosDao {

    /**
     * 通过ID查询单条数据
     *
     * @param vNo 主键
     * @return 实例对象
     */
    @Select("select * from t_videos where v_no=#{v_no}")
    TVideos queryById(Integer vNo);

    @Select("select * from t_videos")
    List<TVideos> queryAllByLimit();


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tVideos 实例对象
     * @return 对象列表
     */
    List<TVideos> queryAll(TVideos tVideos);

    /**
     * 新增数据
     *
     * @param tVideos 实例对象
     * @return 影响行数
     */
    @Insert("insert INTO t_videos (v_title,v_url,con_no,v_pic,v_coins) VALUES(#{vTitle},#{vUrl},#{conNo},#{vPic},#{vCoins})")
    int insert(TVideos tVideos);

    /**
     * 修改数据
     *
     * @param tVideos 实例对象
     * @return 影响行数
     */
    int update(TVideos tVideos);

    /**
     * 通过主键删除数据
     *
     * @param vNo 主键
     * @return 影响行数
     */
    int deleteById(Integer vNo);

    @Update("update t_videos set v_legal=0 where v_no = #{vNo}")
    boolean fengVideo(Integer vNo);


}