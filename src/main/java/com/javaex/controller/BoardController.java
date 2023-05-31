package com.javaex.controller;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//보드 리스트
	@RequestMapping("/board/getlist")
	public String list(Model model) {
		System.out.println("BoardController.list()");
		
		List<BoardVO> boardList = boardService.getList();
		
		model.addAttribute("boardList", boardList);
				
		return "/board/list";
	}
	
	//보드 검색
	@RequestMapping(value = "/board/search", method = {RequestMethod.GET, RequestMethod.POST})
	public String search(Model model, @RequestParam("title") String title) {
		System.out.println("BoardController.search()");
		System.out.println(title);
		
		List<BoardVO> boardList = boardService.search(title);
		
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	
	//보드 삭제
	@RequestMapping(value = "/board/remove", method = {RequestMethod.GET,RequestMethod.POST})
	public String remove(@RequestParam("no") int no, Model model) {
		System.out.println("BoardController.remove()");
		
		boardService.remove(no);
		List<BoardVO> boardList = boardService.getList();
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
}
