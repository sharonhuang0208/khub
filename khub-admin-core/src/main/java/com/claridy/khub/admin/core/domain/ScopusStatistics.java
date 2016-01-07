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
public class ScopusStatistics extends SurrogateUuidKeyObject {


    private static final long serialVersionUID = -7528615682114427481L;

    //人員/人事資料識別碼
    @ManyToOne
    @JoinColumn(name="people_uuid")
    private People people;

    // 論文數
    private Integer ublicationsNum;

    //被引用數
    private Integer sumTimesCited;

    // 平均被引用數
    private Integer avgCitationsPerArticle;

    // 合著者數
    private Integer coauthorsNum;

    // H指數
    private Integer hIndex;

    // 高被引論文數
    private Integer hSumTimesCited;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;
}
