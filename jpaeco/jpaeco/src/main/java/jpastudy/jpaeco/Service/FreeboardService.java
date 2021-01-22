package jpastudy.jpaeco.Service;

import jpastudy.jpaeco.domain.Freeboard;
import jpastudy.jpaeco.repository.FreeboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FreeboardService {

    private final FreeboardRepository freeboardRepository;


    /**
     *
     * 자유게시판 글저장
     */
    @Transactional
    public Long save(Freeboard freeboard) {

        freeboardRepository.save(freeboard);
        return freeboard.getFreeseq();
    }


    /**
     * 자유게시판 글 전체조회
     */
    public List<Freeboard> findFreeBoards() {
        return freeboardRepository.findAll();
    }

    public Freeboard findOne(Long itemId) {
        return freeboardRepository.findOne(itemId);
    }






}
