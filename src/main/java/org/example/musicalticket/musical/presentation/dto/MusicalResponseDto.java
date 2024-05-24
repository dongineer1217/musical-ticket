package org.example.musicalticket.musical.presentation.dto;

import lombok.Builder;

public record MusicalResponseDto(
        String id,
        String title,
        int price,
        int totalSeats,
        int availableSeats
) {
    @Builder
    public MusicalResponseDto {

    }
}
