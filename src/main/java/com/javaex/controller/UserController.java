package com.javaex.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 회원가입 폼
	@RequestMapping("/user/joinForm")
	public String joinForm() {
		System.out.println("UesrController.joinForm()에 들어갔슘니돠!!!");

		return "/user/joinForm";
	} // joinForm().end

	// 회원가입
	@RequestMapping(value = "/user/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVO vo) {
		System.out.println("UesrController.join()에 들어갔슘니돠!!!");

		int cnt = userService.join(vo);
		if (cnt > 0) {
			return "/user/joinOk";
		} else {
			return "redirect:/user/joinForm";
		}
	}// join().end

	// 로그인 폼
	@RequestMapping(value = "/user/loginForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {
		System.out.println("UesrController.loginForm()에 들어갔슘니돠!!!");

		return "/user/loginForm";
	}//loginForm().end

	// 로그인
	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVO vo, HttpSession session) {
		System.out.println("UesrController.login()에 들어갔슘니돠!!!");
		System.out.println("UesrController.login()" + vo);

		UserVO user = userService.login(vo);
		System.out.println(user);

		session.setAttribute("user", user);
		if(user !=null) {
			System.out.println("로그인성공");
			return "redirect:/main";
		}else {
			System.out.println("로그인실패");
			return "/user/loginForm";
		}
	}//login().end
	
	// 로그아웃
	@RequestMapping(value = "/user/logout", method = {RequestMethod.GET})
	public String logout(HttpSession session) {
		System.out.println("UesrController.logout()에 들어갔슘니돠!!!");
		
		session.invalidate();
		return "redirect:/main";
	}//logout().end
	
	//모디퐈이
	@RequestMapping(value = "/user/modifyForm")
	public String modifyForm(HttpSession session, Model model) {
		System.out.println("UesrController.modifyForm()에 들어갔슘니돠!!!");
		
		UserVO vo = (UserVO)session.getAttribute("user");
		System.out.println("UesrController.modifyForm()" + vo);
		
		
		return "/user/modifyForm";
	}//modifyForm().end
	
	//수정~
	@RequestMapping(value = "/user/update", method = {RequestMethod.GET,RequestMethod.POST})
	public String update(@ModelAttribute UserVO vo) {
		System.out.println("UesrController.update()에 들어갔슘니돠!!!");
		System.out.println("UesrController.update()" + vo);
		
		if(userService.update(vo)>0) {
			System.out.println("업데이트성공");
			return "redirect:/main";
		}else {
			System.out.println("업데이트실패");
			return "/user/modifyForm";
		}
		

	}//update().end
}
