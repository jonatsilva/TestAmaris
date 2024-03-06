package com.cl.sodexo.dto;

import java.io.Serializable;

public class ResponseUser implements Serializable {

	private static final long serialVersionUID = 3335458916643183655L;

	private int uuid;
	private String email;
	private String message;

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
