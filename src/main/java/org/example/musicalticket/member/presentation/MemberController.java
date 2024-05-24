package org.example.musicalticket.member.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.musicalticket.member.application.MemberService;
import org.example.musicalticket.member.application.dto.MemberDto;
import org.example.musicalticket.member.presentation.dto.AddMemberRequestDto;
import org.example.musicalticket.member.presentation.dto.MemberResponseDto;
import org.example.musicalticket.member.presentation.dto.MemberResponseDtoAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @PostMapping("/create")
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody @Valid final AddMemberRequestDto request) {

        final MemberDto memberDto = service.createMember(request);

        final MemberResponseDto responseDto = MemberResponseDtoAssembler.createMemberResponseDto(memberDto);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable("memberId") final Long memberId) {
        final MemberDto memberDto = service.findMemberById(memberId);
        final MemberResponseDto responseDto = MemberResponseDtoAssembler.createMemberResponseDto(memberDto);
        return ResponseEntity.ok(responseDto);
    }

}
