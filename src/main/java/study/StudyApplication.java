package study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import study.domain.Member;
import study.domain.Mission;
import study.domain.enums.MissionStatus;
import study.service.MemberService.MemberQueryService;
import study.service.MissionService.MissionQueryService;
import study.service.ReviewService.ReviewQueryService;
import study.service.StoreService.StoreQueryService;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableJpaAuditing
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> {
            // 실습
            StoreQueryService storeService = context.getBean(StoreQueryService.class);

            // 파라미터 값 설정
            String name = "요아정";
            Float score = 4.0f;

            // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
            System.out.println("Executing findStoresByNameAndScore with parameters:");
            System.out.println("Name: " + name);
            System.out.println("Score: " + score);

            storeService.findStoresByNameAndScore(name, score)
                    .forEach(System.out::println);


            // 미션
            MissionQueryService missionService = context.getBean(MissionQueryService.class);
            ReviewQueryService reviewService = context.getBean(ReviewQueryService.class);
            MemberQueryService memberService = context.getBean(MemberQueryService.class);

            // 파라미터 값 설정
            Long memberId = 1L;
            MissionStatus challenging = MissionStatus.CHALLENGING;
            MissionStatus completed = MissionStatus.COMPLETED;
            Long storeId = 1L;
            Long regionId = 1L;
            String title = "리뷰 제목";
            String body = "리뷰 내용 예시";
            Long lastMissionId = 10L;
            Pageable pageable = PageRequest.of(0, 10);

            // 진행 중인 미션 모아보기
            System.out.println("Executing findByMemberIdAndStatus with parameters:");
            System.out.println("Member Id: " + memberId);
            System.out.println("Status: " + challenging);

            missionService.findByMemberIdAndStatus(memberId, challenging, lastMissionId, pageable)
                    .forEach(System.out::println);

            System.out.println("aaa : " + missionService.findByMemberIdAndStatus(memberId, challenging, lastMissionId, pageable).getSize());

            // 진행 완료한 미션 모아보기
            System.out.println("Member Id: " + memberId);
            System.out.println("Status: " + completed);

            missionService.findByMemberIdAndStatus(memberId, completed, lastMissionId, pageable)
                    .forEach(System.out::println);

            // 리뷰 작성
            System.out.println("Executing insertReview with parameters:");
            reviewService.insertReview(memberId, storeId, title, body, score);

            // 현재 선택한 region에서 도전 가능한 미션 모아보기
            System.out.println("Executing insertReview with parameters:");
            System.out.println("Member Id: " + memberId);
            System.out.println("region Id" + regionId);

            missionService.findChallengingByRegion(memberId, regionId, lastMissionId, pageable)
                    .forEach(System.out::println);

            // 마이 페이지에서 필요한 정보 모아보기
            System.out.println("Executing getMemberProfileById with parameters:");
            System.out.println("Member Id: " + memberId);

            Member mem = memberService.getMemberProfileById(memberId);
            System.out.println(mem);
        };
    }
}
