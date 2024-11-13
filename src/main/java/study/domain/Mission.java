package study.domain;

import jakarta.persistence.*;
import lombok.*;
import study.domain.common.BaseEntity;
import study.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "INTEGER DEFAULT 500", nullable = false)
    private Integer reward;

    @Column(columnDefinition = "DATETIME DEFAULT (NOW()+INTERVAL 7 DAY)", nullable = false)
    private LocalDate deadline;

    @Column(nullable = false)
    private String missionSpec;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
}
