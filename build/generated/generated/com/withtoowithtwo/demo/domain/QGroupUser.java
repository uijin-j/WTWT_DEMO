package com.withtoowithtwo.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGroupUser is a Querydsl query type for GroupUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGroupUser extends EntityPathBase<GroupUser> {

    private static final long serialVersionUID = 1608213218L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGroupUser groupUser = new QGroupUser("groupUser");

    public final QTripGroup group;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QUser user;

    public QGroupUser(String variable) {
        this(GroupUser.class, forVariable(variable), INITS);
    }

    public QGroupUser(Path<? extends GroupUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGroupUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGroupUser(PathMetadata metadata, PathInits inits) {
        this(GroupUser.class, metadata, inits);
    }

    public QGroupUser(Class<? extends GroupUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.group = inits.isInitialized("group") ? new QTripGroup(forProperty("group"), inits.get("group")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

