package study.domain;

import jakarta.persistence.*;
import lombok.*;
import study.domain.common.BaseEntity;
import study.domain.enums.Gender;
import study.domain.enums.MemberStatus;
import study.domain.enums.SocialType;
import study.domain.mapping.MemberAgree;
import study.domain.mapping.MemberMission;
import study.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity // 해당 class가 JPA의 entitiy
@Getter // lombok 제공, getter 생성
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor // 빌더 패턴 사용
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성 시 JPA가 통신하는 DBMS 방식을 따름
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress; // 실제 DB에는 spec_address로 생성

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;

    private String point;

    // N에 해당하는 entity에서 ManyToOne 멤버변수를 mappedBy
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL) // CascadeType.ALL == member의 변화에 따라 다른 테이블들에 영향 O
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
