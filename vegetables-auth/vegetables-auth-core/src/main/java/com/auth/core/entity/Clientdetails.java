
package com.auth.core.entity;

import com.auth.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;



/**
* 
* @author automatic
* @version 1.0
* @data 2019-05-28 14:44
**/
@Data
@Entity
@Table(name = "veg_client_details")
public class ClientDetails extends BaseEntity<String>{



  /**
  * 主键
  */
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String appid;





  /**
  * 
  */
  @Column(name = "resourceIds")
  private String resourceids;





  /**
  * 
  */
  @Column(name = "appSecret")
  private String appsecret;





  /**
  * 
  */
  @Column(name = "scope")
  private String scope;





  /**
  * 
  */
  @Column(name = "grantTypes")
  private String granttypes;





  /**
  * 
  */
  @Column(name = "redirectUrl")
  private String redirecturl;





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
  @Column(name = "additionalInformation")
  private String additionalinformation;





  /**
  * 
  */
  @Column(name = "autoApproveScopes")
  private String autoapprovescopes;




}


