package org.example.musicalticket.musical.domain.repository;

import org.example.musicalticket.musical.domain.Musical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicalRepository extends JpaRepository<Musical, Long> {
}
