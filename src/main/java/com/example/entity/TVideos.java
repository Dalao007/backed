package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 视频(TVideos)实体类
 *
 * @author makejava
 * @since 2020-10-13 14:34:33
 */
@Data
public class TVideos implements Serializable {
    private static final long serialVersionUID = -59206013210075896L;
    /**
     * 视频编号
     */
    @JsonProperty("vNo")
    private Integer vNo;
    /**
     * 视频标题
     */
    @JsonProperty("vTitle")
    private String vTitle;
    /**
     * 播放量
     */
    @JsonProperty("vAmountOfPlay")
    private Integer vAmountOfPlay;
    /**
     * 视频地址
     */
    @JsonProperty("vUrl")
    private String vUrl;
    /**
     * 用户
     */
    @JsonProperty("conNo")
    private Integer conNo;
    /**
     * 点赞数
     */
    @JsonProperty("vLikes")
    private Integer vLikes;
    /**
     * 视频封面
     */
    @JsonProperty("vPic")
    private String vPic;
    /**
     * 视频收到的硬币
     */
    @JsonProperty("vCoins")
    private Integer vCoins;


}