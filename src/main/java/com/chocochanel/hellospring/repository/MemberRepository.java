package com.chocochanel.hellospring.repository;

import com.chocochanel.hellospring.domian.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public Member save(Member member);
    public Optional<Member> findById(Long id); // Optional - since java8
    public Optional<Member> findByName(String name);
    public List<Member> findAll();
}
