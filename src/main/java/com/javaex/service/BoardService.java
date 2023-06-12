package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDAO;
import com.javaex.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	
	 public Map<String, Object> getList3(int crtPage){  
	      
	      System.out.println(crtPage);
	      System.out.println("paging class in controller");
	      
	      //현재페이지 음수면 1패이지로 처리
	      
	      //////////////////////////////////////////////////////////////
	      //리스트가져오기
	      //////////////////////////////////////////////////////////////
	      
	      //페이지당 글 갯수
	      int listCnt = 10;
	      
	      //rownum 시작글 번호, 끝 번호
	      int startRnum = (crtPage -1)*10+1;
	      int endRnum = (startRnum+listCnt)-1;
	      System.out.println(startRnum + " + " + listCnt + " - " + 1);
	      
	      System.out.println("controller에서 계산된 rowNum들 >> " + startRnum + " : " + endRnum);
	      
	      List<BoardVO> list = dao.selectList3(startRnum,endRnum);

	      
	      //////////////////////////////////////////////////////////////
	      //페이징 계산
	      //////////////////////////////////////////////////////////////
	      
	      //전체 글 갯수
	      int totalCount = dao.totalCount();
	      
	      
	      //페이지당 버튼 갯수
	      int pageBtnCount = 5;
	      
	      //마지막 버튼 번호
	      //1 ---> 5
	      //2 ---> 5
	      //3 ---> 5
	      //6 ---> 10
	      
	      //끝 버튼 번호
	      int endPageBtnNo = (int)(Math.ceil((double)crtPage  / pageBtnCount) * pageBtnCount);
	      
	      //시작버튼 번호
	      int startPageBtnNo = (endPageBtnNo-pageBtnCount)+1;
	      
	      
	      //다음 화살표---true(그린다.) or false(안 그린다.)
	      boolean next = false;
	      
	      if(endPageBtnNo * listCnt <totalCount) { 
	         next = true;
	      }else {
	         next = false;
	      }
	      
	      //이전 화살표
	      boolean prev = false;
	      if(startPageBtnNo != 1) {  
	         prev = true;
	      }
	      
	      //맵으로 만들기
	      Map<String, Object> pMap = new HashMap<>();
	      pMap.put("boardList", list);
	      pMap.put("prev", prev);
	      pMap.put("startPageBtnNo", startPageBtnNo);
	      pMap.put("endPageBtnNo", endPageBtnNo);
	      pMap.put("next", next);
	      
	     
	      return pMap;
	   }


	//리스트
	public List<BoardVO> getList() {
		System.out.println("BoardService.getList()");
		
		List<BoardVO> list =dao.getList();
		
		return list;
	}

	//검색
	public List<BoardVO> search(String title) {
		System.out.println("BoardService.search()");
		List<BoardVO> list =dao.search(title);
		
		return list;
	}

	//게시물 삭제
	public void remove(int no) {
		System.out.println("BoardService.remove()");
		dao.remove(no);
	}

	//게시물 등록
	public void insert(BoardVO vo) {
		System.out.println("BoardService.insert()");
		dao.insert(vo);
	}

	//게시물 보기
	public BoardVO read(int no) {
		System.out.println("BoardService.read()");
		BoardVO vo =dao.read(no);
		
		return vo;
	}

	// 조회수 증가
	public void increaseViews(int no) {
		System.out.println("BoardService.increaseViews()");
		dao.increaseViews(no); 
	}

	//수정
	public void update(BoardVO vo) {
		System.out.println("BoardService.update()");
		dao.update(vo);
	}
}
