package com.javaex.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	//리스트
	public List<BoardVO> getList() {
		System.out.println("BoardDAO.getList()");
		List<BoardVO> list = sqlSession.selectList("board.getList");
		System.out.println(list);
		
		return list;
	}
	
	//검색
	public List<BoardVO> search(String title) {
		System.out.println("BoardDAO.search()");
		List<BoardVO> list = sqlSession.selectList("board.search",title);
		System.out.println(list);
		
		return list;
	}

	//삭제
	public void remove(int no) {
		System.out.println("BoardDAO.remove()");
		System.out.println(no);
		sqlSession.delete("board.remove",no);
	}

	//등록
	public void insert(BoardVO vo) {
		System.out.println("BoardDAO.insert()");
		sqlSession.insert("board.insert",vo);
	}

	//개시물 보기
	public BoardVO read(int no) {
		System.out.println("BoardDAO.read()");
		BoardVO vo= sqlSession.selectOne("board.read",no);
		
		return vo;
	}

	//조회수 증가
	public void increaseViews(int no) {
		sqlSession.update("board.increaseViews", no);
	}

	//수정
	public void update(BoardVO vo) {
		sqlSession.update("board.update", vo);
	}
}
