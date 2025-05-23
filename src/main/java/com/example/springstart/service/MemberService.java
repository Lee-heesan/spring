package com.example.springstart.service;


import com.example.springstart.domain.Member;
import com.example.springstart.repository.MemberRepository;
import com.example.springstart.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


//@Service//Ctrl + shift + T : 자동으로 테스트 생성
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    // 회원가입
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 x
//        Optional<Member> result =  memberRepository.findByName(member.getName());
////      Member member1 = result.get(); 직접적으로 바로 꺼내는 것을 권하지 않는다. orElseGet 으로 있으면 끄내고 아니면 디폴트 값을 넣도록 한다.
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }); //ifPresent : 객체를 가지고 있으면 true, 아니면 false
//
        validateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateMember(Member member) {
        // 위 와 다르게 바로 넣어 줄 수 있다.
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    public Optional<Member> findOne(Long id){
        return memberRepository.findById(id);
    }

}
