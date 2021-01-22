package jpastudy.jpaeco.controller;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter @Setter
public class FreeBoardForm {

    private Long freeseq;
    private String id;
    private String title;
    private String content;
    private LocalDateTime freedate;


}
