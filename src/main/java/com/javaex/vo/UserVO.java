package com.javaex.vo;

public class UserVO {
	
	//필드
	private int no;
	private String userId;
	private String userPwd;
	private String userName;
	private String gender;
	
	//생성자
	public UserVO() {
		super();
	}
	
	public UserVO(int no, String userId, String userPwd, String userName, String gender) {
		super();
		this.no = no;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
	}

	//게터세터
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	//투스트링
	@Override
	public String toString() {
		return "UserVO : [no=" + no + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", gender=" + gender + "]";
	}
}//UserVO
