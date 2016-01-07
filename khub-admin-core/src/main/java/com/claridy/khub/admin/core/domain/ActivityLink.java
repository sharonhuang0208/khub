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
public class ActivityLink extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = 6714696834152454591L;

    // 參與活動類型
    @Column(length = 20)
    String activityType;

    // 參與活動識別碼
    @ManyToOne
    @JoinColumn(name = "activity_uuid")
    Activity activity;

    // 連結名稱
    @Column(length = 255)
    String name;

    // URL
    @Column(length = 255)
    String url;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;

}
