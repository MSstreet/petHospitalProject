package com.msproject.pet.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewEntity is a Querydsl query type for ReviewEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewEntity extends EntityPathBase<ReviewEntity> {

    private static final long serialVersionUID = -1422200081L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewEntity reviewEntity = new QReviewEntity("reviewEntity");

    public final BooleanPath approveYn = createBoolean("approveYn");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final BooleanPath deleteYn = createBoolean("deleteYn");

    public final NumberPath<Integer> effectScore = createNumber("effectScore", Integer.class);

    public final StringPath fileName = createString("fileName");

    public final StringPath hospitalName = createString("hospitalName");

    public final NumberPath<Integer> kindnessScore = createNumber("kindnessScore", Integer.class);

    public final StringPath originalFileName = createString("originalFileName");

    public final QPetHospitalEntity petHospitalEntity;

    public final NumberPath<Integer> priceScore = createNumber("priceScore", Integer.class);

    public final NumberPath<Long> reviewId = createNumber("reviewId", Long.class);

    public final NumberPath<Float> score = createNumber("score", Float.class);

    public final NumberPath<Float> tmpScore = createNumber("tmpScore", Float.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final QUserEntity userEntity;

    public QReviewEntity(String variable) {
        this(ReviewEntity.class, forVariable(variable), INITS);
    }

    public QReviewEntity(Path<? extends ReviewEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewEntity(PathMetadata metadata, PathInits inits) {
        this(ReviewEntity.class, metadata, inits);
    }

    public QReviewEntity(Class<? extends ReviewEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.petHospitalEntity = inits.isInitialized("petHospitalEntity") ? new QPetHospitalEntity(forProperty("petHospitalEntity")) : null;
        this.userEntity = inits.isInitialized("userEntity") ? new QUserEntity(forProperty("userEntity")) : null;
    }

}

