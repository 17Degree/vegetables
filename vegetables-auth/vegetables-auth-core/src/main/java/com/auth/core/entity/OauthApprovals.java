
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
@Table(name = "veg_oauth_approvals")
public class OauthApprovals extends BaseEntity<Long>{



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


