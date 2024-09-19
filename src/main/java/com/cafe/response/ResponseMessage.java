package com.cafe.response;

import java.util.List;

public class ResponseMessage<T> { 
	
	private String status;
	private T data;
	
	
	public ResponseMessage(String status, T data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
