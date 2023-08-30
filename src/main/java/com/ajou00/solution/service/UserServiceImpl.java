package com.ajou00.solution.service;

import com.ajou00.solution.domain.Member;
import com.ajou00.solution.dto.UserJoinDto;
import com.ajou00.solution.dto.UserLoginDto;
import com.ajou00.solution.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final MemberRepository memberRepository;

    @Autowired
    public UserServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String login(UserLoginDto userLoginDto) throws Exception {
        Member member = memberRepository
                .findById(userLoginDto.getId())
                .orElseThrow(() -> new Exception("아이디 혹은 비밀번호를 확인하세요."));

        if (!member.getPassword().equals(userLoginDto.getPassword())) throw new Exception("아이디 혹은 비밀번호를 확인하세요.");
        else {
            member.setIsLogin(true);
            memberRepository.save(member);
        }

        return member.getUserName();
    }

    @Override
    public String logout() throws Exception {
        Member member = memberRepository.findByIsLogin(true).orElseThrow(() -> new Exception("error"));
        member.setIsLogin(false);
        memberRepository.save(member);
        return "로그아웃";
    }

    @Override
    public Boolean isLogin() throws Exception {
        Boolean bool = memberRepository.existsMemberByIsLogin(true).orElseThrow(() -> new Exception("error"));
        return bool;
    }

    @Override
    public List<Member> getCustomers() {
        return memberRepository.findAll();
    }

    @Override
    public Exception join(UserJoinDto userJoinDto) throws Exception {
        Member member = new Member();
        member.setId(userJoinDto.getId());
        member.setPassword(userJoinDto.getPassword());
        member.setRole(userJoinDto.getRole());
        member.setUserName(userJoinDto.getUserName());
        memberRepository.save(member);
        return new Exception("회원가입 완료");
    }
}