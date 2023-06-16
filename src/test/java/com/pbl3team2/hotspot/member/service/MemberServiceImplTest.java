package com.pbl3team2.hotspot.member.service;

import com.pbl3team2.hotspot.member.Member;
import com.pbl3team2.hotspot.member.MemberDTO;
import com.pbl3team2.hotspot.member.MemberRegisterRequest;
import com.pbl3team2.hotspot.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void register() {
        MemberRegisterRequest member = MemberRegisterRequest.builder()
                .id("Jhin214")
                .pw("1234")
                .email("bepg175@gmail.com")
                .nickname("Jhin")
                .build();

        MemberDTO memberDTO = memberService.register(member);

        Optional<Member> findMember = memberRepository.findMemberById(member.getId());

        Assertions.assertThat(memberDTO.getPw()).isEqualTo(findMember.get().getPw());


    }

    @Test
    void login() {

    }
}