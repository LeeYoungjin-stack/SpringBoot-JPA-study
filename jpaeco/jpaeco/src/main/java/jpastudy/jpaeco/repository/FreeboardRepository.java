package jpastudy.jpaeco.repository;


import jpastudy.jpaeco.domain.Freeboard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FreeboardRepository {

    private final EntityManager em;

    //글 저장
    public void save(Freeboard freeboard) {
        em.persist(freeboard);
    }

    //글 모두조회
    public List<Freeboard> findAll() {
        return em.createQuery("select fb from Freeboard fb", Freeboard.class)
                .getResultList();
    }

    //글 하나조회
    public Freeboard findOne(Long id) {
        return em.find(Freeboard.class, id);
    }
}
