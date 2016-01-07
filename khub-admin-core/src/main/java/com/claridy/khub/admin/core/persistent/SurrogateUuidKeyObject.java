package com.claridy.khub.admin.core.persistent;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * base class for persistent entity class that using a UUID generation strategy
 * surrogate key as primary key. the property <code>poid</code> is the surrogate
 * key column, and value will be generated automatically.
 * <p>
 * the UUID key would be generated automatically when persisting by under laying
 * persistence framework.
 * </p>
 * <p>
 * 直接繼承這個類別，並實作Entity應有的屬性。poid與id mapping會自動處理。
 * </p>
 *
 * @author Anthony Wang
 *
 */
@MappedSuperclass
public abstract class SurrogateUuidKeyObject extends PersistentObject<String> {

    private static final long serialVersionUID = 1222219553414982105L;

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "uuid")
    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}