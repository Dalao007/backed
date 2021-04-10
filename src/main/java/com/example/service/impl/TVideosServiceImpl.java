package com.example.service.impl;

import com.example.dao.TVideosDao;
import com.example.entity.TVideos;
import com.example.service.TVideosService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 视频(TVideos)表服务实现类
 *
 * @author makejava
 * @since 2020-10-13 14:34:33
 */
@Service("tVideosService")
public class TVideosServiceImpl implements TVideosService {
    @Resource
    private TVideosDao tVideosDao;

    /**
     * 通过ID查询单条数据
     *
     * @param vNo 主键
     * @return 实例对象
     */
    @Override
    public TVideos queryById(Integer vNo) {
        return tVideosDao.queryById(vNo);
    }

    /**
     * 查询多条数据
     * @return 对象列表
     */
    @Override
    public List<TVideos> queryAllByLimit() {
        return tVideosDao.queryAllByLimit();
    }

    /**
     * 新增数据
     *
     * @param tVideos 实例对象
     * @return 实例对象
     */
    @Override
    public TVideos insert(TVideos tVideos) {
        this.tVideosDao.insert(tVideos);
        return tVideos;
    }

    /**
     * 修改数据
     *
     * @param tVideos 实例对象
     * @return 实例对象
     */
    @Override
    public TVideos update(TVideos tVideos) {
        this.tVideosDao.update(tVideos);
        return queryById(tVideos.getVNo());
    }

    /**
     * 通过主键删除数据
     *
     * @param vNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer vNo) {
        return tVideosDao.deleteById(vNo) > 0;
    }

    @Override
    public boolean fengVideo(Integer vNo) {
        return tVideosDao.fengVideo(vNo);
    }
}