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
public class Member extends SurrogateUuidKeyObject {


    private static final long serialVersionUID = -7304115401048088158L;

    //KHUB入口網帳號
    @Column(length = 200)
    private String accountId;

    //全名
    @Column(length = 100)
    private String fullName;

    //英文全名
    @Column(length = 100)
    private String fullNameEn;

    //維護對象ID
    @Column(length = 50)
    private String idNo;

    //人員/人事資料識別碼
    @ManyToOne
    @JoinColumn(name="people_uuid")
    private People people;

    //職稱
    @Column(length = 50)
    private String jobTitle;

    //機構種類
    private Integer organizationType;

    //機構名稱
    @Column(length = 200)
    private String organizationName;

    //機構代碼
    @Column(length = 50)
    private String organizationId;

    //部門
    @Column(length = 100)
    private String department;

    //學院
    @Column(length = 100)
    private String college;

    //大學
    @Column(length = 100)
    private String university;

    //城市
    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String state;

    //國家
    @Column(length = 100)
    private String country;

    //國家代碼
    @Column(length = 10)
    private String countryCode;

    //會員狀態
    @Type(type = "com.claridy.khub.admin.core.hibernate.StatusEnumValueUserType")
    @Column(length = 1, nullable = false)
    private StatusEnum status;

    @ManyToMany(mappedBy = "members")
    private Set<BackendUser> backendUsers = new HashSet<BackendUser>();

    //
    @Column(length = 50)
    private String lang;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;

}
