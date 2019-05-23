
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
@Table(name = "veg_oauth_client_token")
public class OauthClientToken extends BaseEntity<String> {


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
    @Column(name = "authentication_id")
    private String authenticationId;


    /**
     *
     */
    @Column(name = "user_name")
    private String userName;


    /**
     *
     */
    @Column(name = "client_id")
    private String clientId;


}


