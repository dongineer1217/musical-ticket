package org.example.musicalticket.musical;

import org.example.musicalticket.ApiTest;
import org.example.musicalticket.musical.presentation.dto.AddMusicalRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class MusicalApiTest extends ApiTest {

    @Test
    @DisplayName("뮤지컬생성")
    void 뮤지컬생성() {

        final AddMusicalRequestDto request = MusicalSteps.뮤지컬요청_생성();

        final var response = MusicalSteps.뮤지컬생성요청(request);

        assertThat(response).isNotNull();
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.jsonPath().getString("title")).isEqualTo(request.title());
    }

    @Test
    @DisplayName("뮤지컬생성_좌석수불일치_요청")
    void 뮤지컬생성_좌석수불일치_요청() {

        final AddMusicalRequestDto requestDto = MusicalSteps.뮤지컬요청_좌석수_불일치_요청_생성();

        final var response = MusicalSteps.뮤지컬생성요청(requestDto);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
