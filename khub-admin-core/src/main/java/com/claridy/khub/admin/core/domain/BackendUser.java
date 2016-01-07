package com.claridy.khub.admin.core.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;

import com.claridy.khub.admin.core.enums.PermissionEnum;
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
@Table
@DynamicUpdate(value = true)
public class BackendUser extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = -7578515473005617844L;

    // 登入帳號
    @Column(length = 200)
    private String accountId;

    // 密碼
    @Column(length = 50)
    private String password;

    // 姓名
    @Column(length = 50)
    private String name;

    // 電子郵件
    @Email
    @Column(length = 200)
    private String email;

    // 聯絡電話
    @Column(length = 50)
    private String contactTel;

    // 狀態 0:INACTIVE 1:ACTIVE
    @Type(type = "com.claridy.khub.admin.core.hibernate.StatusEnumValueUserType")
    @Column(length = 1, nullable = false)
    private StatusEnum status;

    // 資料維護權限層級 0:一般 1:全部
    @Type(type = "com.claridy.khub.admin.core.hibernate.PermissionEnumValueUserType")
    @Column(length = 1, nullable = false)
    private  PermissionEnum dataPermissionLevel;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "user_role_map", joinColumns = { @JoinColumn(name = "user_uuid") }, inverseJoinColumns = {
            @JoinColumn(name = "role_uuid") })
    private Set<Role> roles = new HashSet<Role>();

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "user_data_permission", joinColumns = { @JoinColumn(name = "user_uuid") }, inverseJoinColumns = {
            @JoinColumn(name = "member_uuid") })
    private Set<Member> members = new HashSet<Member>();

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "org_data_permission", joinColumns = { @JoinColumn(name = "user_uuid") }, inverseJoinColumns = {
            @JoinColumn(name = "org_uuid") })
    private Set<Organization> orgs = new HashSet<Organization>();

    // 建立者
    @Column(length = 200)
    private String createdBy;

    // 最後修改者
    @Column(length = 200)
    private String lastModifiedBy;

}
