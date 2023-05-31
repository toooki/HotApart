package com.pbl3team2.hotspot.member.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailTokenServiceTest {

    @Autowired
    EmailTokenService emailTokenService;



    @Test
    void createEmailToken() {
        emailTokenService.createEmailToken("Mulso12", "bepg175@gmail.com");
    }

    @Test
    void findByIdAndExpirationDateAfterAndExpired() {

    }
}