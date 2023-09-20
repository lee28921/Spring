package ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = {"/","/index"}, method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	@RequestMapping("/greeting")
	public String greeting() {
		return "greeting";
	}
	
	
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:/annotation/param";
	}
	@RequestMapping("/forward")
	public String forward() {
		return "forward:/annotation/model";
	}
}
