import { ref, onMounted } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const REST_API_URL = `http://localhost:8080/api/boardCategory`

export const useCommunityStore = defineStore('community', () => {
  const categoryList = ref([])
  const boardList = ref([])
  const selectCategoryId = ref(null)
  const selectCategoryTitle = ref(null)
  
  // 카테고리 전체 조회(list)
  const getcategoryList = async () => {
    try {
      const response = await axios.get(REST_API_URL)
      console.log("카테고리 리스트 전체 조회 완료")
      console.log(response.data)
      categoryList.value = response.data
      
      // selectCategoryId가 null이고 데이터가 있을 때만 실행
      if (selectCategoryId.value === null && response.data && response.data.length > 0) {
        const defaultCategory = response.data[0]
        if (defaultCategory && defaultCategory.categoryId) {
          selectCategoryId.value = defaultCategory.categoryId
          selectCategoryTitle.value = defaultCategory.category
          // 비동기 함수 호출 시 await 추가
          await fetchPostsByCategory(defaultCategory.categoryId, defaultCategory.category)
        }
      }
    } catch (error) {
      console.error("카테고리 리스트 전체 데이터를 가져오는 데 실패했습니다:", error)
      categoryList.value = [] // 에러 시 빈 배열로 초기화
    }
  }

// 카테고리 상세 조회(detail)
const fetchPostsByCategory = async (categoryId, categoryTitle) => {
  try {
    // categoryId 유효성 검사
    if (!categoryId || categoryId === 'undefined') {
      console.warn('유효하지 않은 카테고리 ID:', categoryId);
      return;
    }

    selectCategoryId.value = categoryId;
    selectCategoryTitle.value = categoryTitle;
    console.log("선택된 카테고리 ID:", categoryId);
    console.log("선택된 카테고리 제목:", categoryTitle);

    const response = await axios.get(`${REST_API_URL}/${categoryId}`);
    
    // 응답 데이터 유효성 검사
    if (response.data) {
      boardList.value = response.data;
      console.log("선택한 카테고리 게시글 조회 완료:", boardList.value);
    } else {
      boardList.value = [];
      console.log("게시글이 없습니다.");
    }
  } catch (error) {
    console.error("게시글을 가져오는 데 실패했습니다:", error);
    boardList.value = []; // 에러 시 빈 배열로 초기화
  }
};

  // 카테고리 등록(regist)
  const createCategory = async (categoryData) => {
    try {
      const response = await axios.post(REST_API_URL, categoryData)
      console.log("카테고리 등록 완료", response.data)
      await getcategoryList() // 목록 갱신
      return response.data
    } catch (error) {
      console.error("카테고리 등록에 실패했습니다:", error)
      throw error
    }
  }

  return {
    categoryList,
    boardList,
    selectCategoryId,
    selectCategoryTitle,
    getcategoryList,
    fetchPostsByCategory,
    createCategory
  }
})