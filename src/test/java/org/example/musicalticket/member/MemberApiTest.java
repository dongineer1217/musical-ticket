package org.example.musicalticket.member;

import org.example.musicalticket.ApiTest;
import org.example.musicalticket.member.presentation.dto.AddMemberRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberApiTest extends ApiTest {

    @Test
    @DisplayName("회원생성")
    void 회원생성() {

        final AddMemberRequestDto request = MemberSteps.회원생성요청_생성();

        final var response = MemberSteps.회원생성요청(request);

        assertThat(response).isNotNull();
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo(request.name());
    }

    @Test
    @DisplayName("회원생성_잘못된요청")
    void 회원생성_잘못된요청() {

        final AddMemberRequestDto request = MemberSteps.회원생성요청_잘못된_생성();
        final var response = MemberSteps.회원생성요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("회원조회")
    void 회원조회() {

        //회원생성
        final var response = MemberSteps.회원생성요청(MemberSteps.회원생성요청_생성());

        final var response1 = MemberSteps.회원조회요청(1L);

        assertThat(response1.jsonPath().getString("name")).isEqualTo("seodonghyi");

    }
}
