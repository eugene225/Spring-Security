package com.spring.myspringsecurity.controller;

import com.spring.myspringsecurity.model.Board;
import com.spring.myspringsecurity.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardApiController {

    @Autowired
    private BoardRepository boardRepository;

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/boards")
    List<Board> all() {
        return boardRepository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/boards")
    Board newEmployee(@RequestBody Board newBoard) {
        return boardRepository.save(newBoard);
    }

    // Single item

    @GetMapping("/boards/{id}")
    Board one(@PathVariable Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    @PutMapping("/boards/{id}")
    Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {

        return boardRepository.findById(id)
                .map(board -> {
                    board.setTitle(newBoard.getTitle());
                    board.setContent(newBoard.getContent());
                    return boardRepository.save(board);
                })
                .orElseGet(() -> {
                    newBoard.setId(id);
                    return boardRepository.save(newBoard);
                });
    }

    @DeleteMapping("/boards/{id}")
    void deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
    }

}
