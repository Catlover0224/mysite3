package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	/* 방명록 리스트 가져오기 */
	public List<GuestbookVo> selectGuestList() {
		System.out.println("GuestbookDao.selectList()");

		List<GuestbookVo> guestbookList = sqlSession.selectList("guestbook.selectList");
		return guestbookList;
	}

	
	/* 방명록 글 저장 */
	public int insertGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.insertGuest()");
		
		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		return count;
	}

	
	/* 방명록 글 삭제 */
	public int deleteGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.deleteGuest()");

		return sqlSession.delete("guestbook.delete", guestbookVo);
	}

	
	
	
	

	/*
	// 방명록 글 저장 -ajax
	public int insertGuestbookKey(GuestbookVo guestbookVo) {
		System.out.println("[guestbookDao.insertGuestbookKey()]");
		
		return sqlSession.insert("guestbook.insertGuestbookKey", guestbookVo);
	}
	
	
	// 방명록 글 가져오기 -ajax
	public GuestbookVo selectGuestbook(int no) {
		System.out.println("[guestbookDao.selectGuestbook()]");
		
		return sqlSession.selectOne("guestbook.selelctGuestbook", no);
	}
	*/
	
	
	
	
	
	
	
	
}