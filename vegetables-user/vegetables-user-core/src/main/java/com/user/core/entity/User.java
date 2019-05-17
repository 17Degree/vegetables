package com.user.core.entity;

import com.user.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * 用户表
 *
 * @author automatic
 * @version 1.0
 * @data 2019-05-16 17:40
 **/
@Data
@Entity
@Table(name = "veg_user")
public class User extends BaseEntity<Long> {

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 密码盐值
     */
    @Column(name = "salt")
    private String salt;

    /**
     * 真实姓名
     */
    @Column(name = "realname")
    private String realname;

    /**
     * 手机号
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 删除标记 0：未删除、1：已删除
     */
    @Column(name = "deleted")
    private Boolean deleted;

}

