package com.claridy.khub.admin.core.persistent;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSurrogateUuidKeyObject is a Querydsl query type for SurrogateUuidKeyObject
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QSurrogateUuidKeyObject extends EntityPathBase<SurrogateUuidKeyObject> {

    private static final long serialVersionUID = -2093054305L;

    public static final QSurrogateUuidKeyObject surrogateUuidKeyObject = new QSurrogateUuidKeyObject("surrogateUuidKeyObject");

    public final QPersistentObject _super = new QPersistentObject(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final StringPath id = createString("id");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QSurrogateUuidKeyObject(String variable) {
        super(SurrogateUuidKeyObject.class, forVariable(variable));
    }

    public QSurrogateUuidKeyObject(Path<? extends SurrogateUuidKeyObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSurrogateUuidKeyObject(PathMetadata<?> metadata) {
        super(SurrogateUuidKeyObject.class, metadata);
    }

}

