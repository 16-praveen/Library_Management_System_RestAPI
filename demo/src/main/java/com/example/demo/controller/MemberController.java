package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/members")
public class MemberController {
    public MemberService memberService;
    
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }
    @PostMapping
    
    public  ResponseEntity<Object> createMember(@RequestBody Member member) {

        Member member2 = memberService.createMember(member);
        return ResponseEntity.ok(member2);
    }    
    @GetMapping
    public ResponseEntity<List<Member>> getAllMember()
    {
        return ResponseEntity.ok(memberService.getAllMember());
    }
        @GetMapping("{id}")
    public ResponseEntity<Object> getMember(@PathVariable("id") int id) {
         Member member = memberService.getMember(id);
        if (member == null) {
        return ResponseEntity.status(404).body("Author not found with ID: " + id);
    }
        return ResponseEntity.ok(member);
}

    // @GetMapping("{id}")
    // public ResponseEntity<Object>getmember(@PathVariable("id") int id)
    // {
    //     Member member= memberService.getMember(id);
    //     return ResponseEntity.status(200).body(member);
    // }
    @GetMapping("paginate")
        public Page<Member>getAllPage(Pageable pg)
        {
        return memberService.getAllPage(pg);
        }
    @PutMapping("{id}")
    public ResponseEntity<Object>updateMember (@PathVariable("id") int id,@RequestBody Member member)
    {
        memberService.updateMember(id,member.getName(),member.getEmail());
        return ResponseEntity.ok("Updates Success");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object>deleteMember(@PathVariable("id") int id)
    {
        memberService.deleteMember(id);
        return ResponseEntity.ok("Deleted SuccessFully");
    }
    
    

}
    




