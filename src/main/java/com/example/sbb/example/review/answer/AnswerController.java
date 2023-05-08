package com.example.sbb.example.review.answer;

import com.example.sbb.example.review.question.Question;
import com.example.sbb.example.review.question.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult) {
        // 전달된 content 데이터를 받는 방법 (답변 컨트롤러 만들기)
        Question question = this.questionService.getQuestion(id);
        // 답변 저장
        if (bindingResult.hasErrors()) {
            // 에러 발생 시 질문 상세 목록 다시 렌더링
            model.addAttribute("question", question); // 렌더링을 위해 question 객체를 model로 넘겨줘야 함
            return "question_detail";
        } else {
            this.answerService.create(question, answerForm.getContent());
            // 답변 작성 완료 후 원래 있던 페이지로 redirect; question/detail/{id}
            return String.format("redirect:/question/detail/%s", id);
        }
    }
}
