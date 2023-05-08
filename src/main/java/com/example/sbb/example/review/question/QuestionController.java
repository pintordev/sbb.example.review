package com.example.sbb.example.review.question;

import com.example.sbb.example.review.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question") // QuestionController로 들어오는 모든 요청에 대한 접두 URL setting?
@RequiredArgsConstructor // 생성자 자동 생성 애너테이션
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list") // 실제 URL => /question/list
    public String list(Model model) { // Model 객체를 이용하여 controller 상의 데이터를 template에 전달 가능
        // question list를 template에 전달
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList); // questionList 데이터를 "questionList" 라는 이름으로 template에 전달
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}") // 실제 URL => /question/detail/#
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String createQuestion(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    public String createQuestion(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        } else {
            this.questionService.create(questionForm.getSubject(), questionForm.getContent());
            return "redirect:/question/list";
        }
    }
}
