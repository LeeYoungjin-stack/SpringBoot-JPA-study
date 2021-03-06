package jpastudy.jpaeco.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Volcalender {

    @Id
    @GeneratedValue
    @Column(name= "volcalender_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "volcalender")
    private List<Volmember> volmembers = new ArrayList<>();


    private String voltitle; //글제목
    private String volid; //글쓴이
    private String volcontent; // 글내용


    @Embedded
    private VolDate voldate; // 봉사날짜관련

    //연관관계 편의 메서드
    public void setMember(Member member) {
        this.member = member;
        member.getVolcalenders().add(this);
    }



}
