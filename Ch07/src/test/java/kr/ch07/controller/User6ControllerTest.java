package kr.ch07.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class User6ControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	// 테스트 케이스
	public void register() {
		
	}
	
	@Test
	public void list() throws Exception {
		mvc
		.perform(get("/user6/list"))				//index 요청 테스트
		.andExpect(status().isOk())			// 요청 결과 상태 테스트
		.andExpect(view().name("/user6/list"))	// 반환되는 View 이름 테스트
		.andDo(print());					// 요청 테스트 결과 출력
	}
	
	public void modify() {
		
	}
}
