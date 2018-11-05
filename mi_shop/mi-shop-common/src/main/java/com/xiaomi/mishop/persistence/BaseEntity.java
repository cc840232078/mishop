package com.xiaomi.mishop.persistence;

import com.xiaomi.mishop.webSupport.Page;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseEntity {

    private Long id;

    private Date created;

    private Date updated;
    /**
     * 用来做分页查询
     */
    private Page page;


}
