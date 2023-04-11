package com.example.Carting.service;

import com.example.Carting.model.Member;
import com.example.Carting.repository.MemberRepository;
import com.example.Carting.service.implementation.MemberServiceImplementation;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MemberServiceTest {
    private static final String MEMBER_LAST_NAME = "Aurelius";
    private static final String MEMBER_FIRST_NAME = "Marcus";
    private static final String EMAIL = "email@email.com";
    private static final String NOT_MEMBER_LAST_NAME = "NotAurelius";
    private static final String NOT_MEMBER_FIRST_NAME = "NotMarcus";
    private static final String NOT_EMAIL = "NOTemail@email.com";
    private MemberServiceImplementation memberServiceImplementation;

    @Mock
    private MemberRepository memberRepository;
    private Member member;

    @BeforeEach
    void init(){
        initMocks(this);
        member = new Member();
        member.setLastName(MEMBER_LAST_NAME);
        member.setFirstName(MEMBER_FIRST_NAME);
        member.setEmail(EMAIL);
        when(memberRepository.findMemberByLastName(MEMBER_LAST_NAME)).thenReturn(member);
        when(memberRepository.findMemberByFirstName(MEMBER_FIRST_NAME)).thenReturn(member);
        when(memberRepository.findMemberByEmail(EMAIL)).thenReturn(member);
    }

    @Test
    void testFindByFirstName_whenExisting(){
        memberServiceImplementation = new MemberServiceImplementation(memberRepository);
        Member member = memberServiceImplementation.findByFirstName(MEMBER_FIRST_NAME);
        assertNotNull(member);
        assertEquals(MEMBER_FIRST_NAME,member.getFirstName());
    }
    @Test
    void testFindByFirstName_whenNonExisting(){
        memberServiceImplementation = new MemberServiceImplementation(memberRepository);
        Member member = memberServiceImplementation.findByFirstName(NOT_MEMBER_FIRST_NAME);
        assertNull(member);
    }
    @Test
    void testFindByLastName_whenExisting(){
        memberServiceImplementation = new MemberServiceImplementation(memberRepository);
        Member member = memberServiceImplementation.findByLastName(MEMBER_LAST_NAME);
        assertNotNull(member);
        assertEquals(MEMBER_LAST_NAME,member.getLastName());
    }
    @Test
    void testFindByLastName_whenNonExisting(){
        memberServiceImplementation = new MemberServiceImplementation(memberRepository);
        Member member = memberServiceImplementation.findByLastName(NOT_MEMBER_LAST_NAME);
        assertNull(member);
    }
    @Test
    void testFindByEmail_whenExisting(){
        memberServiceImplementation = new MemberServiceImplementation(memberRepository);
        Member member = memberServiceImplementation.findByEmail(EMAIL);
        assertNotNull(member);
        assertEquals(EMAIL,member.getEmail());
    }
    @Test
    void testFindByEmail_whenNonExisting(){
        memberServiceImplementation = new MemberServiceImplementation(memberRepository);
        Member member = memberServiceImplementation.findByEmail(NOT_EMAIL);
        assertNull(member);
    }
}
