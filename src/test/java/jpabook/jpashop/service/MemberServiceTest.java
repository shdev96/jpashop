package jpabook.jpashop.service;

import jpabook.jpashop.entity.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
@RequiredArgsConstructor
class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Test
    void register() throws Exception {
        Member member = Member.builder()
                .name("Admin")
                .build();

        Long savedId = memberService.join(member);

        Assertions.assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    void duplicateRegister() throws Exception {
        Member member = Member.builder()
                .name("admin")
                .build();

        Member duplicateMember = Member.builder()
                .name("admin")
                .build();

        memberService.join(member);
        Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(duplicateMember));
    }
}