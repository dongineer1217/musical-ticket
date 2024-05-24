package org.example.musicalticket.member.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.musicalticket.member.application.dto.MemberDto;
import org.example.musicalticket.member.application.dto.MemberDtoAssembler;
import org.example.musicalticket.member.domain.Member;
import org.example.musicalticket.member.presentation.dto.AddMemberRequestDto;
import org.example.musicalticket.member.domain.respository.MemberRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;

    @Override
    public MemberDto createMember(final AddMemberRequestDto requestDto) {

        try {
            final Member member = Member.builder()
                    .name(requestDto.name())
                    .age(requestDto.age())
                    .email(requestDto.email())
                    .gender(requestDto.gender())
                    .build();

            final Member resultMember = repository.save(member);

            return MemberDtoAssembler.createMemberDto(resultMember);

        } catch (Exception e) {
            log.error("회원생성 실패 : {}", e.toString());
            throw new RuntimeException("회원생성실패");
        }

    }

    @Override
    public MemberDto findMemberById(Long memberId) {
        final Member member = repository.findById(memberId)
                .orElseThrow(RuntimeException::new);
        return MemberDtoAssembler.createMemberDto(member);
    }
}
