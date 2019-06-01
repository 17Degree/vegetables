
package com.user.core.entity;

import com.user.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;


/**
 * @author automatic
 * @version 1.0
 * @data 2019-05-28 14:44
 **/
@Data
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

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }
}


