package jpastudy.jpaeco.repository;


import jpastudy.jpaeco.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor // final 달린 녀석 생성자 잡아주고 persistencecontext 주입 시켜줌(엔티티매니저같은경우)
public class MemberRepository {

    private final EntityManager em;


    //회원 저장
    public void save(Member member) {
        em.persist(member);
    }

    //회원 1명 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    //회원 모두조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //이름에 의해서 회원조회
    public List<Member> findByName(String username) {
        return em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", username)
                .getResultList();
    }

    //id 에 의해서 회원조회
    public List<Member> findById(String userid){
        return em.createQuery("select m from Member m where m.userid = :userid", Member.class)
                .setParameter("userid", userid)
                .getResultList();

    }


}
