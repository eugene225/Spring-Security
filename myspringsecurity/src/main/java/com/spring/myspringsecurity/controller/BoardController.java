package com.spring.myspringsecurity.controller;

import com.spring.myspringsecurity.model.Board;
import com.spring.myspringsecurity.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")  //해당 컨트롤러의 전체 url
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);

        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        if(id==null){
            model.addAttribute("board", new Board());
        }else{
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board", board);
        }
        return "board/form";
    }

    @PostMapping("/form")
    public String boardSubmit(@Valid Board board, BindingResult bindingResult){
        boardRepository.save(board);
        return "redirect:/board/list";
    }

}
