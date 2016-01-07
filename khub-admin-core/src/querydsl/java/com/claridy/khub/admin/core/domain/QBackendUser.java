package com.claridy.khub.admin.core.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBackendUser is a Querydsl query type for BackendUser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBackendUser extends EntityPathBase<BackendUser> {

    private static final long serialVersionUID = 1513631640L;

    public static final QBackendUser backendUser = new QBackendUser("backendUser");

    public final com.claridy.khub.admin.core.persistent.QSurrogateUuidKeyObject _super = new com.claridy.khub.admin.core.persistent.QSurrogateUuidKeyObject(this);

    public final StringPath accountId = createString("accountId");

    public final StringPath contactTel = createString("contactTel");

    public final StringPath createdBy = createString("createdBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final EnumPath<com.claridy.khub.admin.core.enums.PermissionEnum> dataPermissionLevel = createEnum("dataPermissionLevel", com.claridy.khub.admin.core.enums.PermissionEnum.class);

    public final StringPath email = createString("email");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final SetPath<Role, QRole> roleSet = this.<Role, QRole>createSet("roleSet", Role.class, QRole.class, PathInits.DIRECT2);

    public final EnumPath<com.claridy.khub.admin.core.enums.StatusEnum> status = createEnum("status", com.claridy.khub.admin.core.enums.StatusEnum.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QBackendUser(String variable) {
        super(BackendUser.class, forVariable(variable));
    }

    public QBackendUser(Path<? extends BackendUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBackendUser(PathMetadata<?> metadata) {
        super(BackendUser.class, metadata);
    }

}

