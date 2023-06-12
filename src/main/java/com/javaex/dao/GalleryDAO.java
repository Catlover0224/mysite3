package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVO;
import com.javaex.vo.UserVO;

@Repository
public class GalleryDAO {

	@Autowired
	SqlSession sqlSession;
	
	public List<GalleryVO> getList() {
		System.out.println("GalleryDAO.getList()");
		
		List<GalleryVO> galleryVOs = sqlSession.selectList("gallery.list");
		System.out.println(galleryVOs);
		
		return galleryVOs;
	}
	
	public void insert(GalleryVO vo) {
		System.out.println("GalleryDAO.insert()");
		
		sqlSession.insert("gallery.insert",vo);
	}

	public UserVO getUserByUserNo(int user_no) {
		
		UserVO vo = sqlSession.selectOne("gallery.userName",user_no);
		System.out.println(vo);
		
		return vo;
	}
}
