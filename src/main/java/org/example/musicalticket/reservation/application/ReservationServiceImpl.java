package org.example.musicalticket.reservation.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.musicalticket.member.application.MemberService;
import org.example.musicalticket.member.application.dto.MemberDto;
import org.example.musicalticket.member.domain.Member;
import org.example.musicalticket.member.domain.respository.MemberRepository;
import org.example.musicalticket.musical.application.MusicalService;
import org.example.musicalticket.musical.application.dto.MusicalDto;
import org.example.musicalticket.musical.domain.Musical;
import org.example.musicalticket.musical.domain.repository.MusicalRepository;
import org.example.musicalticket.reservation.application.dto.ReservationDto;
import org.example.musicalticket.reservation.domain.Reservation;
import org.example.musicalticket.reservation.domain.repository.ReservationRepository;
import org.example.musicalticket.reservation.presentation.dto.AddReservationRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    private final MemberRepository memberRepository;
    private final MusicalRepository musicalRepository;

    @Override
    @Transactional
    public void reservation(AddReservationRequestDto requestDto) {
        //유효한 member 인지 체크
        final Member member = memberRepository.findById(requestDto.memberId())
                .orElseThrow(() -> new RuntimeException("회원이 존재하지 않습니다."));

        //유효한 musical인지 체크
        final Musical musical = musicalRepository.findByIdWithLock(requestDto.musicalId());
        System.out.println("before reservation = " +musical.getAvailableSeats());
        if (musical == null) {
            throw new RuntimeException("뮤지컬이 존재하지 않습니다.");
        }
        if (!musical.isReservation()) {
            throw new IllegalArgumentException("잔여좌석이 남아있지 않습니다.");
        }

        final Reservation reservation = Reservation.activeReservation(requestDto.tickets(), member, musical);
        System.out.println("after reservation = " +reservation.getMusical().getAvailableSeats());

        repository.save(reservation);
    }
}
