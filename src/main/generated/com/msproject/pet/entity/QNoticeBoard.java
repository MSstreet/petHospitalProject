package com.msproject.pet.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNoticeBoard is a Querydsl query type for NoticeBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNoticeBoard extends EntityPathBase<NoticeBoard> {

    private static final long serialVersionUID = 2065096410L;

    public static final QNoticeBoard noticeBoard = new QNoticeBoard("noticeBoard");

    public final StringPath contents = createString("contents");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final BooleanPath deleteYn = createBoolean("deleteYn");

    public final BooleanPath display_yn = createBoolean("display_yn");

    public final NumberPath<Long> nboardId = createNumber("nboardId", Long.class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QNoticeBoard(String variable) {
        super(NoticeBoard.class, forVariable(variable));
    }

    public QNoticeBoard(Path<? extends NoticeBoard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNoticeBoard(PathMetadata metadata) {
        super(NoticeBoard.class, metadata);
    }

}

