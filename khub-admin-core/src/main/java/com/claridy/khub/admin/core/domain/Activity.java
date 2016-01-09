package com.claridy.khub.admin.core.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Activity extends SurrogateUuidKeyObject {

    private static final long serialVersionUID = -7578515473005617844L;

    // 活動類型
    @Column(length = 50)
    private String type;

    @ManyToMany
    @JoinTable(name = "related_activity_map", joinColumns = {
            @JoinColumn(name = "activity_uuid") }, inverseJoinColumns = { @JoinColumn(name = "related_activity_uuid") })
    private Set<Activity> activities = new HashSet<Activity>();

    public void addActivity(Activity activity) {
        if (!activities.contains(activity)) {
            activities.add(activity);
            activity.addActivity(this);
        }
    }

    public void removeActivity(Activity activity) {
        if (activities.contains(activity)) {
            activities.remove(activity);
            activity.removeActivity(this);
        }
    }

}
