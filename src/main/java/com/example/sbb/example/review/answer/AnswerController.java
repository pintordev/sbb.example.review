package com.example.sbb.example.review.answer;

import com.example.sbb.example.review.question.Question;
import com.example.sbb.example.review.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    @PostMapping("/create/{id}") // method = post로 데이터가 전달되므로
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        // 전달된 content 데이터를 받는 방법 (답변 컨트롤러 만들기)
        Question question = this.questionService.getQuestion(id);
        // 답변 저장
        this.answerService.create(question, content);
        // 답변 작성 완료 후 원래 있던 페이지로 redirect; question/detail/{id}
        return String.format("redirect:/question/detail/%s", id);

    }
}
