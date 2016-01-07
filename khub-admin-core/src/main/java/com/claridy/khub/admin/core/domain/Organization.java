package com.claridy.khub.admin.core.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

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
public class Organization extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = -5033288950616489226L;

    //父組織
    @ManyToOne
    @JoinColumn(name="parent_uuid")
    private Organization parent;

    //統一編號
    @Column(length = 50)
    private String taxId;

    // 組織/機構代碼
    @Column(length = 50)
    private String orgId;

    // 組織/機構類型
    @Column(length = 5)
    private String type;

    //大專院校單位代碼
    @Column(length = 50)
    private String collegeId;

    //計畫系統單位代碼
    @Column(length = 50)
    private String projectSysId;

    //WoS機構代碼
    @Column(length = 50)
    private String wosOrgId;

    //Scopus機構代碼
    @Column(length = 50)
    private String scopusOrgId;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="orgs")
    @org.hibernate.annotations.BatchSize(size = 4)
    private Set<BackendUser> backendUsers = new HashSet<BackendUser>();

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;

}
