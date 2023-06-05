package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public int insertUser(UserVO vo) {
		System.out.println("UserDAO.insertUser() 에 들어갔슘니돠!!!");
		System.out.println("UserDAO : "+vo);
		
		int count= sqlSession.insert("user.insert",vo);
		
		if(count>0) {
			System.out.println("등록성공이다냥");
		}else {
			System.out.println("등록실패이다냥");
		}
		
		return count;
	}

	public UserVO login(UserVO vo) {
		System.out.println("UserDAO.login() 에 들어갔슘니돠!!!");
		System.out.println("UserDAO : "+vo);
		UserVO user = sqlSession.selectOne("user.login",vo);
		
		return user;
	}

	public int update(UserVO vo) {
		System.out.println("UserDAO.update() 에 들어갔슘니돠!!!");
		System.out.println("UserDAO : "+vo);
		int count = sqlSession.update("user.update",vo);
		System.out.println(count);
		
		return count;
	}

	//아이디 체크
	public UserVO idCheck(String id) {
		System.out.println("UserDAO.idCheck() 에 들어갔슘니돠!!!");
		
		UserVO vo = sqlSession.selectOne("user.idCheck", id);
		System.out.println(vo);
		
		return vo;
	}
}
