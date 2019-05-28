
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
@Table(name = "veg_oauth_code")
public class OauthCode extends BaseEntity<Long>{



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
  @Column(name = "code")
  private String code;





  /**
  * 
  */
  @Column(name = "authentication")
  private String authentication;




}


