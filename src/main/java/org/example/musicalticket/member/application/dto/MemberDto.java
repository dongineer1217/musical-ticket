package org.example.musicalticket.member.application.dto;

import lombok.Builder;
import org.example.musicalticket.member.domain.Gender;

public record MemberDto(
        Long id,
        String name,
        Gender gender,
        String email,
        Integer age
) {

    @Builder
    public MemberDto {}
}
