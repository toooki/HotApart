package com.pbl3team2.hotspot.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MemberDTO {

    private String id;
    private String pw;
    private String email;
    private String nickname;

    public static MemberDTO fromEntity(Member member){
        MemberDTO memberDTO = MemberDTO.builder()
                .id(member.getId())
                .pw(member.getPw())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .build();
        return memberDTO;
    }
}
