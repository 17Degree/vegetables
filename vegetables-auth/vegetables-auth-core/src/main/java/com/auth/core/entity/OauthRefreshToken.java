
package com.auth.core.entity;

import lombok.Data;

import javax.persistence.*;

import com.auth.base.BaseEntity;


/**
 * @author automatic
 * @version 1.0
 * @data 2019-05-23 15:59
 **/
@Data
@Entity
@Table(name = "veg_oauth_refresh_token")
public class OauthRefreshToken extends BaseEntity<Long> {


    /**
     *
     */
    @Column(name = "id")
    private Long id;


    /**
     *
     */
    @Column(name = "token_id")
    private String tokenId;


    /**
     *
     */
    @Column(name = "token")
    private String token;


    /**
     *
     */
    @Column(name = "authentication")
    private String authentication;


}


