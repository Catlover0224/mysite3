package com.javaex.vo;

public class BoardVO {

	int no;
	String title;
	String writer;
	String views;
	String date;
	
	public BoardVO(int no, String title, String writer, String views, String date) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.views = views;
		this.date = date;
	}
}
