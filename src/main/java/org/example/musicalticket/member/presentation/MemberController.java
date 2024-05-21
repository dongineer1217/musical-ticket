package org.example.musicalticket.member.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.musicalticket.member.application.MemberService;
import org.example.musicalticket.member.application.dto.AddMemberRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @PostMapping("/create")
    public ResponseEntity<Void> createMember(@RequestBody @Valid final AddMemberRequest request) {

       // service.createMember(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
