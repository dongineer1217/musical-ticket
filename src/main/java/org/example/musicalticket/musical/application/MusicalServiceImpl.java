package org.example.musicalticket.musical.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.musicalticket.musical.application.dto.MusicalDto;
import org.example.musicalticket.musical.application.dto.MusicalDtoAssembler;
import org.example.musicalticket.musical.domain.Musical;
import org.example.musicalticket.musical.domain.repository.MusicalRepository;
import org.example.musicalticket.musical.presentation.dto.AddMusicalRequestDto;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MusicalServiceImpl implements MusicalService {

    private final MusicalRepository repository;

    @Override
    public MusicalDto createMusical(final AddMusicalRequestDto requestDto) {
        try {
            final Musical musical = Musical.builder()
                    .title(requestDto.title())
                    .price(requestDto.price())
                    .totalSeats(requestDto.totalSeats())
                    .availableSeats(requestDto.availableSeats())
                    .build();
            final Musical resultMusical = repository.save(musical);

            return MusicalDtoAssembler.createMusicalDto(resultMusical);

        } catch (Exception e) {
            log.error("뮤지컬 생성 실패 : {}", e.toString());
            throw new RuntimeException("뮤지컬 생성 실패");
        }
    }

    @Override
    public MusicalDto findMusicalById(Long musicalId) {

        final Musical musical =  repository.findById(musicalId)
                .orElseThrow(() -> new RuntimeException("뮤지컬이 존재하지 않습니다."));

        return MusicalDtoAssembler.createMusicalDto(musical);
    }
}
