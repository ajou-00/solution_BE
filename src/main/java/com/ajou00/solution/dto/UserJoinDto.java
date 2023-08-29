package com.ajou00.solution.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserJoinDto {
    private String id;
    private String password;
    private String role;
}
