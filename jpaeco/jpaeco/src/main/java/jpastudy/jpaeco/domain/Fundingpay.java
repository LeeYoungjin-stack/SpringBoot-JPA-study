package jpastudy.jpaeco.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Fundingpay {

    @Id
    @GeneratedValue
    @Column(name = "fundingpay_id")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funding_id")
    private Funding funding;

    private String funid; // 후원아이디
    private int funpay;


    //연관관계편의메서드
    public void setFunding(Funding funding) {
        this.funding= funding;
        funding.getFundingpays().add(this);
    }
}
