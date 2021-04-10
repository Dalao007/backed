package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;

/**
 * 番剧(TFan)实体类
 *
 * @author makejava
 * @since 2020-10-13 11:21:35
 */
public class TFan implements Serializable {
    private static final long serialVersionUID = 448468382297899358L;
    /**
     * 番剧编号
     */
    private Integer fanNo;
    /**
     * 标题
     */
    private String fanTitle;
    /**
     * 管理员编号
     */
    @JsonProperty("mNo")
    private Integer mNo;
    /**
     * 番剧封面
     */
    private String fanPic;


    public Integer getFanNo() {
        return fanNo;
    }

    public void setFanNo(Integer fanNo) {
        this.fanNo = fanNo;
    }

    public String getFanTitle() {
        return fanTitle;
    }

    public void setFanTitle(String fanTitle) {
        this.fanTitle = fanTitle;
    }

    public Integer getMNo() {
        return mNo;
    }

    public void setMNo(Integer mNo) {
        this.mNo = mNo;
    }

    public String getFanPic() {
        return fanPic;
    }

    public void setFanPic(String fanPic) {
        this.fanPic = fanPic;
    }

}