
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
@Table(name = "veg_oauth_client_token")
public class OauthClientToken extends BaseEntity<String>{



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
  * 主键
  */
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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


