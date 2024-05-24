package org.example.musicalticket.member.presentation.dto;

import org.example.musicalticket.member.application.dto.MemberDto;

public class MemberResponseDtoAssembler {

    public static MemberResponseDto createMemberResponseDto(final MemberDto memberDto) {
        return MemberResponseDto.builder()
                .name(memberDto.name())
                .age(memberDto.age())
                .email(memberDto.email())
                .gender(memberDto.gender())
                .build();
    }
}
