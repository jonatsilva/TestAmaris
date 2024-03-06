package com.cl.sodexo.dto;

import java.io.Serializable;

public class Event implements Serializable {

	private static final long serialVersionUID = -7304153231848106932L;

	private Integer event_id;
	private String provider;

	public Integer getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

}
