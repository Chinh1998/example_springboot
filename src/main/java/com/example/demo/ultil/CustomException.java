package com.example.demo.ultil;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5638231743543182572L;
	private String message;

	public CustomException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
