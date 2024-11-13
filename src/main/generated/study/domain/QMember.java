package study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1922242495L;

    public static final QMember member = new QMember("member1");

    public final study.domain.common.QBaseEntity _super = new study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DatePath<java.time.LocalDate> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<study.domain.enums.Gender> gender = createEnum("gender", study.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<study.domain.mapping.MemberAgree, study.domain.mapping.QMemberAgree> memberAgreeList = this.<study.domain.mapping.MemberAgree, study.domain.mapping.QMemberAgree>createList("memberAgreeList", study.domain.mapping.MemberAgree.class, study.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<study.domain.mapping.MemberMission, study.domain.mapping.QMemberMission> memberMissionList = this.<study.domain.mapping.MemberMission, study.domain.mapping.QMemberMission>createList("memberMissionList", study.domain.mapping.MemberMission.class, study.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<study.domain.mapping.MemberPrefer, study.domain.mapping.QMemberPrefer> memberPreferList = this.<study.domain.mapping.MemberPrefer, study.domain.mapping.QMemberPrefer>createList("memberPreferList", study.domain.mapping.MemberPrefer.class, study.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath point = createString("point");

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<study.domain.enums.SocialType> socialType = createEnum("socialType", study.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<study.domain.enums.MemberStatus> status = createEnum("status", study.domain.enums.MemberStatus.class);

    //inherited
    public final DatePath<java.time.LocalDate> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

