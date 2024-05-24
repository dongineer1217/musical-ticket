package org.example.musicalticket.musical.presentation;

import jakarta.validation.Valid;
import org.example.musicalticket.member.application.dto.MemberDto;
import org.example.musicalticket.member.presentation.dto.MemberResponseDto;
import org.example.musicalticket.member.presentation.dto.MemberResponseDtoAssembler;
import org.example.musicalticket.musical.application.MusicalService;
import org.example.musicalticket.musical.application.dto.MusicalDto;
import org.example.musicalticket.musical.domain.Musical;
import org.example.musicalticket.musical.presentation.dto.AddMusicalRequestDto;
import org.example.musicalticket.musical.presentation.dto.MusicalResponseDto;
import org.example.musicalticket.musical.presentation.dto.MusicalResponseDtoAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/musical")
public class MusicalController {

    private final MusicalService musicalService;

    public MusicalController(MusicalService musicalService) {
        this.musicalService = musicalService;
    }

    @PostMapping("/create")
    public ResponseEntity<MusicalResponseDto> createMusical(@RequestBody @Valid final AddMusicalRequestDto requestDto) {

        if (requestDto.availableSeats() != requestDto.totalSeats()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "뮤지컬 생성시 총 좌석수와 사용 가능한 좌석수는 같아야합니다.");
        }

        final MusicalDto musicalDto = musicalService.createMusical(requestDto);
        final MusicalResponseDto responseDto = MusicalResponseDtoAssembler.createMusicalResponseDto(musicalDto);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{musicalId}")
    public ResponseEntity<MusicalResponseDto> getMember(@PathVariable("musicalId") final Long musicalId) {
        final MusicalDto musicalDto = musicalService.findMusicalById(musicalId);
        final MusicalResponseDto responseDto = MusicalResponseDtoAssembler.createMusicalResponseDto(musicalDto);
        return ResponseEntity.ok(responseDto);
    }
}
