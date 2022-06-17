package com.sparta.timeatack06.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ResponseMemberDto {
    private String email;
    private String name;
    private int age;
    private int gender;

}
