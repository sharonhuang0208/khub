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
public class CurrentPostInfo extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = -6973895736859508606L;

    // 現職
    @ManyToOne
    @JoinColumn(name = "current_post_uuid")
    private CurrentPost currentPost;

    // 職稱代碼
    @Column(length = 5)
    private String jobTitle;

    // 聘任別代碼
    @Column(length = 5)
    private String engagement;

    // 行政職別代碼
    @Column(length = 5)
    private String administration;

    // 行政職稱
    @Column(length = 100)
    private String adminJobTitle;

    // 現職機構識別碼
    @ManyToOne
    @JoinColumn(name = "org_uuid")
    private Organization org;

    // 校內榮譽頭銜
    @Column(length = 50)
    private String honoraryTitle;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;
}
