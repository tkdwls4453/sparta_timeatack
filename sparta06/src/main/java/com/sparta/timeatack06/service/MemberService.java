package com.sparta.timeatack06.service;

import com.sparta.timeatack06.dto.RequestCreateMemberDto;
import com.sparta.timeatack06.dto.RequestUpdateMemberDto;
import com.sparta.timeatack06.dto.ResponseMemberDto;

import java.util.List;

public interface MemberService {
    long saveMember(RequestCreateMemberDto requestCreateMemberDto);

    ResponseMemberDto findMember(Long id);

    long removeMember(Long id);

    long modifiedMember(Long id, RequestUpdateMemberDto requestUpdateMemberDto);

    List<ResponseMemberDto> recommendMember(Long id);

    String login(String email);
}
