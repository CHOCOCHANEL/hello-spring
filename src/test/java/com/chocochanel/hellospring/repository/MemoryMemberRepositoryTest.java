package com.chocochanel.hellospring.repository;

import com.chocochanel.hellospring.domian.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    void afterEach() {
        repository.clearStore();
    }
    @Test
    void save() {
        // given
        Member member = new Member();
        member.setName("choco-chanel");
        // when
        Member result = repository.save(member);
        // then
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findById() {
        // given
        Member member = new Member();
        member.setName("choco-chanel");
        // when
        Member save = repository.save(member);
        Optional<Member> result = repository.findById(member.getId());
        // then
        assertThat(member).isEqualTo(result.get());
    }

    @Test
    void findByName() {
        // given
        String name = "choco-chanel";
        Member member = new Member();
        member.setName(name);
        repository.save(member);
        // when
        Optional<Member> result = repository.findByName(name);
        // then
        assertThat(member).isEqualTo(result.get());
    }

    @Test
    void findAll() {
        // given
        List<String> names = new ArrayList<>();
        List<Member> members = new ArrayList<>();
        names.add("choco");
        names.add("chanel");
        names.forEach(name -> {
            Member member = new Member();
            member.setName(name);
            repository.save(member);
            members.add(member);
        });
        // when
        List<Member> result = repository.findAll();
        // then
        if (members.size() == result.size()) {
            members.forEach(member -> {
                for (Member mem : result) {
                    if (mem.getName().equals(member.getName())) {
                        assertThat(member).isEqualTo(mem);
                    }
                }
            });
        } else {
            fail("size is not the same");
        }
    }
}