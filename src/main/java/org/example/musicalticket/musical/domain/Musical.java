package org.example.musicalticket.musical.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.musicalticket.reservation.domain.Reservation;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "musicals")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Musical {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int totalSeats;

    @Column(nullable = false)
    private int availableSeats;

    @OneToMany(mappedBy = "musical", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservationList = new ArrayList<>();


    @Builder
    public Musical(final String title, final int price, final int totalSeats, final int availableSeats) {
        Assert.notNull(title, "뮤지컬 제목은 필수입니다.");
        Assert.isTrue(totalSeats > 0, "총 좌석수는 0보다 커야합니다.");
        Assert.isTrue(availableSeats <= totalSeats, "잔여 좌석수는 총 좌석수보다 작거나 같아야합니다.");
        Assert.isTrue(price > 0, "뮤지컬 가격은 0보다 커야합니다.");
        this.title = title;
        this.price = price;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    //예약가능한 좌석 마이너스
    public void decrementSeats(int count) {
        this.availableSeats = this.availableSeats - count;
    }

    //예약 가능한지 ?
    public boolean isReservation() {
        return this.availableSeats > 0;
    }
}
