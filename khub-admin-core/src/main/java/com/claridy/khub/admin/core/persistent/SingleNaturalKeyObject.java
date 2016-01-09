package com.claridy.khub.admin.core.persistent;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * provide a single natural key base entity class. it has a generic type of
 * poid. the client have to assign the poid manually in order to maintain the
 * primary key self.
 * <p>
 * </p>
 * <p>
 * 因此繼承這個類別之後，通常必需要做下面兩件事情：<br/>
 * 1. 在類別前宣告override poid的JPA mapping屬性：<br/>
 * 如：<br/>
 * <pre>
 * &#64;Entity
 * &#64;Table(name = "SubdivForm")
 * &#64;AttributeOverride(name = "poid", column = &#64;Column(name = "FormCode", length = 8, nullable = false))
 * public class SubdivisionForm extends PersistentObject&lt;String&rt; {
 *    // ....
 * }
 * </pre>
 * 2. 宣告一組有意義的PK的getter/setter，提供方便的存取。<br/>
 * 如：<br/>
 * <pre>
 * &#64;Entity
 * &#64;Table(name = "SubdivForm")
 * &#64;AttributeOverride(name = "poid", column = &#64;Column(name = "FormCode", length = 8, nullable = false))
 * public class SubdivisionForm extends PersistentObject&lt;String&rt; {
 *    // ....
 *
 *    &#64;Transient
 *    public String getFormCode() {
 *    	return getPoid();
 *    }
 *
 *    public void setFormCode(String code) {
 *    	setPoid(code);
 *    }
 * }<br/>
 * </pre>
 * </p>
 *
 * @author Anthony Wang
 *
 * @param <K>
 *            poid的型別，因為使用natural key作為poid，因此實作時必須自行指定poid的型別。
 *            <p>
 *            例如 ?????
 *            </p>
 */
@MappedSuperclass
public abstract class SingleNaturalKeyObject<K extends Serializable> extends
        PersistentObject<K> {

    private static final long serialVersionUID = 1976237878603557487L;

    @Id
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
