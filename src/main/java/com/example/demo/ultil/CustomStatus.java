package com.example.demo.ultil;

import java.io.Serializable;

import javax.persistence.Entity;

import org.springframework.http.HttpStatus;

public class CustomStatus implements Serializable {

	private HttpStatus status;

	private String message;

	private Entity entity;

	public CustomStatus() {
		super();
	}

	public CustomStatus(HttpStatus status, String message, Entity entity) {
		this.status = status;
		this.message = message;
		this.entity = entity;
	}

	public CustomStatus(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

}
