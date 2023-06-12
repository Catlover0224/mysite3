package com.javaex.vo;

public class GalleryVO {
	
	private int no;
	private int user_no;
	private String content;
	private String filePath;
	private String orgName;
	private String saveName;
	private long fileSize;
	private UserVO user;
	
	public GalleryVO() {
		super();
	}
	
	public GalleryVO(int no, int user_no, String content, String filePath, String orgName, String saveName,
			long fileSize) {
		super();
		this.no = no;
		this.user_no = user_no;
		this.content = content;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
	}
	
	public GalleryVO(int no, int user_no, String content, String filePath, String orgName, String saveName,
			long fileSize, UserVO user) {
		super();
		this.no = no;
		this.user_no = user_no;
		this.content = content;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
		this.user = user;
	}

	//get set
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	//toString
	@Override
	public String toString() {
		return "GalleryVO [no=" + no + ", user_no=" + user_no + ", content=" + content + ", filePath=" + filePath
				+ ", orgName=" + orgName + ", saveName=" + saveName + ", fileSize=" + fileSize + "]";
	}

}
