package com.pbl3team2.hotspot.member.Controller;

import com.pbl3team2.hotspot.member.Member;
import com.pbl3team2.hotspot.member.MemberFormDTO;
import com.pbl3team2.hotspot.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<Member> register(@RequestBody MemberFormDTO memberFormDTO){
        try{
            Member createdMember = memberService.join(memberFormDTO);
            return new ResponseEntity<>(createdMember, HttpStatus.OK);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String id, @RequestParam String pw){
        try{
            //이거 로그인 정보가 없을때 구현 어케하지??
            String token = memberService.login(id, pw);

            return ResponseEntity
                    .ok()
                    .body(token);

        }catch (Exception ex){
            ex.printStackTrace();

            return ResponseEntity
                    .notFound()
                    .build();
        }


    }
}
