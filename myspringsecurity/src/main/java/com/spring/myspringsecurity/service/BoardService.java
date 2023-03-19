package com.spring.myspringsecurity.service;

import com.spring.myspringsecurity.model.Board;
import com.spring.myspringsecurity.model.User;
import com.spring.myspringsecurity.repository.BoardRepository;
import com.spring.myspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username, Board board) {
        User user = userRepository.findByUsername(username);
        board.setUser(user);

        return boardRepository.save(board);
    }
}
