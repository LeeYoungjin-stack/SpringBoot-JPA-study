package jpastudy.jpaeco;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@Getter
public class VolDate {

    private Date volrecdate; //모집날짜
    private Date volrecenddate; //모집종료날짜
    private Date volstartdate; // 봉사시작날짜
    private Date volenddate; //봉사 종료날짜

}
