package org.example.musicalticket.musical.presentation.dto;

import org.example.musicalticket.musical.application.dto.MusicalDto;

public class MusicalResponseDtoAssembler {


    public static MusicalResponseDto createMusicalResponseDto(final MusicalDto musicalDto) {

        return MusicalResponseDto.builder()
                .title(musicalDto.title())
                .price(musicalDto.price())
                .totalSeats(musicalDto.totalSeats())
                .availableSeats(musicalDto.availableSeats())
                .build();
    }

}
