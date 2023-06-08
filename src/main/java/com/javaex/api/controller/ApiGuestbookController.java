package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;
import com.javaex.vo.JsonResult;

@Controller
@RequestMapping(value="/api/guestbook")
public class ApiGuestbookController {

	@Autowired
	private GuestbookService guestbookService;

	/* 방명록 리스트 가져오기 */
	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("ApiGuestbookController.addList()");

		List<GuestbookVo> guestbookList = guestbookService.getGuestList();

		model.addAttribute("guestbookList", guestbookList);

		return "guestbook/ajaxList";
	}

	//방명록 등록
	@ResponseBody
	@RequestMapping(value = "/add",method = {RequestMethod.GET,RequestMethod.POST})
	public JsonResult add(@ModelAttribute GuestbookVo vo) {
		System.out.println("ApiGuestbookController.add()");
		System.out.println(vo);
		
		GuestbookVo gVo = guestbookService.writeResultVo(vo);
		System.out.println(gVo);
		
		//jsonResult에 담기
		JsonResult jsonResult =new JsonResult();
		jsonResult.success(gVo);
		
		return jsonResult;
	}
	
}