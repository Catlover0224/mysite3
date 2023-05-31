package com.javaex.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.javaex.vo.UserVO;

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
	
	//보드 추가폼
	@RequestMapping("/board/writeForm")
	public String writeForm(HttpSession session, @ModelAttribute BoardVO vo) {
		System.out.println("BoardController.writeForm()");
		
		return "/board/writeForm";
	}
	
	//보드 추가
	@RequestMapping("/board/insert")
	public String insert(HttpSession session, @ModelAttribute BoardVO vo, Model model) {
		System.out.println("BoardController.insert()");
		UserVO userVO =(UserVO)session.getAttribute("user");
		System.out.println(userVO);
		System.out.println(vo);
		vo.setWriter(userVO.getUserName());
		System.out.println(vo);
		
		boardService.insert(vo);
		
		List<BoardVO> boardList = boardService.getList();
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	
	//보드 보기
	@RequestMapping("/board/read")
	public String read(@RequestParam("no") int no, Model model) {
		System.out.println("BoardController.read()");
		System.out.println(no);
		
		BoardVO vo = boardService.read(no);
		model.addAttribute("board", vo);
		
		return "/board/read";
	}
	
	//보드 수정폼
	public String modifyForm() {
	
		return null;
	}
	
	
}
