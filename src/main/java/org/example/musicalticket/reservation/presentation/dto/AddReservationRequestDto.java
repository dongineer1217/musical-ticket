package org.example.musicalticket.reservation.presentation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AddReservationRequestDto(
        @NotNull Long memberId,
        @NotNull Long musicalId,
        @Min(value = 1, message = "tickets은 0보다 커야합니다.") int tickets
) {
}
