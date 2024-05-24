package org.example.musicalticket.reservation.application;

import org.example.musicalticket.reservation.presentation.dto.AddReservationRequestDto;

public interface ReservationService {

    //뮤지컬 예약하기
    void reservation(AddReservationRequestDto requestDto);
}
