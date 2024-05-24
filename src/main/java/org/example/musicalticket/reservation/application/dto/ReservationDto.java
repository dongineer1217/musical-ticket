package org.example.musicalticket.reservation.application.dto;

import lombok.Builder;
import org.example.musicalticket.member.application.dto.MemberDto;
import org.example.musicalticket.musical.application.dto.MusicalDto;

public record ReservationDto(
        Long id,
        int tickets,
        boolean confirmed,
        MemberDto memberDto,
        MusicalDto musicalDto
) {
    @Builder
    public ReservationDto {

    }
}
