package com.javaex.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//보드 리스트
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("BoardController.list()");
		
		List<BoardVO> boardList = boardService.getList();
		
		model.addAttribute("boardList", boardList);
				
		return "/board/list";
	}
	
	//보드 검색
	@RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
	public String search(Model model, @RequestParam("title") String title) {
		System.out.println("BoardController.search()");
		System.out.println(title);
		
		List<BoardVO> boardList = boardService.search(title);
		
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	
	//보드 삭제
	@RequestMapping(value = "/remove", method = {RequestMethod.GET,RequestMethod.POST})
	public String remove(@RequestParam("no") int no) {
		System.out.println("BoardController.remove()");
		
		boardService.remove(no);
		
		return "redirect:/board/list";
	}
	
	//보드 추가폼
	@RequestMapping("/writeForm")
	public String writeForm(HttpSession session, @ModelAttribute BoardVO vo) {
		System.out.println("BoardController.writeForm()");
		
		return "/board/writeForm";
	}
	
	//보드 추가
	@RequestMapping("/insert")
	public String insert(HttpSession session, @ModelAttribute BoardVO vo) {
		System.out.println("BoardController.insert()");
		UserVO userVO =(UserVO)session.getAttribute("user");
		System.out.println(userVO);
		System.out.println(vo);
		vo.setWriter(userVO.getUserName());
		System.out.println(vo);
		
		boardService.insert(vo);
		
		return "redirect:/board/list";
	}
	
	// 보드 보기
	@RequestMapping("/read")
	public String read(@RequestParam("no") int no, Model model) {
		System.out.println("BoardController.read()");
		System.out.println(no);

		boardService.increaseViews(no); // 조회수 증가 메서드 호출
			
		BoardVO vo = boardService.read(no);
		model.addAttribute("board", vo);

		return "/board/read";
	}
	
	//보드 수정폼
	@RequestMapping(value = "/modifyForm", method = {RequestMethod.GET,RequestMethod.POST})
	public String modifyForm(@RequestParam("no") int no, Model model) {
		System.out.println("BoardController.modifyForm()");
		
		BoardVO vo = boardService.read(no);
		model.addAttribute("board", vo);
		
		return "/board/modifyForm";
	}
	
	//보드 수정
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public String update(@ModelAttribute BoardVO vo) {
		System.out.println("BoardController.update()");
		System.out.println(vo);
		
		boardService.update(vo);
		
		return "";
	}
	
	
}
