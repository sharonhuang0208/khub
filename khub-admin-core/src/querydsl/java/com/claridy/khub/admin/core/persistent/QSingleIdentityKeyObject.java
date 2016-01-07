package com.claridy.khub.admin.core.persistent;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSingleIdentityKeyObject is a Querydsl query type for SingleIdentityKeyObject
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QSingleIdentityKeyObject extends EntityPathBase<SingleIdentityKeyObject<? extends java.io.Serializable>> {

    private static final long serialVersionUID = -1999929116L;

    public static final QSingleIdentityKeyObject singleIdentityKeyObject = new QSingleIdentityKeyObject("singleIdentityKeyObject");

    public final QPersistentObject _super = new QPersistentObject(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final SimplePath<java.io.Serializable> id = createSimple("id", java.io.Serializable.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    @SuppressWarnings("all")
    public QSingleIdentityKeyObject(String variable) {
        super((Class)SingleIdentityKeyObject.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QSingleIdentityKeyObject(Path<? extends SingleIdentityKeyObject> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    @SuppressWarnings("all")
    public QSingleIdentityKeyObject(PathMetadata<?> metadata) {
        super((Class)SingleIdentityKeyObject.class, metadata);
    }

}

