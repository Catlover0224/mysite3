package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao guestbookDao;

	/* 방명록 리스트 가져오기 */
	public List<GuestbookVo> getGuestList() {
		System.out.println("GuestbookService.getGuestList()");
		 
		List<GuestbookVo> guestbookList = guestbookDao.selectGuestList();
		return guestbookList;
	}

	
	/* 방명록 글 저장 */
	public int writeGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.write()");

		int count = guestbookDao.insertGuest(guestbookVo);
		return count;
	}
	
	

	// 방명록 글 삭제
	public int removeGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.removeGuest()");

		int count = guestbookDao.deleteGuest(guestbookVo);
		return count;
	}
	
	
	
	// 방명록 글 저장_게시글 가져오기
	public GuestbookVo writeResultVo(GuestbookVo guestbookVo) {
		System.out.println("[guestbookService.writeResultVo()]");
		
		//글저장
		System.out.println(guestbookVo);  //no가 없다
		int count = guestbookDao.insertGuestbookKey(guestbookVo);
		System.out.println(guestbookVo);  //no가 있다
		
		int no = guestbookVo.getNo(); //방금 저장한 글 번호
		
		//글가져오기(방금등록한 번호)
		GuestbookVo resultVo = guestbookDao.selectGuestbook(no);
		
		
		return resultVo;
	}
	
	
	// no값으로 no의 모든 정보 가져오기- 안드로이드 사용
	public GuestbookVo readGuest(int no) {
		System.out.println("[guestbookService.readGuest()]");
		
		GuestbookVo guestbookVo = guestbookDao.selectGuestbook(no);
		return guestbookVo;
		
	}
	
	
	
}