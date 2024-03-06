package com.cl.sodexo.dto;

import java.io.Serializable;

public class ResponseFavorite implements Serializable {

	private static final long serialVersionUID = 6663337944274985124L;

	private Long uuid;
	private Long idUser;
	private Long idNews;
	private String created;
	private String message;

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdNews() {
		return idNews;
	}

	public void setIdNews(Long idNews) {
		this.idNews = idNews;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
