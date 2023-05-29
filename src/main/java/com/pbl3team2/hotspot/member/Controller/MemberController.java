package com.pbl3team2.hotspot.member.Controller;

import com.pbl3team2.hotspot.member.MemberFormDTO;
import com.pbl3team2.hotspot.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //회원가입시에 POST요청을 받는 메서드
    @PostMapping("/login")
    public String login(@RequestBody MemberFormDTO memberDto){

        memberService.join(memberDto);
        System.out.println("회원가입이 완료되었습니다.");

        return "login";
    }


}
