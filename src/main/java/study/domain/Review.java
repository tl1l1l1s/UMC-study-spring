package study.domain;

import jakarta.persistence.*;
import lombok.*;
import study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(length = 20)
    private String title;

    @Column(nullable = false, length = 300)
    private String body;

    @Column(columnDefinition = "FLOAT DEFAULT '0'", nullable = false)
    private Float score;

    public void setStore(Store store) {
        this.store = store;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
