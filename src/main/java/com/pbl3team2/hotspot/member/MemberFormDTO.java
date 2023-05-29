package com.pbl3team2.hotspot.member;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberFormDTO {

    private String id;
    private String pw;
    private String email;
    private String nickname;
}
