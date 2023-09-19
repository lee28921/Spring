package ch03.sub2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2023/09/19
 * 이름 : 이지민
 * 내용 : 스프링 XML기반 AOP 실습하기
 * 
 * 
 * 스프링 AOP(Aspect Oriented Programming)
 * - AOP는 관점지향 프로그래밍으로 OOP로 독립적으로 분리하기 어려운 
 */
public class AOPTest {
	public static void main(String[] args) {
		
		// 스프링 컨텍스트 객체 생성(컨테이너)
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		// Service 객체 가져오기
		Service service = (Service) ctx.getBean("service1");
		
		// 핵심관심 실행
		service.insert();
		service.select();
		service.update(1);
		service.delete(1,"홍길동");
	}
}
