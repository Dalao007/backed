package com.example.service.impl;

import com.example.dao.TFanDao;
import com.example.entity.TFan;
import com.example.service.TFanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 番剧(TFan)表服务实现类
 *
 * @author makejava
 * @since 2020-10-13 11:21:35
 */
@Service("tFanService")
public class TFanServiceImpl implements TFanService {
    @Resource
    private TFanDao tFanDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fanNo 主键
     * @return 实例对象
     */
    @Override
    public TFan queryById(Integer fanNo) {
        return tFanDao.queryById(fanNo);
    }


    @Override
    public List<TFan> queryAllByLimit() {
        return tFanDao.queryAllByLimit();
    }

    /**
     * 新增数据
     *
     * @param tFan 实例对象
     * @return 实例对象
     */
    @Override
    public TFan insert(TFan tFan) {
        this.tFanDao.insert(tFan);
        return tFan;
    }

    /**
     * 修改数据
     *
     * @param tFan 实例对象
     * @return 实例对象
     */
    @Override
    public TFan update(TFan tFan) {
        this.tFanDao.update(tFan);
        return queryById(tFan.getFanNo());
    }

    /**
     * 通过主键删除数据
     *
     * @param fanNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer fanNo) {
        return tFanDao.deleteById(fanNo) > 0;
    }
}