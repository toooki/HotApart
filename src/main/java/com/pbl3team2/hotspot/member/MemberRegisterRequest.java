package com.pbl3team2.hotspot.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MemberRegisterRequest {
    private String id;
    private String pw;
    private String email;
    private String nickname;

    public Member toEntity(String password){
        Member member = Member.builder()
                .id(this.getId())
                .pw(password)
                .email(this.getEmail())
                .nickname(this.getNickname())
                .build();
        return member;
    }
}
