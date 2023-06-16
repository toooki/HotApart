package com.pbl3team2.hotspot.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberLoginRequest {
    private String id;
    private String pw;
}
