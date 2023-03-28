package com.msproject.pet.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardReply is a Querydsl query type for BoardReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardReply extends EntityPathBase<BoardReply> {

    private static final long serialVersionUID = -1214122440L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardReply boardReply = new QBoardReply("boardReply");

    public final QBoardEntity boardEntity;

    public final ListPath<BoardReply, QBoardReply> children = this.<BoardReply, QBoardReply>createList("children", BoardReply.class, QBoardReply.class, PathInits.DIRECT2);

    public final StringPath contents = createString("contents");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final BooleanPath deleteYn = createBoolean("deleteYn");

    public final QBoardReply parent;

    public final NumberPath<Long> replyIdx = createNumber("replyIdx", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final QUserEntity userEntity;

    public QBoardReply(String variable) {
        this(BoardReply.class, forVariable(variable), INITS);
    }

    public QBoardReply(Path<? extends BoardReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardReply(PathMetadata metadata, PathInits inits) {
        this(BoardReply.class, metadata, inits);
    }

    public QBoardReply(Class<? extends BoardReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.boardEntity = inits.isInitialized("boardEntity") ? new QBoardEntity(forProperty("boardEntity"), inits.get("boardEntity")) : null;
        this.parent = inits.isInitialized("parent") ? new QBoardReply(forProperty("parent"), inits.get("parent")) : null;
        this.userEntity = inits.isInitialized("userEntity") ? new QUserEntity(forProperty("userEntity")) : null;
    }

}

