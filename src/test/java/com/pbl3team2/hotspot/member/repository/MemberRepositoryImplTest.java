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

    @Autowired
    DataSource dataSource;

    @Autowired
    MemberRepositoryImpl memberRepository;

    @Test
    void insertMember() {
        Member member = new Member();
        member.setNumber(1);
        member.setEmail("orange@naver.com");
        member.setId("orange7539");
        member.setPw("1234");
        member.setNickname("ILOrange2");

        memberRepository.insertMember(member);
    }

    @Test
    void deleteMember(){
        memberRepository.deleteMember("orange7539");
        System.out.println("성공적으로 삭제되었습니다.");
    }

    @Test
    void findMemberById(){
        Member member1 = new Member();
        member1.setNumber(2);
        member1.setEmail("muojeso@naver.com");
        member1.setId("muojeso7539");
        member1.setPw("1234");
        member1.setNickname("Mulsuo12");

        memberRepository.insertMember(member1);

        Optional<Member> member2 = memberRepository.findMemberById("muojeso7539");

        Assertions.assertThat(member2.get()).isEqualTo(member1);
    }

}