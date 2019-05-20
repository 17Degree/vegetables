package com.user.core.entity;

import com.user.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;


/**
 * 用户表
 *
 * @author automatic
 * @version 1.0
 * @data 2019-05-16 17:40
 **/
@Entity
@Table(name = "veg_user")
public class User extends BaseEntity<Long> {

    private static final long serialVersionUID = -3615182505047593697L;

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


    private Date date;


    public static User Generator(){

        User user = null;

        try(FileInputStream fileInputStream = new FileInputStream("C:\\Users\\chenjiacheng\\Desktop\\temp2\\1.txt");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);){

            user = (User) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return user;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

