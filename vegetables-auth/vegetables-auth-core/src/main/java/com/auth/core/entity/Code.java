
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
@Table(name = "vegoauth_code")
public class Code extends BaseEntity<Long> {


    /**
     *
     */
    @Column(name = "id")
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


