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
}
