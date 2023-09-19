package ch03.sub3;

import org.springframework.stereotype.Component;


@Component("service2")
public class Service {
	
	public void insert() {
		System.out.println("Core corencern - insert...1");
	}
	
	
	public void select() {
		System.out.println("Core corencern - select...1");
	}
	
	
	public void update(int no) {
		System.out.println("Core corencern - update...1");
	}
	
	
	public void delete(int no, String name) {
		System.out.println("Core corencern - delete...1");
	}
}
