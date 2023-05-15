package jpabook.jpashop.repository;

import jpabook.jpashop.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager entityManager;

    public void save(Member member) {
        entityManager.persist(member);
    }

    public Member findOne(Long id) {
        return entityManager.find(Member.class, id);
    }

    public List<Member> findAll() {
        return entityManager
                .createQuery("SELECT M FROM Member M", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return entityManager
                .createQuery("SELECT M FROM Member M WHERE M.name like :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
