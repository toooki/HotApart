package com.pbl3team2.hotspot.member.repository;

import com.pbl3team2.hotspot.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryImplTest {

    //스프링빈에서 자동삽입시키기
    @Autowired
    DataSource dataSource;

    @Autowired
    MemberRepositoryImpl memberRepository;

    //멤버 삽입 테스트
    @Test
    void insertMember() {
        Member member = Member.builder()
                .email("orange@naver.com")
                .id("orange7539")
                .pw("1234")
                .nickname("ILOrange2")
                .build();


        memberRepository.insertMember(member);
    }

    //멤버삭제테스트
    @Test
    void deleteMember(){
        memberRepository.deleteMember("orange7539");
        System.out.println("성공적으로 삭제되었습니다.");
    }

    //멤버 조회 테스트
    @Test
    void findMemberById(){
        Member member1 = Member.builder()
                .email("muojeso@naver.com")
                .id("muojeso7539")
                .pw("1234")
                .nickname("Mulsuo12")
                .build();

        memberRepository.insertMember(member1);

        Optional<Member> member2 = memberRepository.findMemberById("muojeso7539");

        Assertions.assertThat(member2.get().getId()).isEqualTo(member1.getId());
    }

}