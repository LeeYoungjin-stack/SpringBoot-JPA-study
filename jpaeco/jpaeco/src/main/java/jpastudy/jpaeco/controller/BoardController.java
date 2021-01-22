package jpastudy.jpaeco.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {


    @GetMapping("/freeboard")
    public String freeboard() {
        return "board/freeboard";
    }

    @GetMapping("/fundingboard")
    public String fundingboard() {
        return "board/fundingboard";
    }

    @GetMapping("/volcalboard")
    public String volcalboard() {
        return "board/volcalboard";
    }


}
