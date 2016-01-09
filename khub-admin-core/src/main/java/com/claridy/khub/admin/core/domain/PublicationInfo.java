package com.claridy.khub.admin.core.domain;

import java.time.LocalDateTime;

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
public class PublicationInfo extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = -747345233633367249L;

    // 資料語系
    @ManyToOne
    @NotNull
    private Language language;

    // 文章編號
    @Column(length = 50)
    private String articleNumber;

    // 作者數
    private Integer authorAmt;

    // 電子識別碼
    @Column(length = 50)
    private String electronicId;

    // 其他題名
    @Column(length = 255)
    private String otherTitle;

    // 其他英文題名
    @Column(length = 255)
    private String otherTitleEn;

    // 機構典藏編號
    @Column(length = 50)
    private String sysid;

    // 題名
    @Column(length = 255)
    private String title;

    // 英文題名
    @Column(length = 255)
    private String titleEn;

    // 文獻類型
    @Column(length = 50)
    private String type;

    // 資料發佈
    private Boolean authority;

    // 來源出處
    @Column(length = 255)
    private String citation;

    // 來源題名
    @Column(length = 255)
    private String sourceTitle;

    // 來源題名縮寫
    @Column(length = 255)
    private String abbreviatedSourceTitle;

    // 卷
    @Column(length = 50)
    private String volume;

    // 期
    @Column(length = 50)
    private String issue;

    // 起頁
    private Integer firstpage;

    // 迄頁
    private Integer lastpage;

    // 頁碼計數
    private Integer pageCount;

    // 集代碼
    @Column(length = 50)
    private String collectionId;

    // 集
    @Column(length = 50)
    private String collection;

    // 版
    @Column(length = 50)
    private String edition;

    // 特別期號
    @Column(length = 50)
    private String specialIssue;

    // WOS書籍章節計數器
    private Integer wosBookChapterCount;

    // 出版者
    @Column(length = 50)
    private String publisher;

    // 出版地
    @Column(length = 50)
    private String publicationPlace;

    // 出版年
    @Column(length = 4)
    private String publicationYear;

    // 出版月
    @Column(length = 2)
    private String publicationMonth;

    // 出版日
    @Column(length = 2)
    private String publicationDay;

    // 補充說明
    @Type(type = "text")
    private String notes;

    // 文獻類型代碼
    @Column(length = 5)
    private String publicationTypeCode;

    // khub文獻類型代碼
    @Column(length = 5)
    private String khubPublicationTypeCode;

    // 經費來源
    @Column(length = 50)
    private String foundingSource;

    // 經費用途
    @Column(length = 50)
    private String funcingPurposes;

    // 發表形式
    @Column(length = 50)
    private String media;

    // pdf保全不保全
    private Boolean pdfSecurity;

    // 是否被翻譯
    private Boolean hasTranslated;

    // ISSN
    @Column(length = 50)
    private String issn;

    // ISBN
    @Column(length = 20)
    private String isbn;

    // CODEN
    @Column(length = 50)
    private String coden;

    // PubMed ID
    @Column(length = 50)
    private String pubMedId;

    // EID
    @Column(length = 50)
    private String eid;

    // WOS文章編號
    @Column(length = 50)
    private String wosArticleNumber;

    // Scopus出版品識別碼
    @Column(length = 50)
    private String scopusPublicationId;

    // 著作權聲明
    @Type(type = "text")
    private String copyright;

    // 創用cc
    @Column(length = 50)
    private String cc;

    // 取用權是否開放
    private Integer accessRight;

    // 開放取用權日期
    private LocalDateTime accessRightDate;

    // 來源資料庫代碼
    @Column(length = 5)
    private String dbSourceAutoCode;

    // 下載次數
    private Integer recordStatus;

    // 備註
    @Type(type = "text")
    private String remark;

    // 來源連結
    @Column(length = 200)
    private String sourceLink;

    // 是否經過審查
    private Boolean peerReview;

    // 原文獻語言
    @Column(length = 5)
    private String languageOrg;

    // 摘要連結
    @Column(length = 255)
    private String scopusAbstractUrl;

    // 相關連結
    @Type(type = "text")
    private String relatedLink;

    // DOI連結
    @Column(length = 255)
    private String doi;

    // NTHUR URL
    @Type(type = "text")
    private String nthurUrl;

    // 化學物質/CAS
    @Column(length = 255)
    private String chemicalsCas;

    // 商標
    @Column(length = 50)
    private String tradenames;

    // 製造商
    @Column(length = 50)
    private String manufacturers;

    // WOS相關紀錄
    @Type(type = "text")
    private String wosRelatedRecords;

    // Scopus引用連結
    @Column(length = 255)
    private String scopusCitedByUrl;

    // Google Scholar連結
    @Column(length = 255)
    private String googleScholarUrl;

    // 摘要
    @Type(type = "text")
    @Column(name = "abstract")
    private String abstractCn;

    // 英文摘要
    @Type(type = "text")
    private String abstractEn;

    // 參考文獻
    @Type(type = "text")
    private String refs;

    // 關鍵字
    @Column(length = 255)
    private String reservationKeywords;

    // 英文關鍵字
    @Column(length = 255)
    private String reservationKeywordsEn;

    // 作者關鍵字
    @Column(length = 255)
    private String authorKeywords;

    // 加碼關鍵字
    @Column(length = 255)
    private String keywordPlus;

    // 索引關鍵字
    @Column(length = 255)
    private String indexKeywords;

    // 學科領域(scopus)
    @Type(type = "text")
    private String subjectScopus;

    // 學科領域(WOS)
    @Type(type = "text")
    private String subjectWos;

    // scopus引用數
    private Integer scopusReferencesCnt;

    // scopus被引用數
    private Integer scopusCitedTimes;

    // Scopus是否為高被引文章
    private Boolean scopusIsHighCited;

    // wos引用數
    private Integer wosReferencesCnt;

    // wos被引用數
    private Integer wosCitedTimes;

    // wos是否為高被引文章
    private Boolean wosIsHighCited;

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
