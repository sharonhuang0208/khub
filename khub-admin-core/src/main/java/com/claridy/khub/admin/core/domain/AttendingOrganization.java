package com.claridy.khub.admin.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
public class AttendingOrganization extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = -742947930674777665L;

    // 參與活動類型
    @Column(length = 20)
    private String activityType;

    // 參與活動識別碼
    @ManyToOne
    @JoinColumn(name="activity_uuid")
    private Activity activity;

    //參與角色代碼
    @Column(length = 50)
    private String roleCode;

    // 機構識別碼
    @ManyToOne
    @JoinColumn(name="org_uuid")
    private Organization organization;

    // 機構名稱
    @Column(length = 255)
    private String orgName;

    // 英文機構名稱
    @Column(length = 255)
    private String orgNameEn;

    // 機構國家代碼
    @Column(length = 5)
    private String orgCountryCode;

    // 機構國家
    @Column(length = 50)
    private String orgCountry;

    // 資料語系
    @ManyToOne
    @NotNull
    private Language language;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;


}
