package com.ajou00.solution.controller;

import com.ajou00.solution.domain.Member;
import com.ajou00.solution.dto.UserJoinDto;
import com.ajou00.solution.dto.UserLoginDto;
import com.ajou00.solution.repository.MemberRepository;
import com.ajou00.solution.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto) throws Exception {
        String result = userService.login(userLoginDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() throws Exception {
        String result = userService.logout();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/islogin")
    public ResponseEntity<Boolean> isLogin() throws Exception {
        Boolean result = userService.isLogin();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserJoinDto userJoinDto) throws Exception {
        userService.join(userJoinDto);

        return ResponseEntity.status(HttpStatus.OK).body(userJoinDto.getRole());
    }

    @GetMapping("/customers")
    public List<Member> getCustomers() throws Exception {
        List<Member> members = userService.getCustomers();
        return members;
    }
}