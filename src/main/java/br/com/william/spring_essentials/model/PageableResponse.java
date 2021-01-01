package br.com.william.spring_essentials.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.william.spring_essentials.util.CustomSortDeserializer;

public class PageableResponse<T> extends PageImpl<T> {
	private int totalPages;
	private boolean last;
	private boolean first;
	private int numberElements;

	public PageableResponse(@JsonProperty("content") List<T> content, @JsonProperty("number") int page,
			@JsonProperty("size") int size, @JsonProperty("totalElements") long totalElements,
			@JsonProperty("totalPages") int totalPages, @JsonProperty("last") boolean last,
			@JsonProperty("first") boolean first, @JsonProperty("numberElements") int numberElements,
			@JsonProperty("sort") @JsonDeserialize(using = CustomSortDeserializer.class) Sort sort) {
		super(content, new PageRequest(page, size, sort), totalElements);

		this.first = first;
		this.last = last;
		this.numberElements = numberElements;
		this.totalPages = totalPages;
	}

	public PageableResponse() {
		super(new ArrayList<>());
		// TODO Auto-generated constructor stub
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public int getNumberElements() {
		return numberElements;
	}

	public void setNumberElements(int numberElements) {
		this.numberElements = numberElements;
	}

}
