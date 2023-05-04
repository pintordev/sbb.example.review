package com.example.sbb.example.review.question;

import com.example.sbb.example.review.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question { // id, subject, content, createDate
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id; // Integer => null 허용

    @Column(length = 200) // column; varchar(200)?
    private String subject;

    @Column(columnDefinition = "TEXT") // column; TEXT
    private String content;

    private LocalDateTime createDate;

    // One(question) to Many(answer); Answer Entity에 선언한 반대로 선언
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // question 삭제 시 question에 속한 answer 모두 삭제
    private List<Answer> answerList; // 데이터가 여러 개이므로 List 선언
}
