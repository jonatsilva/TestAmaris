package com.cl.sodexo.dto;

import java.io.Serializable;

public class Launch implements Serializable {

	private static final long serialVersionUID = -7927478520197815539L;

	private String launch_id;
	private String provider;

	public String getLaunch_id() {
		return launch_id;
	}

	public void setLaunch_id(String launch_id) {
		this.launch_id = launch_id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

}
