package kr.ch07.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ch07.dto.User6DTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class User6MapperTest {
	
	@Autowired
	private User6Mapper mapper;
	
	@Test
	public void insertUser6() {
		
		User6DTO user6 = User6DTO.builder()
				.uid("test01")
				.name("홍길동")
				.birth("2001-01-01")
				.gender("M")
				.age(22)
				.addr("경기도 수원시")
				.hp("010-1234-1001")
				.build();
		mapper.insertUser6(user6);
	};
	public void selectUser6(String uid) {
		
	};
	public void selectUser6s(){
		
	};
	public void updateUser6(User6DTO dto) {
		
	};
	public void deleteUser6(String uid) {
		
	};
}
