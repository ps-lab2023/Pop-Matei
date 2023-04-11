package com.example.Carting.repository;

import com.example.Carting.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member,Long> {
    Member findMemberByFirstName(String firstName);
    Member findMemberByLastName(String lastName);
    Member findMemberByEmail(String email);
}
