/*
 * Copyright (c) 2016, Seer Tech co. tld. All rights reserved.
 * SEER TECH PROJECT: cherry. Use is subject to license terms.
 *
 *
 *
 *
 *
 */
package com.lee.phoenix.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 所有数据库映射实体类的基础类. <p />
 *
 * @author lee
 * @version 1.0.0
 * @date 2018/08/07 23:00
 * @since JDK1.8
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    /**
     * ID，自增，表的唯一标识.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "updateTime", insertable = false, updatable = true, columnDefinition = "datetime")
    private Timestamp updateTime;

    @Column(name = "createTime", insertable = true, updatable = true, columnDefinition = "datetime")
    private Timestamp createTime;

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @PrePersist
    void onCreate() {
        if (createTime == null) {
            this.setCreateTime(new Timestamp((new Date()).getTime()));
        }
    }

    @PreUpdate
    void onPersist() {
        this.setUpdateTime(new Timestamp((new Date()).getTime()));
    }
}
