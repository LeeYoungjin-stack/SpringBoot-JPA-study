package jpastudy.jpaeco.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Freeboard {

    @Id
    @GeneratedValue
    @Column(name = "freeboard_id")
    private Long freeseq;

    private String id;
    private String title;
    private String content;
    private LocalDateTime freedate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "freeboard")
    private List<FreeComment> freecomments = new ArrayList<>();


    //연관관계 편의 메서드
    public void setMember(Member member) {
        this.member = member;
        member.getFreeboards().add(this);
    }








}
