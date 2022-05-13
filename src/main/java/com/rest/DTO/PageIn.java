package com.rest.DTO;

import java.util.List;

import org.springframework.data.domain.Page;

public class PageIn {
  private Page page;
  private List<Integer> pageNumber;
public Page getPage() {
	return page;
}
public void setPage(Page page) {
	this.page = page;
}
public List<Integer> getPageNumber() {
	return pageNumber;
}
public void setPageNumber(List<Integer> pageNumber) {
	this.pageNumber = pageNumber;
}
  
}
