package org.example.musicalticket.member;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.example.musicalticket.member.application.dto.AddMemberRequest;
import org.example.musicalticket.member.domain.Gender;
import org.springframework.http.MediaType;

public class MemberSteps {

    public static AddMemberRequest 회원생성요청_생성() {
        final String email = "seodh1217@gmail.com";
        final String name = "seodonghyi";
        final Gender gender = Gender.MALE;
        final int age = 30;
        return new AddMemberRequest(email, name, gender, age);
    }

    public static AddMemberRequest 회원생성요청_잘못된_생성() {
        final String email = "";
        final String name = "seodonghyi";
        final Gender gender = Gender.MALE;
        final int age = 30;
        return new AddMemberRequest(email, name, gender, age);
    }

    public static ExtractableResponse<Response> 회원생성요청(AddMemberRequest request) {
        return RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/member/create").then()
                .log().all().extract();
    }
}
