package jpastudy.jpaeco;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // 이 클래스 테이블과 매핑할것입니다. 라고 JPA에게 안내, 그리고 이 클래스는 엔티티클래스가된다
@Getter @Setter // 롬복으로 인해 좀더 편리하게 getter,setter 설정 가능하였음

public class Member {

    @Id // 엔티티클래스의 필드를 테이블의 기본키에 매핑한다 즉, id필드를 기본키 컬럼에 매핑하는것
    @GeneratedValue // 기본키 생성전략 (기본값은 오라클의 시퀀스방식같은 개념)
    private Long id;
    private String username;




}
