package com.cl.sodexo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "favorite")
public class Favorite implements Serializable {

	private static final long serialVersionUID = -8793623955480007229L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private Long uuid;

	@NotNull
	private Long idNews;

	@NotNull
	private Long idUser;

	@ApiModelProperty(hidden = true)
	private String created;

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public Long getIdNews() {
		return idNews;
	}

	public void setIdNews(Long idNews) {
		this.idNews = idNews;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

}
