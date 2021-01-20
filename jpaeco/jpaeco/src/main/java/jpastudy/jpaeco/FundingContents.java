package jpastudy.jpaeco;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@Getter
public class FundingContents {

    private Long funseq; // 펀딩게시판 글 번호
    private String funtitle; // 글제목
    private String funwriteid; // 글작성자
    private String funcontents; //글내용
    private Date fundate; // 글날짜
}
