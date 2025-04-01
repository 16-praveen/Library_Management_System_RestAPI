package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    
    @Query("SELECT a FROM Member a")
    List<Member> findAllMember();

    @Query("SELECT a FROM Author a WHERE a.id = :id")
    Member findMemberById(int id);
}
