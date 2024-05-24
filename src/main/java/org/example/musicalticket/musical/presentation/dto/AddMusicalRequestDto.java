package org.example.musicalticket.musical.presentation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AddMusicalRequestDto(
        @NotBlank(message = "뮤지컬명은 필수입니다.") String title,
        @Min(value = 1, message = "가격은 0보다 커야 합니다.") int price,
        @Min(value = 1, message = "전체 좌석은 0보다 커야 합니다.") int totalSeats,
        @Min(value = 1, message = "사용 가능한 좌석은 0보다 커야합니다.") int availableSeats
) {
}
