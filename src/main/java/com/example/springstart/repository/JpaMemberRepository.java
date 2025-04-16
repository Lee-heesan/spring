package com.example.springstart.repository;

import com.example.springstart.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager  em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //JPA가 insert쿼리까지 짜줘서 다 넣어줌
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
       Member member = em.find(Member.class, id);
       return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result =  em.createQuery("select m from Member m where m.name = :name ", Member.class)
                .setParameter("name",name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // select m 에서 m은 객체 전체를 의미함. 매핑할 필요 없이 한 줄이면 충분함.
        return em.createQuery("select m from Member as m", Member.class).getResultList(); //JPA query / 객체를 대상으로 쿼리를 날림
    }
}
