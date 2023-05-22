package com.withtoowithtwo.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -1433217440L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final StringPath comment = createString("comment");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.withtoowithtwo.demo.domain.Enum.Personality, EnumPath<com.withtoowithtwo.demo.domain.Enum.Personality>> personality = this.<com.withtoowithtwo.demo.domain.Enum.Personality, EnumPath<com.withtoowithtwo.demo.domain.Enum.Personality>>createList("personality", com.withtoowithtwo.demo.domain.Enum.Personality.class, EnumPath.class, PathInits.DIRECT2);

    public final NumberPath<Integer> rate = createNumber("rate", Integer.class);

    public final ListPath<com.withtoowithtwo.demo.domain.Enum.TripStyle, EnumPath<com.withtoowithtwo.demo.domain.Enum.TripStyle>> tripStyle = this.<com.withtoowithtwo.demo.domain.Enum.TripStyle, EnumPath<com.withtoowithtwo.demo.domain.Enum.TripStyle>>createList("tripStyle", com.withtoowithtwo.demo.domain.Enum.TripStyle.class, EnumPath.class, PathInits.DIRECT2);

    public final QUser user;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

