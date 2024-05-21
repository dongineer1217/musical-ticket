package org.example.musicalticket.member.application.dto;

import org.example.musicalticket.member.domain.Gender;

/**
 * 불변성: record는 모든 필드를 final로 선언하여 객체를 불변으로 만듭니다.
 * 자동 생성: 생성자, 접근자 메서드, equals(), hashCode(), toString() 메서드를 자동으로 생성합니다.
 * 간결성: 코드가 더 간결해지며, 클래스 선언과 필드 선언을 동시에 할 수 있습니다.
 * @param email
 * @param name
 * @param gender
 * @param age
 */
public record MemberCreateRequest(
        String email,

        String name,
        Gender gender,
        int age
) {

}