package com.claridy.khub.admin.core.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QResource is a Querydsl query type for Resource
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QResource extends EntityPathBase<Resource> {

    private static final long serialVersionUID = -1355673707L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResource resource = new QResource("resource");

    public final com.claridy.khub.admin.core.persistent.QSurrogateUuidKeyObject _super = new com.claridy.khub.admin.core.persistent.QSurrogateUuidKeyObject(this);

    public final QApplication application;

    public final StringPath createdBy = createString("createdBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final StringPath description = createString("description");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final StringPath name = createString("name");

    public final QResource parent;

    public final StringPath restriction = createString("restriction");

    public final SetPath<Role, QRole> roleSet = this.<Role, QRole>createSet("roleSet", Role.class, QRole.class, PathInits.DIRECT2);

    public final EnumPath<com.claridy.khub.admin.core.enums.StatusEnum> status = createEnum("status", com.claridy.khub.admin.core.enums.StatusEnum.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public final StringPath url = createString("url");

    public QResource(String variable) {
        this(Resource.class, forVariable(variable), INITS);
    }

    public QResource(Path<? extends Resource> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QResource(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QResource(PathMetadata<?> metadata, PathInits inits) {
        this(Resource.class, metadata, inits);
    }

    public QResource(Class<? extends Resource> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.application = inits.isInitialized("application") ? new QApplication(forProperty("application")) : null;
        this.parent = inits.isInitialized("parent") ? new QResource(forProperty("parent"), inits.get("parent")) : null;
    }

}

