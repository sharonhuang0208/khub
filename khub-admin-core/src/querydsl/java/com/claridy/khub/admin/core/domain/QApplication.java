package com.claridy.khub.admin.core.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QApplication is a Querydsl query type for Application
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QApplication extends EntityPathBase<Application> {

    private static final long serialVersionUID = -978110359L;

    public static final QApplication application = new QApplication("application");

    public final com.claridy.khub.admin.core.persistent.QSurrogateUuidKeyObject _super = new com.claridy.khub.admin.core.persistent.QSurrogateUuidKeyObject(this);

    public final StringPath createdBy = createString("createdBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final StringPath description = createString("description");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QApplication(String variable) {
        super(Application.class, forVariable(variable));
    }

    public QApplication(Path<? extends Application> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApplication(PathMetadata<?> metadata) {
        super(Application.class, metadata);
    }

}

