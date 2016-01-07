package com.claridy.khub.admin.core.persistent;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.claridy.khub.admin.core.utils.DateUtils;

import lombok.Getter;

/**
 *
 * @version 2016-01-05
 * @author Anthony Wang
 *
 */
@MappedSuperclass
@Getter
public abstract class PersistentObject<K extends Serializable> implements Serializable {

    private static final long serialVersionUID = -7416019362828399516L;

    @Column
    private LocalDateTime  createdTime;

    @Column
    private LocalDateTime  lastModifiedTime;

    @Override
    public int hashCode() {
        if (this.getId() == null) return super.hashCode();
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        PersistentObject<K> other;
        try {
            other = (PersistentObject<K>) obj;
        } catch (ClassCastException e) {
            return false;
        }

        if (this.getId() != null && other.getId() != null)
            return this.getId().equals(other.getId());
        return false;
    }

    @PrePersist
    protected void onCreate() {
        lastModifiedTime = createdTime = LocalDateTime.now(DateUtils.TIME_ZONE);
    }

    @PreUpdate
    protected void onUpdate() {
        lastModifiedTime = LocalDateTime.now(DateUtils.TIME_ZONE);
    }

    public abstract K getId();

    public abstract void setId(K id);

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }
}
