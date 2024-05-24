package org.example.musicalticket.reservation;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.example.musicalticket.reservation.presentation.dto.AddReservationRequestDto;
import org.springframework.http.MediaType;

public class ReservationSteps {

    public static AddReservationRequestDto 예약하기요청_생성(final int tickets, final Long memberId, final Long musicalId) {
        return new AddReservationRequestDto(memberId, musicalId, tickets);
    };
    public static ExtractableResponse<Response> 예약하기요청(AddReservationRequestDto request) {
        return RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/reservation/create").then()
                .log().all().extract();
    }
}
