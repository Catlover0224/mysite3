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

	//리스트
	public List<BoardVO> getList() {
		System.out.println("BoardService.getList()");
		
		List<BoardVO> list =dao.getList();
		
		return list;
	}

	//검색
	public List<BoardVO> search(String title) {
		System.out.println("BoardService.search()");
		List<BoardVO> list =dao.search(title);
		
		return list;
	}

	public void remove(int no) {
		System.out.println("BoardService.remove()");
		dao.remove(no);
	}

	public void insert(BoardVO vo) {
		System.out.println("BoardService.insert()");
		dao.insert(vo);
	}

	public BoardVO read(int no) {
		System.out.println("BoardService.read()");
		BoardVO vo =dao.read(no);
		
		return vo;
	}
}
