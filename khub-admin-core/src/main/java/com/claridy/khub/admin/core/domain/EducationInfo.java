package com.claridy.khub.admin.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
public class EducationInfo extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = 5135866027843884519L;

    // 學歷識別碼
    @ManyToOne
    @JoinColumn(name = "education_uuid")
    private Education education;

    // 學歷學位
    @Column(length = 50)
    private String edu;

    // 學歷起迄年（起）
    @Column(length = 4)
    private String durationBeginY;

    // 學歷起迄年（迄）
    @Column(length = 4)
    private String durationEndY;

    // 學歷機構識別碼
    @ManyToOne
    @JoinColumn(name = "org_uuid")
    private Organization organization;

    // 自填就學機構名稱
    @Column(length = 255)
    private String orgName;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;
}
