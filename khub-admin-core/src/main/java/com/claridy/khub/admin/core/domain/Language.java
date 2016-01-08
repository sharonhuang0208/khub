package com.claridy.khub.admin.core.domain;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.claridy.khub.admin.core.persistent.SingleNaturalKeyObject;

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
public class Language extends SingleNaturalKeyObject<Locale> {

    private static final long serialVersionUID = 3411544997438414405L;

    // 活動類型
    @Column(length = 50)
    private String type;

    // 國碼
    @Column(length = 5)
    private String nationality;

    // 說明
    @Column(length = 100)
    private String description;

    // 顯示名稱
    @Column(length = 50)
    private String displayName;

}
