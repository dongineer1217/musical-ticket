package org.example.musicalticket.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.musicalticket.reservation.domain.Reservation;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. PROTECTED를 주는이유
 * JPA 엔티티 클래스를 인스턴스화하기위해 기본 생성자가 필요. (public or protected)
 * protected를 사용하는이유는 외부에서 직접적으로 이 생성자를 호출하여 객체를 생성하는 것을 방지 (무결성을 유지 또는 제한된범위내에서 허용)
 */
@Getter
@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    /**
     * IDENTITY 사용이유 ?
     * - 데이터베이스가 auto-increment 기능을 사용하여 기본키 생성, 애플리케이션 레벨에서 키 생성에 대한 신경쓸 필요가 없다.
     * - 데이터베이스가 담당하기때문에 일관성과 무결성을 보장
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Gender gender;

    private String email;

    private Integer age;

    /**
     * 1. CascadeType.ALL
     * - Musical 엔티티를 삭제하면 해당 Musical과 연관된 모든 Reservation 엔티티도 자동으로 삭제됩니다.
     *
     * 2. orphanRemoval = true
     * List<Reservation> 엘리먼트 제거 하면 reservation 에서도 삭제됨
     */
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservationList = new ArrayList<>();

    @Builder
    public Member(final String name, Gender gender, final String email, final Integer age) {
        Assert.notNull(name, "이름은 필수 값입니다.");
        Assert.notNull(email, "이메일은 필수 값입니다.");
        Assert.notNull(age, "나이는 필수 값입니다.");
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.age = age;
    }
}
