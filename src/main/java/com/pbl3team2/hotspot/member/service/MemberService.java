package com.pbl3team2.hotspot.member.service;

import com.pbl3team2.hotspot.member.Member;
import com.pbl3team2.hotspot.member.MemberFormDTO;
import org.springframework.stereotype.Service;

public interface MemberService {

    //회원가입
    void join(MemberFormDTO memberDto);
}
