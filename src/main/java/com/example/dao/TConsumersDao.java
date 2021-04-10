package com.example.dao;

import com.example.entity.TConsumers;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户(TConsumers)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 15:34:31
 */
@Mapper
public interface TConsumersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param conNo 主键
     * @return 实例对象
     */
    @Select("select * from t_consumers where con_no=#{con_no}")
    TConsumers queryById(Integer conNo);

    @Select(value = "select * from t_consumers where name = #{name}")
    TConsumers queryByName(String name);


    @Select("select * from t_consumers order by con_no desc")
    List<TConsumers> queryAllByLimit();


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tConsumers 实例对象
     * @return 对象列表
     */
    @Select("select * from t_consumers")
    List<TConsumers> queryAll(TConsumers tConsumers);

    /**
     * 新增数据
     *
     * @param tConsumers 实例对象
     * @return 影响行数
     */
    @Insert("insert into t_consumers (name,password,coins,mail) values (#{name},#{password},#{coins},#{mail})")
    int insert(TConsumers tConsumers);

    /**
     * 修改数据
     *
     * @param conNo
     * @return 影响行数
     */
    @Update("update t_consumers set con_is_legal=0 where con_no = #{conNo}")
    boolean update(Integer conNo);

    @Update("update t_consumers set con_is_legal=1 where con_no = #{conNo}")
    boolean jieFeng(Integer conNo);

    /**
     * 通过主键删除数据
     *
     * @param conNo 主键
     * @return 影响行数
     */
    int deleteById(Integer conNo);

}