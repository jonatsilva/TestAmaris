package com.cl.sodexo.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseArticles implements Serializable {

	private static final long serialVersionUID = 742902421475083200L;

	private Integer count;
	private String next;
	private String previous;
	private List<Result> results;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}
