package org.example.musicalticket.member;

import org.example.musicalticket.ApiTest;
import org.example.musicalticket.member.application.dto.AddMemberRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberApiTest extends ApiTest {

    @Test
    @DisplayName("회원생성")
    void 회원생성() {

        final AddMemberRequest request = MemberSteps.회원생성요청_생성();

        final var response = MemberSteps.회원생성요청(request);
        System.out.println("response = " + response);
    }

    @Test
    @DisplayName("회원생성_잘못된요청")
    void 회원생성_잘못된요청() {

        final AddMemberRequest request = MemberSteps.회원생성요청_잘못된_생성();
        final var response = MemberSteps.회원생성요청(request);
        System.out.println("response = " + response);
    }
}
