package com.pbl3team2.hotspot.member.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping
public class EmailController {

    private final EmailService emailService;

    //사용자가 이메일을 받아서 인증토큰URL을 클릭했을 떄
    @GetMapping("/confirm-email")
    public String viewConfirmEmail(@RequestParam String token){
        try{
            boolean result = emailService.verifyEmail(token);
            return "confirmed";

        } catch (Exception ex){
            return ex.toString();
        }
    }

}
