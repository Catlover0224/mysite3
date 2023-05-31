package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDAO;
import com.javaex.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;

	public List<BoardVO> getList() {
		System.out.println("BoardService.getList()");
		
		List<BoardVO> list =dao.getList();
		
		return list;
	}
}
