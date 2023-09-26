package kr.ch07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 컴포넌트 스캔 어노테이션
@SpringBootApplication
public class Ch07Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch07Application.class, args);
		
		System.out.println("Hello Spring Boot!");
	}

}
