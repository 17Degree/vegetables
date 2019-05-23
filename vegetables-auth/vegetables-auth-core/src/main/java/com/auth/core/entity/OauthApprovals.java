
package com.auth.core.entity;

import com.auth.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author automatic
 * @version 1.0
 * @data 2019-05-23 15:59
 **/
@Data
@Entity
@Table(name = "veg_oauth_approvals")
public class OauthApprovals extends BaseEntity<Long> {


    /**
     *
     */
    @Column(name = "id")
    private Long id;


    /**
     *
     */
    @Column(name = "userId")
    private String userid;


    /**
     *
     */
    @Column(name = "clientId")
    private String clientid;


    /**
     *
     */
    @Column(name = "scope")
    private String scope;


    /**
     *
     */
    @Column(name = "status")
    private String status;


    /**
     *
     */
    @Column(name = "expiresAt")
    private java.sql.Date expiresat;


    /**
     *
     */
    @Column(name = "lastModifiedAt")
    private java.sql.Date lastmodifiedat;


}


