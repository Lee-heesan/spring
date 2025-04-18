package com.example.springstart;

import com.example.springstart.aop.TimetraceAop;
import com.example.springstart.repository.*;
import com.example.springstart.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    //Qualifier 넣은 이유: WebClinet를 Bean으로 등록했는데 요청해야 할 url이 많아서 여러개의 WebClient를 등록하면서 문제가 발생
    public SpringConfig(@Qualifier("springDataJpaMemberRepository")MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService(){
//        return new MemberService(memberRepository());
        return  new MemberService(memberRepository);
    }

// 여기서 Bean해주고 써도 되고 TimeTraceAop에 @Component 해줘도 된다.
//    @Bean
//    public TimetraceAop timetraceAop(){
//         return new TimetraceAop();
//    }


//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();
////        return new JDBCMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//    }
}
