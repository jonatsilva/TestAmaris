package com.cl.sodexo.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class RequestArticles implements Serializable {

	private static final long serialVersionUID = -5335351870331574938L;

	// El índice inicial a partir del cual devolver los resultados.
	@ApiModelProperty(example = "10")
	private Integer offset;
	// Número de resultados a devolver por página.
	@ApiModelProperty(example = "10")
	private Integer limit;
	// Qué campo utilizar al ordenar los resultados
	private String ordering;
	// Busque documentos con una frase específica en el título o resumen.
	private String search;
	@ApiModelProperty(hidden = true)
	private List<Integer> event;
	@ApiModelProperty(hidden = true)
	private boolean has_event;
	@ApiModelProperty(hidden = true)
	private boolean has_launch;
	@ApiModelProperty(hidden = true)
	private boolean is_featured;
	@ApiModelProperty(hidden = true)
	private List<String> launch;
	@ApiModelProperty(hidden = true)
	private String news_site;
	@ApiModelProperty(hidden = true)
	private String news_site_exclude;
	@ApiModelProperty(hidden = true)
	private String published_at_gt;
	@ApiModelProperty(hidden = true)
	private String published_at_gte;
	@ApiModelProperty(hidden = true)
	private String published_at_lt;
	@ApiModelProperty(hidden = true)
	private String published_at_lte;
	@ApiModelProperty(hidden = true)
	private String summary_contains;
	@ApiModelProperty(hidden = true)
	private String summary_contains_all;
	@ApiModelProperty(hidden = true)
	private String summary_contains_one;
	@ApiModelProperty(hidden = true)
	private String title_contains;
	@ApiModelProperty(hidden = true)
	private String title_contains_all;
	@ApiModelProperty(hidden = true)
	private String title_contains_one;
	@ApiModelProperty(hidden = true)
	private String updated_at_gt;
	@ApiModelProperty(hidden = true)
	private String updated_at_gte;
	@ApiModelProperty(hidden = true)
	private String updated_at_lt;
	@ApiModelProperty(hidden = true)
	private String updated_at_lte;

	public List<Integer> getEvent() {
		return event;
	}

	public void setEvent(List<Integer> event) {
		this.event = event;
	}

	public boolean isHas_event() {
		return has_event;
	}

	public void setHas_event(boolean has_event) {
		this.has_event = has_event;
	}

	public boolean isHas_launch() {
		return has_launch;
	}

	public void setHas_launch(boolean has_launch) {
		this.has_launch = has_launch;
	}

	public boolean isIs_featured() {
		return is_featured;
	}

	public void setIs_featured(boolean is_featured) {
		this.is_featured = is_featured;
	}

	public List<String> getLaunch() {
		return launch;
	}

	public void setLaunch(List<String> launch) {
		this.launch = launch;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getNews_site() {
		return news_site;
	}

	public void setNews_site(String news_site) {
		this.news_site = news_site;
	}

	public String getNews_site_exclude() {
		return news_site_exclude;
	}

	public void setNews_site_exclude(String news_site_exclude) {
		this.news_site_exclude = news_site_exclude;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getOrdering() {
		return ordering;
	}

	public void setOrdering(String ordering) {
		this.ordering = ordering;
	}

	public String getPublished_at_gt() {
		return published_at_gt;
	}

	public void setPublished_at_gt(String published_at_gt) {
		this.published_at_gt = published_at_gt;
	}

	public String getPublished_at_gte() {
		return published_at_gte;
	}

	public void setPublished_at_gte(String published_at_gte) {
		this.published_at_gte = published_at_gte;
	}

	public String getPublished_at_lt() {
		return published_at_lt;
	}

	public void setPublished_at_lt(String published_at_lt) {
		this.published_at_lt = published_at_lt;
	}

	public String getPublished_at_lte() {
		return published_at_lte;
	}

	public void setPublished_at_lte(String published_at_lte) {
		this.published_at_lte = published_at_lte;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSummary_contains() {
		return summary_contains;
	}

	public void setSummary_contains(String summary_contains) {
		this.summary_contains = summary_contains;
	}

	public String getSummary_contains_all() {
		return summary_contains_all;
	}

	public void setSummary_contains_all(String summary_contains_all) {
		this.summary_contains_all = summary_contains_all;
	}

	public String getSummary_contains_one() {
		return summary_contains_one;
	}

	public void setSummary_contains_one(String summary_contains_one) {
		this.summary_contains_one = summary_contains_one;
	}

	public String getTitle_contains() {
		return title_contains;
	}

	public void setTitle_contains(String title_contains) {
		this.title_contains = title_contains;
	}

	public String getTitle_contains_all() {
		return title_contains_all;
	}

	public void setTitle_contains_all(String title_contains_all) {
		this.title_contains_all = title_contains_all;
	}

	public String getTitle_contains_one() {
		return title_contains_one;
	}

	public void setTitle_contains_one(String title_contains_one) {
		this.title_contains_one = title_contains_one;
	}

	public String getUpdated_at_gt() {
		return updated_at_gt;
	}

	public void setUpdated_at_gt(String updated_at_gt) {
		this.updated_at_gt = updated_at_gt;
	}

	public String getUpdated_at_gte() {
		return updated_at_gte;
	}

	public void setUpdated_at_gte(String updated_at_gte) {
		this.updated_at_gte = updated_at_gte;
	}

	public String getUpdated_at_lt() {
		return updated_at_lt;
	}

	public void setUpdated_at_lt(String updated_at_lt) {
		this.updated_at_lt = updated_at_lt;
	}

	public String getUpdated_at_lte() {
		return updated_at_lte;
	}

	public void setUpdated_at_lte(String updated_at_lte) {
		this.updated_at_lte = updated_at_lte;
	}

}
