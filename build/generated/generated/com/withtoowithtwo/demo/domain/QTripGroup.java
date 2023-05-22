package com.withtoowithtwo.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTripGroup is a Querydsl query type for TripGroup
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTripGroup extends EntityPathBase<TripGroup> {

    private static final long serialVersionUID = -1624062638L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTripGroup tripGroup = new QTripGroup("tripGroup");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<GroupUser, QGroupUser> members = this.<GroupUser, QGroupUser>createList("members", GroupUser.class, QGroupUser.class, PathInits.DIRECT2);

    public final QPost post;

    public final QPreference preference;

    public QTripGroup(String variable) {
        this(TripGroup.class, forVariable(variable), INITS);
    }

    public QTripGroup(Path<? extends TripGroup> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTripGroup(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTripGroup(PathMetadata metadata, PathInits inits) {
        this(TripGroup.class, metadata, inits);
    }

    public QTripGroup(Class<? extends TripGroup> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new QPost(forProperty("post"), inits.get("post")) : null;
        this.preference = inits.isInitialized("preference") ? new QPreference(forProperty("preference")) : null;
    }

}

