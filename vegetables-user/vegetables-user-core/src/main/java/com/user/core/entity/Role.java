
package com.user.core.entity;

import com.user.base.BaseEntity;
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
@Table(name = "veg_role")
public class Role extends BaseEntity<Long>{

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
  @Column(name = "create_date")
  private String createDate;

  /**
  * 
  */
  @Column(name = "name")
  private String name;


}


