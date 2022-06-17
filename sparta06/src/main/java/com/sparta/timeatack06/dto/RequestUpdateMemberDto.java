package com.sparta.timeatack06.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateMemberDto {
    private String name;
    private int age;
    private int gender;

    public RequestUpdateMemberDto(String name, int age, int gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
