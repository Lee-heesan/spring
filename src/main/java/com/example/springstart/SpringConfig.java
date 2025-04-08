package com.example.springstart;

import com.example.springstart.repository.MemberRepository;
import com.example.springstart.repository.MemoryMemberRepository;
import com.example.springstart.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
