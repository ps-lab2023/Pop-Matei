package com.example.Carting.service.implementation;

import com.example.Carting.model.Member;
import com.example.Carting.repository.MemberRepository;
import com.example.Carting.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImplementation implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public MemberServiceImplementation(MemberRepository memberRepository){this.memberRepository = memberRepository;}
    @Override
    public Member createMember(Member member){return memberRepository.save(member);}
    @Override
    public Member findByLastName(String lastName){
        return memberRepository.findMemberByLastName(lastName);
    }
    @Override
    public Member findByFirstName(String firstName){
        return memberRepository.findMemberByFirstName(firstName);
    }
    @Override
    public Member findByEmail(String email){
        return memberRepository.findMemberByEmail(email);
    }
    @Override
    public void deleteMember(String lastName){
        Member deleteMember = memberRepository.findMemberByLastName(lastName);
        memberRepository.delete(deleteMember);
    }
    @Override
    public Member updateMember(Member member){
        Member updateMember = memberRepository.findById(member.getId()).get();
        updateMember.setEmail(member.getEmail());
        updateMember.setPassword(member.getPassword());
        updateMember.setCategories(member.getCategories());
        memberRepository.save(updateMember);
        return updateMember;
    }
//    public Boolean logIn(String email,String password){
//        Member member1 = memberRepository.findMemberByEmail(email);
//        Member member2 = memberRepository.findMemberByPassword(password);
//        if(member1.equals(member2))
//            return true;
//        else
//            return false;
//    }
}
