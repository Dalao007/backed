package com.example.entity;

import java.io.Serializable;

/**
 * 剧集(TFanSeries)实体类
 *
 * @author makejava
 * @since 2020-10-13 12:01:04
 */
public class TFanSeries implements Serializable {
    private static final long serialVersionUID = 115588171359567782L;
    /**
     * 番剧集数编号
     */
    private Integer fanSeriesNo;
    /**
     * 番剧编号
     */
    private Integer fanNo;
    /**
     * 番剧集数
     */
    private Integer seriesNum;
    /**
     * 每集封面
     */
    private String seriesPic;
    /**
     * 每集标题
     */
    private String seriesTitle;
    /**
     * 视频地址
     */
    private String seriesUrl;


    public Integer getFanSeriesNo() {
        return fanSeriesNo;
    }

    public void setFanSeriesNo(Integer fanSeriesNo) {
        this.fanSeriesNo = fanSeriesNo;
    }

    public Integer getFanNo() {
        return fanNo;
    }

    public void setFanNo(Integer fanNo) {
        this.fanNo = fanNo;
    }

    public Integer getSeriesNum() {
        return seriesNum;
    }

    public void setSeriesNum(Integer seriesNum) {
        this.seriesNum = seriesNum;
    }

    public String getSeriesPic() {
        return seriesPic;
    }

    public void setSeriesPic(String seriesPic) {
        this.seriesPic = seriesPic;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    public String getSeriesUrl() {
        return seriesUrl;
    }

    public void setSeriesUrl(String seriesUrl) {
        this.seriesUrl = seriesUrl;
    }

}