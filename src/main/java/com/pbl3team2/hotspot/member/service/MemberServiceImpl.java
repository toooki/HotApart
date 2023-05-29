package com.pbl3team2.hotspot.member.service;

import com.pbl3team2.hotspot.member.Member;
import com.pbl3team2.hotspot.member.MemberFormDTO;
import com.pbl3team2.hotspot.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(MemberFormDTO memberDto) {
        Member member = Member.builder()
                .id(memberDto.getId())
                .pw(memberDto.getPw())
                .email(memberDto.getEmail())
                .nickname(memberDto.getNickname())
                .build();

        memberRepository.insertMember(member);
    }
}
