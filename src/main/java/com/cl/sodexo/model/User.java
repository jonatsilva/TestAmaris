package com.cl.sodexo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * The Class User.
 */
@Entity
@Table(name = "user")

public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7191719154491037266L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uuid;

	@NotNull
	private String name;

	@NotNull
	private String email;

	@ApiModelProperty(hidden = true)
	private String created;

	@ApiModelProperty(hidden = true)

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

}
