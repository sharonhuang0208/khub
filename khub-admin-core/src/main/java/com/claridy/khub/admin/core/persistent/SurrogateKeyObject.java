package com.claridy.khub.admin.core.persistent;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * base class for persistent entity class that using surrogate key as primary
 * key. the property <code>poid</code> is the surrogate key column, and value
 * should be generated automatically.
 * <p>
 * 直接繼承這個類別，並實作Entity應有的屬性。poid與id mapping會自動處理。
 * </p>
 *
 * @author Anthony Wang
 *
 */
@MappedSuperclass
public abstract class SurrogateKeyObject extends PersistentObject<Long> {

    private static final long serialVersionUID = -3267890206972634665L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
