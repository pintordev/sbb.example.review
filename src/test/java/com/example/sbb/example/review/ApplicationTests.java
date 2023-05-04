package com.example.sbb.example.review;

import com.example.sbb.example.review.answer.Answer;
import com.example.sbb.example.review.answer.AnswerRepository;
import com.example.sbb.example.review.question.Question;
import com.example.sbb.example.review.question.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApplicationTests {
	@Autowired // test 전용 객체 주입 DI, 실제 코드에서는 @RequiredArgsConstructor 사용
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Transactional // Test code 에서 DB 연결이 끊어지는 걸 지연
	@Test
	void TestJpa() {
		// 2번 질문에 달린 답변들 찾고, 1번 답변 내용 확인
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}

}
