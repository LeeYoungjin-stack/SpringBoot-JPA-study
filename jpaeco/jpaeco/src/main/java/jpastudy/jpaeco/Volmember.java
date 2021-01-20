package jpastudy.jpaeco;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Volmember {

    @Id
    @GeneratedValue
    @Column(name = "volmember_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volcalender_id")
    private Volcalender volcalender;

    private String voltitle; //봉사글제목
    private String voldid; // 봉사글작성자

}
