package com.pbl3team2.hotspot.member.Controller;

import com.pbl3team2.hotspot.member.*;
import com.pbl3team2.hotspot.member.security.EmailService;
import com.pbl3team2.hotspot.member.security.EmailTokenService;
import com.pbl3team2.hotspot.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final EmailTokenService emailTokenService;

    @PostMapping("/register")
    public ResponseEntity<MemberRegisterResponse> register(@RequestBody MemberRegisterRequest memberRegisterRequest){
        try{
            MemberDTO memberDTO = memberService.register(memberRegisterRequest);
            return new ResponseEntity<>(new MemberRegisterResponse(memberDTO.getNickname()), HttpStatus.OK);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // 다 끝나고 컨트롤러 조정하기
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody MemberLoginRequest memberLoginRequest){
        try{
            //이거 로그인 정보가 없을때 구현 어케하지??
            String token = memberService.login(memberLoginRequest);

            System.out.println("로그인이 성공적으로 완료되었습니다.");
            return new ResponseEntity<>(new MemberLoginResponse(token), HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();

            System.out.println(ex);

            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @PostMapping("/email")
    public ResponseEntity<Object> email(@RequestBody MemberEmailRequest memberEmailRequest){
        try{
            System.out.println("id: " + memberEmailRequest + "email: " +memberEmailRequest.getEmail());
            emailTokenService.createEmailToken(memberEmailRequest.getId(), memberEmailRequest.getEmail());

            return new ResponseEntity<>(new MemberEmailResponse("인증메일이 정상적으로 전송되었습니다."), HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();

            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
