package com.pbl3team2.hotspot.web;


import com.pbl3team2.hotspot.member.Member;
import com.pbl3team2.hotspot.member.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {


    MemberRepository memberRepository;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id, @RequestParam("pw")String pw){
        System.out.println("id = " + id + "pw = " +pw);

        Optional<Member> member = memberRepository.findMemberById(id);


        return "login";
    }


}
