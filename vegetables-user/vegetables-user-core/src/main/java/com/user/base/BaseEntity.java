package com.user.base;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity<ID extends Serializable> implements Serializable{

    private static final long serialVersionUID = -7824717674898671157L;

    /**
     * 主键
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
