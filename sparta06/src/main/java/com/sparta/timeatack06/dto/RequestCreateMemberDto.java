package com.sparta.timeatack06.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Getter
public class RequestCreateMemberDto {
    private String email;
    private String name;
    private int age;
    private int gender;

    public RequestCreateMemberDto(String email, String name, int age, int gender) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
