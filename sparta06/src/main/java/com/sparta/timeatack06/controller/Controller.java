package com.sparta.timeatack06.controller;

import com.sparta.timeatack06.dto.RequestCreateMemberDto;
import com.sparta.timeatack06.dto.RequestLoginMemberDto;
import com.sparta.timeatack06.dto.RequestUpdateMemberDto;
import com.sparta.timeatack06.dto.ResponseMemberDto;
import com.sparta.timeatack06.entity.Member;
import com.sparta.timeatack06.repository.MemberRepository;
import com.sparta.timeatack06.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class Controller {

    private final MemberService memberService;


    @PostMapping("/create")
    public Long createMember(@RequestBody RequestCreateMemberDto createMemberDto) {
        return memberService.saveMember(createMemberDto);
    }

    @GetMapping("/read/{id}")
    public ResponseMemberDto readMember(@PathVariable Long id) {
        return memberService.findMember(id);
    }

    @PutMapping("/update/{id}")
    public Long updateMember(@PathVariable Long id, @RequestBody RequestUpdateMemberDto updateMemberDto) {
        return memberService.modifiedMember(id, updateMemberDto);
    }

    @DeleteMapping("/delete/{id}")
    public Long deleteMember(@PathVariable Long id) {
        return memberService.removeMember(id);
    }

    @GetMapping("/recommend/{id}")
    public List<ResponseMemberDto> recommendMember(@PathVariable Long id) {
        return memberService.recommendMember(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody RequestLoginMemberDto requestLoginMemberDto) {
        return memberService.login(requestLoginMemberDto.getEmail());
    }
}
