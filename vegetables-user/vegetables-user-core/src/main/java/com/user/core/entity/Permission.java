
package com.user.core.entity;

import lombok.Data;

import javax.persistence.*;

import com.user.base.BaseEntity;


/**
 * @author automatic
 * @version 1.0
 * @data 2019-05-28 20:05
 **/
@Data
@Entity
@Table(name = "permission")
public class Permission extends BaseEntity<Long> {


    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     *
     */
    @Column(name = "url")
    private String url;


    /**
     *
     */
    @Column(name = "name")
    private String name;


    /**
     *
     */
    @Column(name = "description")
    private String description;


    /**
     *
     */
    @Column(name = "pid")
    private Long pid;


}


