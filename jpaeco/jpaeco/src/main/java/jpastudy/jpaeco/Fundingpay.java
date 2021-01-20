package jpastudy.jpaeco;

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
}