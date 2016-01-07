package com.claridy.khub.admin.core.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
public class Role extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = -7578515473005617844L;

    // 群組名稱
    @Column(length = 100)
    private String name;

    // 群組說明
    @Column(length = 200)
    private String description;

    // 群組狀態 0:INACTIVE 1:ACTIVE
    @Type(type = "com.claridy.khub.admin.core.hibernate.StatusEnumValueUserType")
    @Column(length = 1, nullable = false)
    private StatusEnum status;

    // 排序 default 0
    private Integer seq = 0;

    @ManyToMany
    @JoinTable(name = "resource_role_map", joinColumns = { @JoinColumn(name = "role_uuid") }, inverseJoinColumns = {
            @JoinColumn(name = "resource_uuid") })
    private Set<Resource> resources = new HashSet<Resource>();

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="roles")
    @org.hibernate.annotations.BatchSize(size = 4)
    private Set<BackendUser> backendUsers = new HashSet<BackendUser>();

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;

}
