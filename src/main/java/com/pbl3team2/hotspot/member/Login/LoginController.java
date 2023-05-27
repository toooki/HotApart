package com.pbl3team2.hotspot.member.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody ){

    }

}
