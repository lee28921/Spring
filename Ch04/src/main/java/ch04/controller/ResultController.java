package ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResultController {
	@RequestMapping(value="/result/param", method=RequestMethod.GET)
	public String param() {
		return "/result/param";
	}
}
