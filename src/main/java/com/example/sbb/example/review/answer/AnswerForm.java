package com.example.sbb.example.review.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
    // 내용 필수항목..
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}
