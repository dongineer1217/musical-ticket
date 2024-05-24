package org.example.musicalticket.musical.application;

import org.example.musicalticket.musical.application.dto.MusicalDto;
import org.example.musicalticket.musical.presentation.dto.AddMusicalRequestDto;

public interface MusicalService {

    MusicalDto createMusical(final AddMusicalRequestDto requestDto);

    MusicalDto findMusicalById(final Long musicalId);
}
