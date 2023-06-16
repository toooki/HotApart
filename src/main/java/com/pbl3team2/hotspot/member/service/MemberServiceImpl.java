package com.pbl3team2.hotspot.member.service;

import com.pbl3team2.hotspot.member.Member;
import com.pbl3team2.hotspot.member.MemberDTO;
import com.pbl3team2.hotspot.member.MemberLoginRequest;
import com.pbl3team2.hotspot.member.MemberRegisterRequest;
import com.pbl3team2.hotspot.member.repository.MemberRepository;
import com.pbl3team2.hotspot.member.security.JwkUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Value("${jwt.token.secret}")
    private String secretkey;
    //토큰만료시간 : 10일을 주기로 토큰 만료
    private final long expireTimeMs = 1000 * 60 * 60 * 24 * 10;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public MemberDTO register(MemberRegisterRequest memberRegisterRequest) {
        Member member = memberRegisterRequest.toEntity(bCryptPasswordEncoder.encode(memberRegisterRequest.getPw()));

        Member savedMember = memberRepository.insertMember(member);
        return MemberDTO.fromEntity(savedMember);
    }

    @Override
    public String login(MemberLoginRequest memberLoginRequest) {
        Optional<Member> member = memberRepository.findMemberById(memberLoginRequest.getId());
        if(member.isEmpty()){
            throw new RuntimeException("가입되지 않은 사람입니다.");
        }

        if(!bCryptPasswordEncoder.matches(memberLoginRequest.getPw(), member.get().getPw())){
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return JwkUtil.createToken(String.valueOf(member.get().getNumber()), expireTimeMs, secretkey); // 임시코드
    }
}
