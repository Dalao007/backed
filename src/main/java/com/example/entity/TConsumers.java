package com.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户(TConsumers)实体类
 *
 * @author makejava
 * @since 2021-03-25 23:27:44
 */
@Data
public class TConsumers implements Serializable {
    private static final long serialVersionUID = 810151394500161175L;
    /**
     * 用户编号
     */
    private Integer conNo;
    /**
     * 角色编号
     */
    private Integer roleNo;
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 硬币
     */
    private Integer coins;
    /**
     * 联系电话
     */
    private String teleNum;
    /**
     * 注册日期
     */
    private Date regDate;
    /**
     * 会员到期时间
     */
    private Object memberDeadline;
    /**
     * 用户是否合法
     */
    private Boolean conIsLegal;
    /**
     * 用户头像
     */
    private Object pic;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 被举报数
     */
    private Integer reportNum;


}