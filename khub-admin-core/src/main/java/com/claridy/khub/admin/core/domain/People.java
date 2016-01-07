package com.claridy.khub.admin.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class People extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = 1578056706904534386L;

    // 身分證號/居留證號
    @Column(length = 50)
    private String idNo;

    // 人事代碼
    @Column(length = 50)
    private String personId;

    // 人事代碼
    @Column(length = 50)
    private String librarySysId;

    // ORCID
    @Column(length = 50)
    private String orcid;

    // Researcher ID
    @Column(length = 50)
    private String researcherId;

    // Scopus研究者識別碼
    @Column(length = 50)
    private String scopusAuthorId;

    // Scopus經歷識別碼
    @Column(length = 50)
    private String scopusExpId;

    // 教師代碼
    @Column(length = 50)
    private String teacherId;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;

}
