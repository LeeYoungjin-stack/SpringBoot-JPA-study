package jpastudy.jpaeco;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class FreeComment {

    @Id
    @GeneratedValue
    @Column(name = "freecomment_id")
    private Long id; // comm_seq 게시판번호



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "freeboard_id")
    private Freeboard freeboard;

    private String commentid;
    private String commentcontent;
    Date commentdate;





}
