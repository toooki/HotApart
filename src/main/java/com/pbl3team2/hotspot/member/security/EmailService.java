package com.pbl3team2.hotspot.member.security;

import com.pbl3team2.hotspot.member.Member;
import com.pbl3team2.hotspot.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class EmailService {

    private final MemberRepository memberRepository;
    private final EmailTokenService emailTokenService;

    @Transactional
    public boolean verifyEmail(String token) throws Exception{

        //이메일 토큰을 찾아옴
        EmailToken findEmailToken = emailTokenService.findByIdAndExpirationDateAfterAndExpired(token);

        //TODO: 여기서부터는 이메일 성공 인증로직을 구현합니다.
        //지금예시는 유저의 인증내용 변경하는 방법입니다.

        //토큰의 유저 ID를 이용하여 유저 인증 정보를 가져온다.
        Optional<Member> findMember = memberRepository.findMemberById(findEmailToken.getId());
        findEmailToken.setTokenToUsed();

        if(findMember.isPresent()){
            Member member = findMember.get();
            System.out.println(member + "님은 인증되었습니다.");
            return  true;
        } else {
            throw new Exception("에러발생");
        }

    }
}
