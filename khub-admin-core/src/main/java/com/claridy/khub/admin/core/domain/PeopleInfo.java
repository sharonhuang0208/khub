package com.claridy.khub.admin.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
public class PeopleInfo extends SurrogateUuidKeyObject {


    private static final long serialVersionUID = 3161612278393844704L;

    //全名
    @Column(length = 100)
    private String fullName;

    //英文全名
    @Column(length = 100)
    private String fullNameEn;

    //姓
    @Column(length = 50)
    private String lastName;

    //名
    @Column(length = 50)
    private String firstName;

    //其他名
    @Column(length = 255)
    private String otherName;

    //英文姓
    @Column(length = 50)
    private String lastNameEn;

    //英文名
    @Column(length = 50)
    private String firstNameEn;

    //其他英文名
    @Column(length = 255)
    private String otherNameEn;

    //人物多重英文姓名表示法
    @Column(length = 255)
    private String nameVariant;

    //email
    @Type(type="text")
    private String email;

    //個人網頁
    @Type(type="text")
    private String website;

    //研究室
    @Type(type="text")
    private String lab;

    //Scopus作者連結
    @Column(length = 100)
    private String scopusAuthorLink;

    //研究領域
    @Type(type="text")
    private String researchArea;

    //機構典藏
    @Column(length = 255)
    private String nthurLink;

    //備註
    @Type(type="text")
    private String notes;

    //語系
    @Column(length = 5)
    private String language;

    //資料發佈
    private Boolean authority;

    //國籍代碼
    @Column(length = 2)
    private String nationalityCode;

    //人員/人事資料識別碼
    @ManyToOne
    @JoinColumn(name="people_uuid")
    private People people;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;
}
