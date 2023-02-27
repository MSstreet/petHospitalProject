package com.msproject.pet.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWishEntity is a Querydsl query type for WishEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWishEntity extends EntityPathBase<WishEntity> {

    private static final long serialVersionUID = 1368361470L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWishEntity wishEntity = new QWishEntity("wishEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final QPetHospitalEntity petHospitalEntity;

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final QUserEntity userEntity;

    public final NumberPath<Long> wishId = createNumber("wishId", Long.class);

    public final NumberPath<Integer> wishState1 = createNumber("wishState1", Integer.class);

    public QWishEntity(String variable) {
        this(WishEntity.class, forVariable(variable), INITS);
    }

    public QWishEntity(Path<? extends WishEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWishEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWishEntity(PathMetadata metadata, PathInits inits) {
        this(WishEntity.class, metadata, inits);
    }

    public QWishEntity(Class<? extends WishEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.petHospitalEntity = inits.isInitialized("petHospitalEntity") ? new QPetHospitalEntity(forProperty("petHospitalEntity")) : null;
        this.userEntity = inits.isInitialized("userEntity") ? new QUserEntity(forProperty("userEntity")) : null;
    }

}

