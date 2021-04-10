package com.example.service.impl;

import com.example.dao.TFanSeriesDao;
import com.example.entity.TFanSeries;
import com.example.service.TFanSeriesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 剧集(TFanSeries)表服务实现类
 *
 * @author makejava
 * @since 2020-10-13 12:01:05
 */
@Service("tFanSeriesService")
public class TFanSeriesServiceImpl implements TFanSeriesService {
    @Resource
    private TFanSeriesDao tFanSeriesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fanSeriesNo 主键
     * @return 实例对象
     */
    @Override
    public TFanSeries queryById(Integer fanSeriesNo) {
        return tFanSeriesDao.queryById(fanSeriesNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TFanSeries> queryAllByLimit() {
        return tFanSeriesDao.queryAllByLimit();
    }

    /**
     * 新增数据
     *
     * @param tFanSeries 实例对象
     * @return 实例对象
     */
    @Override
    public TFanSeries insert(TFanSeries tFanSeries) {
        this.tFanSeriesDao.insert(tFanSeries);
        return tFanSeries;
    }

    /**
     * 修改数据
     *
     * @param tFanSeries 实例对象
     * @return 实例对象
     */
    @Override
    public TFanSeries update(TFanSeries tFanSeries) {
        this.tFanSeriesDao.update(tFanSeries);
        return queryById(tFanSeries.getFanSeriesNo());
    }

    /**
     * 通过主键删除数据
     *
     * @param fanSeriesNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer fanSeriesNo) {
        return tFanSeriesDao.deleteById(fanSeriesNo) > 0;
    }
}