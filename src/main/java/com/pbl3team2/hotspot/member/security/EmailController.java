package com.pbl3team2.hotspot.member.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class EmailController {

    private final EmailService emailService;

    //사용자가 이메일을 받아서 인증토큰URL을 클릭했을 떄
    @GetMapping("/email-confirm")
    public String viewConfirmEmail(@Validated @RequestParam String token){
        try{
            System.out.println("메서드가 실행되었습니다.");
            boolean result = emailService.verifyEmail(token);
            return "이메일 인증이 완료되었습니다.";

        } catch (Exception ex){
            return ex.toString();
        }
    }

}
