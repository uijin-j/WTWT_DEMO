package com.withtoowithtwo.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBirthday is a Querydsl query type for Birthday
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QBirthday extends BeanPath<Birthday> {

    private static final long serialVersionUID = -1601855611L;

    public static final QBirthday birthday = new QBirthday("birthday");

    public final StringPath BDay = createString("BDay");

    public final StringPath bDay = createString("bDay");

    public final StringPath BMonth = createString("BMonth");

    public final StringPath bMonth = createString("bMonth");

    public final StringPath BYear = createString("BYear");

    public final StringPath bYear = createString("bYear");

    public QBirthday(String variable) {
        super(Birthday.class, forVariable(variable));
    }

    public QBirthday(Path<? extends Birthday> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBirthday(PathMetadata metadata) {
        super(Birthday.class, metadata);
    }

}

