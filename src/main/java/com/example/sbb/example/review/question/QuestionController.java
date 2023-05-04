package com.example.sbb.example.review.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor // 생성자 자동 생성 애너테이션
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list(Model model) { // Model 객체를 이용하여 controller 상의 데이터를 template에 전달 가능
        // question list를 template에 전달
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList); // questionList 데이터를 "questionList" 라는 이름으로 template에 전달
        return "question_list";
    }
}
