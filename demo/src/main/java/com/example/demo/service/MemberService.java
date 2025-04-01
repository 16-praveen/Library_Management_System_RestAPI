package com.example.demo.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberService {
    final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }
    public Member createMember(Member member){
        return memberRepository.save(member);
    }
    
    public List<Member> getAllMember() {
        return memberRepository.findAllMember(); 
    }
    
    public Member getMember(int id) {
        return memberRepository.findMemberById(id);
    }
    // public List<Member> getAllMember()
    // {
    //     return memberRepository.findAll();
    // }
    
    public Page<Member> getAllPage(Pageable pg)
    {
        return memberRepository.findAll(pg);
    }
    public Member updateMember(int id,String name,String email)
   {
    Member member=memberRepository.findById(id).orElseThrow(()->new RuntimeException("member not found"+id));
    if (name!=null) {
        member.setName(name);
    }
    if (email!=null) {
        member.setEmail(email);
    }
    return memberRepository.save(member);
   }
    public void deleteMember(int id)
   {
    if(!memberRepository.existsById(id))
    {
        throw new RuntimeException("user not found"+id);
    }
    memberRepository.deleteById(id);
    }
        
}


