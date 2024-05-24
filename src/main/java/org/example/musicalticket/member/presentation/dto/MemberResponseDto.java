package org.example.musicalticket.member.presentation.dto;

import lombok.Builder;
import org.example.musicalticket.member.domain.Gender;

public record MemberResponseDto(
        String name,
        Gender gender,
        String email,
        Integer age
) {

    @Builder
    public MemberResponseDto {

    }
}
