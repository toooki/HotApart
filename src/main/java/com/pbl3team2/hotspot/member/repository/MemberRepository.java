package com.pbl3team2.hotspot.member.repository;

import com.pbl3team2.hotspot.member.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository{

    void insertMember(Member member);
    void deleteMember(String id);
    Optional<Member> findMemberById(String id);

}
