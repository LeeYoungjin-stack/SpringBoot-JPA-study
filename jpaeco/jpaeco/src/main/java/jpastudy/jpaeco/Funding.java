package jpastudy.jpaeco;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Funding {


    @Id
    @Column(name = "funding_id")
    private Long id; //usennum
//
//    @Id
//    @GeneratedValue
//    @Column(name="funding_id")
//    private Long usernum;  // 유저번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "funding")
    private List<Fundingpay> fundingpays = new ArrayList<>();

    @Embedded
    private FundingContents fundingcontents;

//    private Long funseq; // 펀딩게시판 글 번호
//    private String funtitle; // 글제목
//    private String funid; // 글작성자
//    private String funcontents; //글내용
//    private Date fundate; // 글날짜

    @Enumerated(EnumType.STRING)
    private Notice notice;  // 모집마감여부 yes,no

    private int participants; // 모집인원수

    //연관관계 편의 메서드
    public void setMember(Member member) {
        this.member = member;
        member.getFundings().add(this);
    }



}
