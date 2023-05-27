package com.pbl3team2.hotspot.member.repository;

import com.pbl3team2.hotspot.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository{


    private final JdbcTemplate jdbcTemplate;

    //애는 자동으로 주입됨 jdbctemplate에 필요한 파라미터 datasource도 application.properties에서 작성한 객체를 받는다.
    @Autowired
    public MemberRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    //멤버 삽입
    @Override
    public void insertMember(Member member) {
        String sql = "INSERT INTO member(number, id, pw, email, nickname) VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                member.getNumber() ,member.getId(), member.getPw(), member.getEmail(), member.getNickname());


        System.out.println("멤버를 데이터베이스에서 성공적으로 삽입완료했습니다.");
    }

    //멤버 삭제
    @Override
    public void deleteMember(String id) {
        String sql = "DELETE FROM member WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }

    //멤버 조회
    @Override
    public Optional<Member> findMemberById(String id) {
        String sql = "SELECT * FROM member WHERE id = ?";

        return Optional.of(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Member.class), id));
    }

}
