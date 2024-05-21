package org.example.musicalticket.reservation.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.musicalticket.member.domain.Member;
import org.example.musicalticket.musical.domain.Musical;
import org.springframework.util.Assert;

@Entity
@Table(name = "reservations")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int tickets; //최대 티켓수

    @Column(nullable = false)
    private boolean confirmed = false; //결제 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "musical_id", nullable = false)
    private Musical musical;

    public Reservation(final int tickets, final boolean confirmed, final Member member, final Musical musical) {
        Assert.notNull(member, "회원은 필수입니다.");
        Assert.notNull(musical, "뮤지컬은 필수입니다.");
        this.tickets = tickets;
        this.confirmed = confirmed;
        this.member = member;
        this.musical = musical;
    }
}
