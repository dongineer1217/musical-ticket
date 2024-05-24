package org.example.musicalticket.musical.application.dto;

import org.example.musicalticket.musical.domain.Musical;

public class MusicalDtoAssembler {

    public static MusicalDto createMusicalDto(Musical musical) {
        return MusicalDto.builder()
                .id(musical.getId())
                .title(musical.getTitle())
                .price(musical.getPrice())
                .totalSeats(musical.getTotalSeats())
                .availableSeats(musical.getAvailableSeats())
                .build();
    }
}
