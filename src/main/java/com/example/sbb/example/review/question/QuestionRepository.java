package com.example.sbb.example.review.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> { // <Entity, PK T>
    Question findBySubject(String subject); // 매개변수로 받은 subject랑 같은 값을 갖는 question 찾아서 반환
    Question findBySubjectAndContent(String subject, String content); // subject & content 로 조회
    List<Question> findBySubjectLike(String subject); // subject 일부 포함

}
