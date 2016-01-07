package com.claridy.khub.admin.core.persistent;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSingleNaturalKeyObject is a Querydsl query type for SingleNaturalKeyObject
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QSingleNaturalKeyObject extends EntityPathBase<SingleNaturalKeyObject<? extends java.io.Serializable>> {

    private static final long serialVersionUID = 260333137L;

    public static final QSingleNaturalKeyObject singleNaturalKeyObject = new QSingleNaturalKeyObject("singleNaturalKeyObject");

    public final QPersistentObject _super = new QPersistentObject(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final SimplePath<java.io.Serializable> id = createSimple("id", java.io.Serializable.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    @SuppressWarnings("all")
    public QSingleNaturalKeyObject(String variable) {
        super((Class)SingleNaturalKeyObject.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QSingleNaturalKeyObject(Path<? extends SingleNaturalKeyObject> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    @SuppressWarnings("all")
    public QSingleNaturalKeyObject(PathMetadata<?> metadata) {
        super((Class)SingleNaturalKeyObject.class, metadata);
    }

}

