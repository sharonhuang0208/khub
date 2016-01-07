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
public class Photo extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = 6443526825475914497L;

    //人員/人事資料識別碼
    @ManyToOne
    @JoinColumn(name="people_uuid")
    private People people;

    // 順序
    private Integer seq;

    //檔案名稱
    @Column(length=50)
    private String fileName;

    // 檔案路徑
    @Column(length=50)
    private String filePath;

    // 連結位址
    @Column(length=50)
    private String url;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;
}
