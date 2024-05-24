package org.example.musicalticket.reservation;

import org.assertj.core.api.Assertions;
import org.example.musicalticket.ApiTest;
import org.example.musicalticket.member.MemberSteps;
import org.example.musicalticket.musical.MusicalSteps;
import org.example.musicalticket.musical.presentation.dto.MusicalResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReservationApiTest extends ApiTest {

    private static final Long MEMBER_ID = 1L;
    private static final Long MUSICAL_ID = 1L;


    @Test
    @DisplayName("예약하기")
    void 예약하기() {
        //회원생성
        MemberSteps.회원생성요청(MemberSteps.회원생성요청_생성());

        //뮤지컬 생성
        MusicalSteps.뮤지컬생성요청(MusicalSteps.뮤지컬요청_생성());

        final var response = ReservationSteps.예약하기요청(ReservationSteps.예약하기요청_생성(3, MEMBER_ID, MUSICAL_ID));

        final var musicalResponse = MusicalSteps.뮤지컬조회요청(MUSICAL_ID);

        System.out.println("musicalResponse = " + musicalResponse);
        System.out.println("response = " + response);

    }
    
    @Test
    @DisplayName("동시성보장_예약하기")
    void 동시성보장_예약하기() throws InterruptedException {
        // 회원생성
        MemberSteps.회원생성요청(MemberSteps.회원생성요청_생성());

        // 뮤지컬 생성
        MusicalSteps.뮤지컬생성요청(MusicalSteps.뮤지컬요청_생성());

        int numberOfConcurrentUsers = 30;
        CountDownLatch latch = new CountDownLatch(numberOfConcurrentUsers);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfConcurrentUsers);

        for (int i = 0; i < numberOfConcurrentUsers; i++) {
            executorService.execute(() -> {
                try {
                    ReservationSteps.예약하기요청(ReservationSteps.예약하기요청_생성(1, MEMBER_ID, MUSICAL_ID));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        latch.await();

        final var musicalResponse = MusicalSteps.뮤지컬조회요청(MUSICAL_ID);
    }
}
