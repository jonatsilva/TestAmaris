package com.cl.sodexo.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Result implements Serializable {

	private static final long serialVersionUID = 2637199520485301491L;

	private Integer id;
	private String title;
	private String news_site;
	private String summary;
	private String published_at;
	@JsonIgnore
	private String url;
	@JsonIgnore
	private String image_url;
	@JsonIgnore
	private String updated_at;
	@JsonIgnore
	private boolean featured;
	@JsonIgnore
	private List<Launch> launches;
	@JsonIgnore
	private List<Event> events;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNews_site() {
		return news_site;
	}

	public void setNews_site(String news_site) {
		this.news_site = news_site;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPublished_at() {
		return published_at;
	}

	public void setPublished_at(String published_at) {
		this.published_at = published_at;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public List<Launch> getLaunches() {
		return launches;
	}

	public void setLaunches(List<Launch> launches) {
		this.launches = launches;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
