
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
@Table(name = "role_permission")
public class RolePermission extends BaseEntity<Long> {


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
    @Column(name = "role_id")
    private Long roleId;


    /**
     *
     */
    @Column(name = "permission_id")
    private Long permissionId;


}


