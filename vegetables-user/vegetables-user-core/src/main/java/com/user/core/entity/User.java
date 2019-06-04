
package com.user.core.entity;

import com.user.base.BaseEntity;

import javax.persistence.*;


/**
 * @author automatic
 * @version 1.0
 * @data 2019-05-28 14:44
 **/
@Entity
@Table(name = "veg_user")
public class User extends BaseEntity<Long> {

    /**
     * 主键
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     *
     */
    @Column(name = "email")
    private String email;


    /**
     *
     */
    @Column(name = "mobile")
    private String mobile;


    /**
     *
     */
    @Column(name = "password")
    private String password;


    /**
     *
     */
    @Column(name = "realname")
    private String realname;


    /**
     *
     */
    @Column(name = "salt")
    private String salt;


    /**
     *
     */
    @Column(name = "username")
    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }


    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


