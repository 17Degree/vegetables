
package com.auth.core.entity;

import lombok.Data;
import javax.persistence.*;
import com.auth.base.BaseEntity;



/**
* 
* @author automatic
* @version 1.0
* @data 2019-05-28 14:44
**/
@Data
@Entity
@Table(name = "veg_oauth_client_details")
public class OauthClientDetails extends BaseEntity<String>{



  /**
  * 主键
  */
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String clientId;





  /**
  * 
  */
  @Column(name = "resource_ids")
  private String resourceIds;





  /**
  * 
  */
  @Column(name = "client_secret")
  private String clientSecret;





  /**
  * 
  */
  @Column(name = "scope")
  private String scope;





  /**
  * 
  */
  @Column(name = "authorized_grant_types")
  private String authorizedGrantTypes;





  /**
  * 
  */
  @Column(name = "web_server_redirect_uri")
  private String webServerRedirectUri;





  /**
  * 
  */
  @Column(name = "authorities")
  private String authorities;





  /**
  * 
  */
  @Column(name = "access_token_validity")
  private Long accessTokenValidity;





  /**
  * 
  */
  @Column(name = "refresh_token_validity")
  private Long refreshTokenValidity;





  /**
  * 
  */
  @Column(name = "additional_information")
  private String additionalInformation;





  /**
  * 
  */
  @Column(name = "autoapprove")
  private String autoapprove;




}


