package com.claridy.khub.admin.core.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = -1119574147L;

    public static final QRole role = new QRole("role");

    public final com.claridy.khub.admin.core.persistent.QSurrogateUuidKeyObject _super = new com.claridy.khub.admin.core.persistent.QSurrogateUuidKeyObject(this);

    public final SetPath<BackendUser, QBackendUser> backendUserSet = this.<BackendUser, QBackendUser>createSet("backendUserSet", BackendUser.class, QBackendUser.class, PathInits.DIRECT2);

    public final StringPath createdBy = createString("createdBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final StringPath description = createString("description");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final StringPath name = createString("name");

    public final ListPath<Resource, QResource> resourceList = this.<Resource, QResource>createList("resourceList", Resource.class, QResource.class, PathInits.DIRECT2);

    public final NumberPath<Integer> seq = createNumber("seq", Integer.class);

    public final EnumPath<com.claridy.khub.admin.core.enums.StatusEnum> status = createEnum("status", com.claridy.khub.admin.core.enums.StatusEnum.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata<?> metadata) {
        super(Role.class, metadata);
    }

}

