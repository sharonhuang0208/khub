package com.claridy.khub.admin.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Nationality extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = 8668027220980983658L;

    // 國籍代碼
    @Column(length = 2)
    @NotNull
    private String code;

    // 國籍中文名稱
    @Column(length = 100)
    private String ch;

    // 國籍英文名稱
    @Column(length = 100)
    private String en;
}
