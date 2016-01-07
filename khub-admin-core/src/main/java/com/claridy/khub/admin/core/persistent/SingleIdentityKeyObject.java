package com.claridy.khub.admin.core.persistent;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SingleIdentityKeyObject<K extends Serializable> extends
        PersistentObject<K> {

    private static final long serialVersionUID = 3407555439305320958L;

    /*由DB自動產生primary key*/
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    @Column(name = "id")
    private K id;

    @Override
    public K getId() {
        return id;
    }

    @Override
    public void setId(K id) {
        this.id = id;
    }

}
