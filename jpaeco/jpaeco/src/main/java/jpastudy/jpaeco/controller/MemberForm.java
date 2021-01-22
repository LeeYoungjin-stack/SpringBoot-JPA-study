package jpastudy.jpaeco.controller;

import jpastudy.jpaeco.domain.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "ID를 입력해주세요")
    private String userid;

    private String username;
    private String pw;
    private int phone;
    private String email;

    @Embedded
    private Address address;


}
