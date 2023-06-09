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

	public int update(UserVO vo) {
		System.out.println("UserService.update()");
		
		int cnt =dao.update(vo);
		
		return cnt;
	}
	
	//아이디 체크
	public boolean idCheck(String id) {
		System.out.println("UserService.idCheck()");
		UserVO vo = dao.idCheck(id);
		boolean result;
		
		if(vo==null) {
			result=true;
		}else {
			result=false;
		}
		System.out.println("idCheck."+result);
		
		return result;
	}

}
