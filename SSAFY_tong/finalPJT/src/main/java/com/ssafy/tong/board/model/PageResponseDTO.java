package com.ssafy.tong.board.model;

import java.util.List;

public class PageResponseDTO<T> {
	private List<T> content; // 실제 데이터 목록
	private int totalPages; // 전체 페이지 수
	private int page; // 현재 페이지
	private int size; // 페이지 크기
	private int totalElements; // 전체 데이터 수
	private boolean first; // 첫 페이지 여부 
	private boolean last; // 마지막 페이지 여부
	
    public static <T> PageResponseDTO<T> of(List<T> content, int totalElements, PageRequestDTO requestDTO) {
        int totalPages = (int) Math.ceil((double) totalElements / requestDTO.getSize());
        
        return PageResponseDTO.<T>builder()
                .content(content)
                .totalPages(totalPages)
                .page(requestDTO.getPage())
                .size(requestDTO.getSize())
                .totalElements(totalElements)
                .first(requestDTO.getPage() == 1)
                .last(requestDTO.getPage() == totalPages)
                .build();
    }
}
