package org.example.musicalticket.member.application;

import lombok.RequiredArgsConstructor;
import org.example.musicalticket.member.application.dto.AddMemberRequest;
import org.example.musicalticket.member.domain.respository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;

    @Override
    public void createMember(final AddMemberRequest request) {


    }
}
