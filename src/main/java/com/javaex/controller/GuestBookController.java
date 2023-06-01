package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.GuestBookService;

@Controller
@RequestMapping("/guestBook")
public class GuestBookController {

	@Autowired
	private GuestBookService guestBookService;
	
	@RequestMapping("/addListForm")
	public String addListForm() {
		System.out.println("GuestBookController.addListForm");
		
		return "/guestbook/addList";
	}
	
}
