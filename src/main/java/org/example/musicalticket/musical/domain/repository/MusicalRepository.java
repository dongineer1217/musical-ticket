package org.example.musicalticket.musical.domain.repository;

import jakarta.persistence.LockModeType;
import org.example.musicalticket.musical.domain.Musical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicalRepository extends JpaRepository<Musical, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select m from Musical m where m.id = :id")
    Musical findByIdWithLock(Long id);
}
