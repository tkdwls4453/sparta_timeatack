package com.sparta.timeatack06.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestLoginMemberDto {
    private String email;

    public RequestLoginMemberDto(String email) {
        this.email = email;
    }
}
