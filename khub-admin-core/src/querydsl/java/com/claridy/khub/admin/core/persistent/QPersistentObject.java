package com.claridy.khub.admin.core.persistent;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPersistentObject is a Querydsl query type for PersistentObject
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QPersistentObject extends EntityPathBase<PersistentObject<? extends java.io.Serializable>> {

    private static final long serialVersionUID = 626894154L;

    public static final QPersistentObject persistentObject = new QPersistentObject("persistentObject");

    public final DateTimePath<java.time.LocalDateTime> createdTime = createDateTime("createdTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updatedTime = createDateTime("updatedTime", java.time.LocalDateTime.class);

    @SuppressWarnings("all")
    public QPersistentObject(String variable) {
        super((Class)PersistentObject.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QPersistentObject(Path<? extends PersistentObject> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    @SuppressWarnings("all")
    public QPersistentObject(PathMetadata<?> metadata) {
        super((Class)PersistentObject.class, metadata);
    }

}

