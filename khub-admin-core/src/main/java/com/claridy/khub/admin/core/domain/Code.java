package com.claridy.khub.admin.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

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
@Table(uniqueConstraints=
@UniqueConstraint(columnNames={"type", "code", "language_id"}))
@DynamicUpdate(value = true)
public class Code extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = -7578515473005617844L;

    //代碼類型
    @NotNull
    private Integer type;

    // 代碼類型說明
    @Column(length = 255)
    private String typeDesc;

    // 代碼
    @Column(length = 5)
    @NotNull
    private String code;

    // 代碼說明
    @Column(length = 255)
    private String description;

    //語系
    @ManyToOne
    @NotNull
    private Language language;

    //狀態
    @Type(type = "com.claridy.khub.admin.core.hibernate.StatusEnumValueUserType")
    @Column(length = 1, nullable = false)
    private StatusEnum status;

    //排序
    private Integer seq;

}
