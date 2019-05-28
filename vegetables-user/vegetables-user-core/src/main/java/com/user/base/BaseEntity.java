package com.user.base;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity<ID extends Serializable> implements Serializable{

    private static final long serialVersionUID = -7824717674898671157L;


}
