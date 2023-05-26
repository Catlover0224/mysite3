package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	//main
	@RequestMapping("/main")
	public String main() {
		System.out.println("MainController.main()에 들어갔슘니돠!!!");
		
		return "main";
	} //main().end
	
	//main
	@RequestMapping("/index")
	public String index() {
		System.out.println("MainController.main()에 들어갔슘니돠!!!");
		
		return "index";
	} //main().end
}
