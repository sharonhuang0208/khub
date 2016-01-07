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
public class AttendingPeople extends SurrogateUuidKeyObject {

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

    // 人員識別碼
    @ManyToOne
    @JoinColumn(name="people_uuid")
    private People people;

    // 排序
    private Integer seq;

    // 全名
    @Column(length = 100)
    private String fullName;

    // 英文全名
    @Column(length = 100)
    private String fullNameEn;

    // 姓
    @Column(length = 50)
    private String lastName;

    // 名
    @Column(length = 50)
    private String firstName;

    // 英文姓
    @Column(length = 50)
    private String lastNameEn;

    // 英文名
    @Column(length = 50)
    private String firstNameEn;

    // 資料語系
    @Column(length = 5)
    private String language;

    // 通訊作者地
    @Column(length = 50)
    private String departmentAddr;

    // 通訊作者信箱
    @Column(length = 200)
    private String email;

    // 清大作者是否為通訊作者
    private Boolean isCorrespondingAuthor;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;


}
