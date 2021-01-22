package jpastudy.jpaeco.controller;


import jpastudy.jpaeco.Service.FreeboardService;
import jpastudy.jpaeco.domain.Address;
import jpastudy.jpaeco.domain.Freeboard;
import jpastudy.jpaeco.repository.FreeboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final FreeboardService freeboardService;


    @GetMapping("/freeboard")
    public String freeboard(Model model) {
        List<Freeboard> freeboards = freeboardService.findFreeBoards();
        model.addAttribute("freeboards", freeboards);
        return "board/freeboard";
    }


    //@RequestParam 글수정할떄 필요한 파라미터, 글을쓸때는 파라미터가필요없기때문에 false로 설정
    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {

        if (id == null) {
            model.addAttribute("FreeBoardForm", new FreeBoardForm());
        }else{
            Freeboard freeboard = freeboardService.findOne(id);
            model.addAttribute("FreeBoardForm",freeboard);
        }

        return "board/form";
    }

//    @GetMapping("/form/{freeboardId}/edit")
//    public String updateFreeboard(@PathVariable("freeboardId") Long freeboardId, Model model) {
//        Freeboard freeboard = (Freeboard) freeboardService.findOne(itemId);
//
//
//    }



    // BindingResult 부분은 오류생성시 오류내용을 포함하여 실행하게끔해줌
    @PostMapping("/form")
    public String greetingSubmit(@Valid  FreeBoardForm form, BindingResult result){

        if (result.hasErrors()) {
            return "board/form";
        }

        Freeboard freeboard = new Freeboard();
        freeboard.setId(form.getId());
        freeboard.setTitle(form.getTitle());
        freeboard.setContent(form.getContent());
        freeboard.setFreedate(LocalDateTime.now());
        freeboardService.save(freeboard);
        return "redirect:/board/freeboard";

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
