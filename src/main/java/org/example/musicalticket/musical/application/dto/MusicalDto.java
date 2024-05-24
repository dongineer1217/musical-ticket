package org.example.musicalticket.musical.application.dto;

import lombok.Builder;

public record MusicalDto(
        Long id,
        String title,
        int price,
        int totalSeats,
        int availableSeats
) {

    @Builder
    public MusicalDto {

    }
}
