package org.example.musicalticket.member.application;

import org.example.musicalticket.member.application.dto.MemberDto;
import org.example.musicalticket.member.presentation.dto.AddMemberRequestDto;

public interface MemberService {

    MemberDto createMember(final AddMemberRequestDto request);

    MemberDto findMemberById(final Long memberId);

}
