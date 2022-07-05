package com.example.spring.ajax.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;


@MappedSuperclass
public abstract class BaseEntity {
    @CreationTimestamp
    @JsonFormat()
    @Column(name = "create_at", updatable = false)
    private Date createAt;

    @CreatedBy
    @Column(name = "create_by")
    private int createBy;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @UpdateTimestamp
    @JsonFormat
    @Column(name = "updated_at")
    private Date updateAt;

    @LastModifiedBy
    @Column(name = "updated_by")
    private int updateBy;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }
}

