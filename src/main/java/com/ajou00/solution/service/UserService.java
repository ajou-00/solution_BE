package com.ajou00.solution.service;


import com.ajou00.solution.dto.UserJoinDto;
import com.ajou00.solution.dto.UserLoginDto;

public interface UserService {

    String login(UserLoginDto userLoginDto) throws Exception;

    String logout() throws Exception;

    Boolean isLogin() throws Exception;

    Exception join(UserJoinDto userJoinDto) throws Exception;
}