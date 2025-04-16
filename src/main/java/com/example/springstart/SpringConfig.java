package com.example.springstart;

import com.example.springstart.repository.*;
import com.example.springstart.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    public SpringConfig (DataSource dataSource){
//        this.dataSource = dataSource;
//    }


//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }

    private final MemberRepository memberRepository;


    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService(){
//        return new MemberService(memberRepository());
        return  new MemberService(memberRepository);
    }


//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();
////        return new JDBCMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//    }
}
