package org.example.musicalticket.reservation.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.musicalticket.reservation.application.ReservationService;
import org.example.musicalticket.reservation.presentation.dto.AddReservationRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService service;

    /**
     * 예약하기
     */
    @PostMapping("/create")
    public ResponseEntity<Void> createReservation(@RequestBody @Valid final AddReservationRequestDto requestDto) {

        service.reservation(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
