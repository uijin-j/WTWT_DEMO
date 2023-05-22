package com.withtoowithtwo.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPreference is a Querydsl query type for Preference
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreference extends EntityPathBase<Preference> {

    private static final long serialVersionUID = -123086877L;

    public static final QPreference preference = new QPreference("preference");

    public final EnumPath<com.withtoowithtwo.demo.domain.Enum.Gender> gender = createEnum("gender", com.withtoowithtwo.demo.domain.Enum.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> maxAge = createNumber("maxAge", Integer.class);

    public final NumberPath<Integer> minAge = createNumber("minAge", Integer.class);

    public QPreference(String variable) {
        super(Preference.class, forVariable(variable));
    }

    public QPreference(Path<? extends Preference> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPreference(PathMetadata metadata) {
        super(Preference.class, metadata);
    }

}

