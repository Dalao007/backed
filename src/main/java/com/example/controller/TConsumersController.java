package com.example.controller;

import com.example.entity.Page;
import com.example.entity.TConsumers;
import com.example.service.TConsumersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户(TConsumers)表控制层
 *
 * @author makejava
 * @since 2020-10-11 15:34:32
 */
@RestController
public class TConsumersController {
    /**
     * 服务对象
     */
    @Resource
    private TConsumersService tConsumersService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @PostMapping("getUserByName")
    public TConsumers selectOne(@RequestBody TConsumers tConsumers) {
        return this.tConsumersService.queryByName(tConsumers.getName());
    }


    @PostMapping("getUserByPage")
    public Object getUserByPage(@RequestBody Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<TConsumers> list = tConsumersService.queryAllByLimit();
        PageInfo<TConsumers> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    @PostMapping("insertUser")
    public Object insertUser(@RequestBody TConsumers tConsumers) {
        return tConsumersService.insert(tConsumers);
    }


    @PostMapping("fengHao")
    public boolean updateUser(@Param("conNo") Integer conNo) {
        return tConsumersService.update(conNo);
    }

    @PostMapping("jieFeng")
    public boolean jieFeng(@Param("conNo") Integer conNo) {
        return tConsumersService.jieFeng(conNo);
    }

}