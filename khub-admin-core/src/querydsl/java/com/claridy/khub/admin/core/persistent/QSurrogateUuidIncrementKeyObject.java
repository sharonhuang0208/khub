package com.claridy.khub.admin.core.persistent;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSurrogateUuidIncrementKeyObject is a Querydsl query type for SurrogateUuidIncrementKeyObject
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QSurrogateUuidIncrementKeyObject extends EntityPathBase<SurrogateUuidIncrementKeyObject> {

    private static final long serialVersionUID = 1890706638L;

    public static final QSurrogateUuidIncrementKeyObject surrogateUuidIncrementKeyObject = new QSurrogateUuidIncrementKeyObject("surrogateUuidIncrementKeyObject");

    public final QPersistentObject _super = new QPersistentObject(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QSurrogateUuidIncrementKeyObject(String variable) {
        super(SurrogateUuidIncrementKeyObject.class, forVariable(variable));
    }

    public QSurrogateUuidIncrementKeyObject(Path<? extends SurrogateUuidIncrementKeyObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSurrogateUuidIncrementKeyObject(PathMetadata<?> metadata) {
        super(SurrogateUuidIncrementKeyObject.class, metadata);
    }

}

