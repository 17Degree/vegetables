
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
@Table(name = "user_role")
public class UserRole extends BaseEntity<Long> {


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
    @Column(name = "user_id")
    private Long userId;


    /**
     *
     */
    @Column(name = "role_id")
    private Long roleId;


}


