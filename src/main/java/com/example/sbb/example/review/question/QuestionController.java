package com.example.sbb.example.review.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
}
