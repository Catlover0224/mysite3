package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class ApiGuestBookController {

	@Autowired
	private GuestbookService guestBookService;
	
	//ajax방명록 첫페이지
	@RequestMapping(value = "/api/guestBook/addList",method = {RequestMethod.GET,RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("ApiGuestBookController.addList");
	
		List<GuestbookVo> guestBookList=guestBookService.getGuestList();
		System.out.println(guestBookList);
		
		model.addAttribute("guestBookList", guestBookList);
		
		return "guestbook/ajaxList";
	}
}
