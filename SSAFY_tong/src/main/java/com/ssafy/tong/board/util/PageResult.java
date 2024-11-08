package com.ssafy.tong.board.util;

/**
 * 페이징 처리를 위한 변수를 표현
 */
public class PageResult {
	private int page;	// 현재 요청된 페이지 번호
	private int beginPage;	// 목록 하단의 페이지 시작번호
	private int endPage;	// 목록 하단의 페이지 종료번호
	private int lastPage;	// 목록 하단의 페이지 마지막 페이지
	private boolean prev;	// 이전 버튼 표시 여부 판단
	private boolean next;	// 다음 버튼 표시 여부 판단

	private static final int LIST_SIZE = 10;
	private static final int TAB_SIZE = 10;
	public PageResult(int page, int totalCount) {
		this(page, totalCount, LIST_SIZE, TAB_SIZE);
	}

	public PageResult(int page, int totalCount, int listSize) {
		this(page, totalCount, listSize, TAB_SIZE);
	}
	
	public PageResult(int page, int totalCount, int listSize, int tabSize) {
		this.page = page;
		this.lastPage = (totalCount % listSize == 0) ? totalCount / listSize
			 	                                     : totalCount / listSize + 1;
		int tab = (page - 1) / tabSize + 1;
		this.beginPage = (tab - 1) * tabSize + 1; 
		this.endPage = (tab * tabSize < lastPage) ? tab * tabSize : lastPage;
		
		// 이전 번호가 있는지
		this.prev = beginPage != 1;
		// 다음 번호가 있는지
		this.next = endPage != lastPage;
	}

	public int getPage() {
		return page;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}
}
