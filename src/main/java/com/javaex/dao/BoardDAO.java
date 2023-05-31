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

	public List<BoardVO> getList() {
		System.out.println("BoardDAO.getList()");
		List<BoardVO> list = sqlSession.selectList("board.getList");
		System.out.println(list);
		
		return list;
	}

	public List<BoardVO> search(String title) {
		System.out.println("BoardDAO.search()");
		List<BoardVO> list = sqlSession.selectList("board.search",title);
		System.out.println(list);
		
		return list;
	}

	public void remove(int no) {
		System.out.println("BoardDAO.remove()");
		System.out.println(no);
		sqlSession.delete("board.remove",no);
	}

	public void insert(BoardVO vo) {
		System.out.println("BoardDAO.insert()");
		sqlSession.insert("board.insert",vo);
	}

	public BoardVO read(int no) {
		System.out.println("BoardDAO.read()");
		BoardVO vo= sqlSession.selectOne("board.read",no);
		
		return vo;
	}

	public void increaseViews(int no) {
		sqlSession.update("board.increaseViews", no);
	}
}
