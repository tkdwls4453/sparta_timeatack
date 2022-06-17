package com.sparta.timeatack06.repository;

import com.sparta.timeatack06.entity.Gender;
import com.sparta.timeatack06.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByAgeEqualsAndGenderNot(int age, Gender gender);
}
