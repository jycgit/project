package kr.co.joy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex08Controller {

	@RequestMapping("/ex14.do")
	public String ex14() {
		System.out.println("ex14....");
		return "ex01";
	}
}
