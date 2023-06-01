package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDAO;

@Service
public class GuestBookService {
 
	@Autowired
	private GuestBookDAO dao;
}
