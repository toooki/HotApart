package com.pbl3team2.hotspot.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailToken {

    //이메일토큰
    private static final long EMAIL_TOKEN_EXPIRATION_TIME_VALUE = 5L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    private LocalDateTime expirationDate;

    private boolean expired;

    private Long memberId;

    //이메일 인증 토큰 생성
    public static EmailToken createEmailToken(Long memberId){
        EmailToken emailToken = new EmailToken();
        emailToken.expirationDate = LocalDateTime.now().plusMinutes(EMAIL_TOKEN_EXPIRATION_TIME_VALUE); // 지금 시간으로부터 5분후 만료
        emailToken.expired = false;
        emailToken.memberId = memberId;

        return emailToken;
    }

    //토큰 만료
    public void setTokenToUsed(){
        this.expired=true;
    }

}
