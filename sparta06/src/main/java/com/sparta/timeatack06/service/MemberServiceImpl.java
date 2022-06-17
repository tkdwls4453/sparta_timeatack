package com.sparta.timeatack06.service;

import com.sparta.timeatack06.dto.RequestCreateMemberDto;
import com.sparta.timeatack06.dto.RequestUpdateMemberDto;
import com.sparta.timeatack06.dto.ResponseMemberDto;
import com.sparta.timeatack06.entity.Gender;
import com.sparta.timeatack06.entity.Member;
import com.sparta.timeatack06.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public long saveMember(RequestCreateMemberDto requestCreateMemberDto) {
        Member member = new Member(
                requestCreateMemberDto.getEmail(),
                requestCreateMemberDto.getName(),
                requestCreateMemberDto.getAge(),
                requestCreateMemberDto.getGender() == 0 ? Gender.M : Gender.F
        );
        return memberRepository.save(member).getId();
    }

    @Override
    public ResponseMemberDto findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        return new ResponseMemberDto(
                member.getEmail(),
                member.getName(),
                member.getAge(),
                member.getGender() == Gender.M ? 0 : 1
        );
    }

    @Override
    public long removeMember(Long id) {
        memberRepository.deleteById(id);
        return id;
    }

    @Override
    public long modifiedMember(Long id, RequestUpdateMemberDto requestUpdateMemberDto) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        member.updateProfile(requestUpdateMemberDto);
        return memberRepository.save(member).getId();
    }

    @Transactional
    @Override
    public List<ResponseMemberDto> recommendMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        List<Member> memberList = memberRepository.findAllByAgeEqualsAndGenderNot(member.getAge(), member.getGender());
        List<ResponseMemberDto> resultList = new LinkedList<ResponseMemberDto>();
        for (Member matchMember : memberList) {
            resultList.add(new ResponseMemberDto(
                    matchMember.getEmail(),
                    matchMember.getName(),
                    matchMember.getAge(),
                    matchMember.getGender() == Gender.M ? 0 : 1
            ));
        }
        return resultList;
    }
}
