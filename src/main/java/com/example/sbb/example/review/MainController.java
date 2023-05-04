package com.example.sbb.example.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    // ROOT URL Setting
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "redirect:/question/list"; // ROOT URL 접속 시 /question/list 로 redirect
    }
}
