package com.pbl3team2.hotspot.member.service;

import com.pbl3team2.hotspot.member.Member;
import com.pbl3team2.hotspot.member.MemberDTO;
import com.pbl3team2.hotspot.member.MemberLoginRequest;
import com.pbl3team2.hotspot.member.MemberRegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    //회원가입
     MemberDTO register(MemberRegisterRequest memberRegisterRequest);

     String login(MemberLoginRequest memberLoginRequest);
}
