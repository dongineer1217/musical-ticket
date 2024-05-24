package org.example.musicalticket.member.application.dto;

import org.example.musicalticket.member.domain.Member;

public class MemberDtoAssembler {

    public static MemberDto createMemberDto(final Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .age(member.getAge())
                .email(member.getEmail())
                .gender(member.getGender())
                .build();
    }
}
