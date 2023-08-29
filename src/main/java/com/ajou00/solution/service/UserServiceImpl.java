package com.ajou00.solution.service;

import com.ajou00.solution.domain.Member;
import com.ajou00.solution.domain.MemberRepository;
import com.ajou00.solution.dto.UserJoinDto;
import com.ajou00.solution.dto.UserLoginDto;
import com.ajou00.solution.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MemberRepository memberRepository) {
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public String login(UserLoginDto userLoginDto) throws Exception {

        Member member = userRepository
                .findById(userLoginDto.getId())
                .orElseThrow(() -> new Exception("아이디 혹은 비밀번호를 확인하세요."));

        if (!member.getPassword().equals(userLoginDto.getPassword())) throw new Exception("아이디 혹은 비밀번호를 확인하세요.");

        return "로그인 성공";
    }

    @Override
    public Exception join(UserJoinDto userJoinDto) throws Exception {
        Member member = new Member();
        member.setId(userJoinDto.getId());
        member.setPassword(userJoinDto.getPassword());
        member.setRole(userJoinDto.getRole());
        memberRepository.save(member);
        return new Exception("회원가입 완료");
    }
}