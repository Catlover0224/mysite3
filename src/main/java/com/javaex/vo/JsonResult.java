package com.javaex.vo;


public class JsonResult {

	//필드
	private String result; //성공 or 실패
	private Object data; //성공했을 때 result = 'success'
	private String failMsg; //실패했을때 result = 'fail' 일때 참고할 수 있는 메세지

	
	//생성자
	public JsonResult() {
		super();
	}
	
	public JsonResult(String result, Object data, String failMsg) {
		super();
		this.result = result;
		this.data = data;
		this.failMsg = failMsg;
	}
	
	//성공
	public void success(Object data) {
		this.result="success";
		this.data = data;
	}
	
	//실패
	public void fail(String msg) {
		this.result = "fail";
		this.failMsg = msg;
	}

	//메소드겟셋
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getFailMsg() {
		return failMsg;
	}

	public void setFailMsg(String failMsg) {
		this.failMsg = failMsg;
	}

	@Override
	public String toString() {
		return "JsonResult [result=" + result + ", data=" + data + ", failMsg=" + failMsg + "]";
	}
}
