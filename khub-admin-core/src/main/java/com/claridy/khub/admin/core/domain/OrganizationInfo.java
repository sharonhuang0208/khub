package com.claridy.khub.admin.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

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
public class OrganizationInfo extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = 4437553594659448579L;

    // 機構識別碼
    @ManyToOne
    @JoinColumn(name = "org_uuid")
    private Organization organization;

    // 機構名稱
    @Column(length = 255)
    private String orgName;

    // 機構英文名稱
    @Column(length = 255)
    private String orgNameEn;

    // 其他機構名稱
    @Column(length = 255)
    private String otherName;

    // 部門
    @Column(length = 100)
    private String college;

    // 單位
    @Column(length = 100)
    private String department;

    // 組別
    @Column(length = 100)
    private String groupType;

    // 國家代碼
    @Column(length = 5)
    private String countryCode;

    // 國家
    @Column(length = 50)
    private String country;

    // 城市代碼
    @Column(length = 5)
    private String cityCode;

    // 城市
    @Column(length = 50)
    private String city;

    // 郵遞區號
    @Column(length = 10)
    private String postcode;

    // 地址
    @Column(length = 255)
    private String addr;

    // 機構簡介
    @Type(type = "text")
    private String brief;

    // 成立年代
    @Column(length = 4)
    String foundingYear;

    // 官方網站
    @Column(length = 255)
    private String website;

    // Scopus機構連結
    @Column(length = 255)
    private String scopusUrl;

    // 相關報導連結
    @Type(type = "text")
    private String newsUrl;

    // 備註
    @Type(type = "text")
    private String notes;

    // 語系
    @ManyToOne
    @NotNull
    private Language language;

    // 資料發佈
    private Boolean authority;

    // 專長主題領域
    @Type(type = "text")
    String areaKnowledge;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;

}
