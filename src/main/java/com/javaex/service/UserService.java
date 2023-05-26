package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDAO;
import com.javaex.vo.UserVO;


@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	
	public int join(UserVO vo) {
		System.out.println("UserService.join()");
		
		int cnt= dao.insertUser(vo);
		
		return cnt;
	}

	public UserVO login(UserVO vo) {
		System.out.println("UserService.login()");
		
		UserVO user = dao.login(vo);
		
		return user;
	}

}
