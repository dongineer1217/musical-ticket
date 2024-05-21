package org.example.musicalticket.reservation.domain.repository;

import org.example.musicalticket.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
