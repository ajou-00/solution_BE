package com.ajou00.solution.repository;

import com.ajou00.solution.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(String id);
    Optional<Boolean> existsMemberByIsLogin(boolean IsMail);
    Optional<Member> findByIsLogin(Boolean isLogin);
    List<Member> findAll();
}