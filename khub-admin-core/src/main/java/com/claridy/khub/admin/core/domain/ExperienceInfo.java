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
public class ExperienceInfo extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = -154975932211092066L;

    // 人員/人事資料識別碼
    @ManyToOne
    @JoinColumn(name = "people_uuid")
    private People people;

    @ManyToOne
    @JoinColumn(name = "experience_uuid")
    private Experience experience;

    // 職別
    @Column(length = 50)
    private String position;

    // 經歷_年份（起）
    @Column(length = 4)
    private String durationBeginY;

    // 經歷_年份（迄）
    @Column(length = 4)
    private String durationEndY;

    // 任職構識別碼
    @ManyToOne
    @JoinColumn(name = "organization_uuid")
    private Organization organization;

    // 建立者
    @Column(length = 255)
    private String orgName;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;
}
