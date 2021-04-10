package com.example.dao;

import com.example.entity.TFan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 番剧(TFan)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-13 11:21:35
 */
@Mapper
public interface TFanDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fanNo 主键
     * @return 实例对象
     */
    @Select("select * from t_fan where fan_no=#{fan_no}")
    TFan queryById(Integer fanNo);

    @Select("select * from t_fan")
    List<TFan> queryAllByLimit();


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tFan 实例对象
     * @return 对象列表
     */
    List<TFan> queryAll(TFan tFan);

    /**
     * 新增数据
     *
     * @param tFan 实例对象
     * @return 影响行数
     */
    @Insert("insert INTO t_fan (fan_title,m_no,fan_pic) VALUES(#{fanTitle},#{mNo},#{fanPic})")
    int insert(TFan tFan);

    /**
     * 修改数据
     *
     * @param tFan 实例对象
     * @return 影响行数
     */
    int update(TFan tFan);

    /**
     * 通过主键删除数据
     *
     * @param fanNo 主键
     * @return 影响行数
     */
    int deleteById(Integer fanNo);

}