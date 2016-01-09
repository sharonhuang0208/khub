package com.claridy.khub.admin.core.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import com.claridy.khub.admin.core.enums.StatusEnum;
import com.claridy.khub.admin.core.persistent.SurrogateUuidKeyObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @version 2016-01-05
 * @author Anthony Wang
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@DynamicUpdate(value = true)
public class Resource extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = -7578515473005617844L;

    // 功能名稱
    @Column(length = 100)
    private String name;

    // 功能說明
    @Column(length = 200)
    private String description;

    // 應用程式
    @ManyToOne(optional = false)
    @JoinColumn(name = "applicatio_uuid", nullable = false)
    private Application application;

    // 權限代碼
    @Column(length = 100)
    private String restriction;

    // 資源狀態 0:INACTIVE 1:ACTIVE
    @Type(type = "com.claridy.khub.admin.core.hibernate.StatusEnumValueUserType")
    @Column(length = 1, nullable = false)
    private StatusEnum status;

    // 父功能
    @ManyToOne(optional = true)
    @JoinColumn(name = "parent_uuid", nullable = true)
    private Resource parent;

    // 功能url
    @Column(length = 100)
    private String url;

    @ManyToMany(mappedBy = "resources")
    @org.hibernate.annotations.BatchSize(size = 4)
    private Set<Role> roles = new HashSet<Role>();

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;

    public void addRole(Role role) {
        if (!roles.contains(role)) {
            roles.add(role);
            role.addResource(this);
        }
    }

    public void removeRole(Role role) {
        if (roles.contains(role)) {
            roles.remove(role);
            role.removeResource(this);
        }
    }

}
