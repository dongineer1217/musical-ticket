package org.example.musicalticket.musical;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.example.musicalticket.musical.presentation.dto.AddMusicalRequestDto;
import org.springframework.http.MediaType;

public class MusicalSteps {

    public static AddMusicalRequestDto 뮤지컬요청_생성() {
        final String title = "레베카";
        final int price = 1_000;
        final int totalSeats = 50;
        final int availableSeats = 50;

        return new AddMusicalRequestDto(title, price, totalSeats, availableSeats);
    }

    public static AddMusicalRequestDto 뮤지컬요청_좌석수_불일치_요청_생성() {
        final String title = "레베카";
        final int price = 1_000;
        final int totalSeats = 50;
        final int availableSeats = 9;
        return new AddMusicalRequestDto(title, price, totalSeats, availableSeats);
    }

    public static ExtractableResponse<Response> 뮤지컬생성요청(AddMusicalRequestDto request) {
        return RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/musical/create").then()
                .log().all().extract();
    }

    public static ExtractableResponse<Response> 뮤지컬조회요청(final Long musicalId) {
        return RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/musical/{musicalId}", musicalId)
                .then()
                .log().all().extract();
    }
}
