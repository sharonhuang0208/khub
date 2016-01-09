package com.claridy.khub.admin.core.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

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
public class ConferenceInfo extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = -3573740335049329940L;

    // 資料語系
    @ManyToOne
    @NotNull
    private Language language;

    // 會議代碼
    @Column(length = 50)
    private String conferenceId;

    // 會議性質
    @Column(length = 5)
    private String typeCode;

    // 會議名稱
    @Column(length = 255)
    private String name;

    // 會議英文名稱
    @Column(length = 255)
    private String nameEn;

    // 會議地點城市代碼
    @Column(length = 5)
    private String cityCode;

    // 會議地點城市名稱
    @Column(length = 50)
    private String city;

    // 會議地點州\省代碼
    @Column(length = 5)
    private String stateCode;

    // 會議地點州\省名稱
    @Column(length = 50)
    private String state;

    // 會議地點國家代碼
    @Column(length = 5)
    private String countryCode;

    // 會議地點國家名稱
    @Column(length = 50)
    private String country;

    // 會議地點郵遞區號
    @Column(length = 10)
    private String postcode;

    // 會議開始日期
    private LocalDate startDate;

    // 會議結束日期
    private LocalDate endDate;

    // 經費來源
    @Column(length = 30)
    private String foundingSource;

    // 資料發佈
    private Boolean authority;

    // 會議舉辦學年度
    @Column(length = 5)
    private String schoolYear;

    // WOS會議代碼
    @Column(length = 50)
    private String wosConferenceId;

    // WOS完整資訊
    @Column(length = 255)
    private String wosFullInfo;

    // WOS會議摘要代碼
    @Column(length = 50)
    private String wosAbstractNumber;

    // 備註
    @Type(type = "text")
    private String remark;

    // 會議摘要
    @Type(type = "text")
    private String meetingAbstract;

    // 活動識別碼
    @ManyToOne
    @JoinColumn(name = "activity_uuid")
    private Activity activity;

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;

}
