package com.javaex.vo;

import java.util.Date;

public class BoardVO {

	//필드
	private int no;
	private String title;
	private String writer;
	private String views;
	private String boardDate;
	private String content;
	
	//생성자
	public BoardVO() {
		super();
	}
	
	public BoardVO(int no, String title, String writer, String views, String boardDate, String content) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.views = views;
		this.boardDate = boardDate;
		this.content = content;
	}

	//게터세터
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//투스트링
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", views=" + views + ", boardDate="
				+ boardDate + ", content=" + content + "]";
	}
	
}
