package com.spring.myspringsecurity.repository;

import com.spring.myspringsecurity.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
