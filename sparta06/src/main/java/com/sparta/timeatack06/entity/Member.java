package com.sparta.timeatack06.entity;

import com.sparta.timeatack06.dto.RequestUpdateMemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    public Member(String email, String name, int age, Gender gender) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void updateProfile(RequestUpdateMemberDto requestUpdateMemberDto) {
        this.name = requestUpdateMemberDto.getName();
        this.age = requestUpdateMemberDto.getAge();
        this.gender = requestUpdateMemberDto.getGender() == 0 ? Gender.M : Gender.F;
    }

}
