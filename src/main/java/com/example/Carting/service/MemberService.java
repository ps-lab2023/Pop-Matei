package com.example.Carting.service;

import com.example.Carting.model.Member;

public interface MemberService {
    Member createMember(Member member);
    Member findByLastName(String lastName);
    Member findByFirstName(String firstName);
    Member findByEmail(String email);
    void deleteMember(String lastName);
    Member updateMember(Member member);
}