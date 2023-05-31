package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDAO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
}
