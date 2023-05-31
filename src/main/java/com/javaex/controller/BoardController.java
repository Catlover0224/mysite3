package com.javaex.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService; 
	
	//보드 리스트
	@RequestMapping("board/list")
	public String list(Model model) {
		System.out.println("BoardController.list()");
		
		//ArrayList<BoardVO> boardList =
		return "/board/list";
	}
}
