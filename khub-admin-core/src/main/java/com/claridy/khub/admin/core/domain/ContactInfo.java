package com.claridy.khub.admin.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;

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
public class ContactInfo extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = 129079056989047289L;

    //聯絡人識別碼
    @ManyToOne
    @JoinColumn(name="contact_uuid")
    private Contact contact;

    // 聯絡人姓名
    @Column(length = 100)
    private String name;

    // 職稱
    @Column(length = 100)
    private String jobTitle;

    // 聯絡電話
    @Column(length = 20)
    private String phoneNumber;

    // 傳真電話
    @Column(length = 20)
    private String faxNumber;

    // EMAIL
    @Email
    @Column(length = 200)
    private String email;

    // 語系
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
