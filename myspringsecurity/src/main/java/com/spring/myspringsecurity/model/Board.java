package com.spring.myspringsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2, max=30, message = "제목은 2자이상 30자 이하입니다.")
    private String title;

    @NotNull
    @Size(min=2, max=50)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")  //referencedColumnName 생략가능
    @JsonIgnore
    private User user;
}
