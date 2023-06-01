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

	//게시물 삭제
	public void remove(int no) {
		System.out.println("BoardService.remove()");
		dao.remove(no);
	}

	//게시물 등록
	public void insert(BoardVO vo) {
		System.out.println("BoardService.insert()");
		dao.insert(vo);
	}

	//게시물 보기
	public BoardVO read(int no) {
		System.out.println("BoardService.read()");
		BoardVO vo =dao.read(no);
		
		return vo;
	}

	// 조회수 증가
	public void increaseViews(int no) {
		System.out.println("BoardService.increaseViews()");
		dao.increaseViews(no); 
	}

	//수정
	public void update(BoardVO vo) {
		System.out.println("BoardService.update()");
		dao.update(vo);
	}

}
