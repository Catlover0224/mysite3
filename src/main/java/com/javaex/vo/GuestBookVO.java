package com.javaex.vo;

public class GuestBookVO {

	//필드
	private int no;
	private String guestName;
	private String guestPwd;
	private String content;
	
	//생성자
	public GuestBookVO() {
		super();
	}
	
	public GuestBookVO(int no, String guestName, String guestPwd, String content) {
		super();
		this.no = no;
		this.guestName = guestName;
		this.guestPwd = guestPwd;
		this.content = content;
	}

	//게터세터
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestPwd() {
		return guestPwd;
	}

	public void setGuestPwd(String guestPwd) {
		this.guestPwd = guestPwd;
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
		return "GuestBookVO [no=" + no + ", guestName=" + guestName + ", guestPwd=" + guestPwd + ", content=" + content
				+ "]";
	}
	
}
