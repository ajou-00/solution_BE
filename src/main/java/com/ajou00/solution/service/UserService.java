package com.ajou00.solution.service;


import com.ajou00.solution.domain.Member;
import com.ajou00.solution.dto.UserJoinDto;
import com.ajou00.solution.dto.UserLoginDto;

import java.util.List;

public interface UserService {

    String login(UserLoginDto userLoginDto) throws Exception;

    String logout() throws Exception;

    Boolean isLogin() throws Exception;

    List<Member> getCustomers();

    Exception join(UserJoinDto userJoinDto) throws Exception;
}