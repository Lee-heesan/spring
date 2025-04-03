package com.example.springstart.service;


import com.example.springstart.domain.Member;
import com.example.springstart.repository.MemberRepository;
import com.example.springstart.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    
    // 회원가입
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 x
//        Optional<Member> result =  memberRepository.findByName(member.getName());
////      Member member1 = result.get(); 직접적으로 바로 꺼내는 것을 권하지 않는다. orElseGet 으로 있으면 끄내고 아니면 디폴트 값을 넣도록 한다.
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }); //ifPresent : 객체를 가지고 있으면 true, 아니면 false
//


        // 위 와 다르게 바로 넣어 줄 수 있다.
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

        memberRepository.save(member);
        return member.getId();
    }


}
