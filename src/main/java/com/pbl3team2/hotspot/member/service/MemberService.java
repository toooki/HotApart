package com.pbl3team2.hotspot.member.service;

import com.pbl3team2.hotspot.member.Member;
import com.pbl3team2.hotspot.member.MemberFormDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface MemberService {

    //회원가입
     Member join(MemberFormDTO memberDto);

     String login(String id, String pw);
}
