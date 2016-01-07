package com.claridy.khub.admin.core.persistent;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSurrogateKeyObject is a Querydsl query type for SurrogateKeyObject
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QSurrogateKeyObject extends EntityPathBase<SurrogateKeyObject> {

    private static final long serialVersionUID = -1316256230L;

    public static final QSurrogateKeyObject surrogateKeyObject = new QSurrogateKeyObject("surrogateKeyObject");

    public final QPersistentObject _super = new QPersistentObject(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QSurrogateKeyObject(String variable) {
        super(SurrogateKeyObject.class, forVariable(variable));
    }

    public QSurrogateKeyObject(Path<? extends SurrogateKeyObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSurrogateKeyObject(PathMetadata<?> metadata) {
        super(SurrogateKeyObject.class, metadata);
    }

}

