import { ref, onMounted } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const REST_API_URL = `http://localhost:8080/api/boardCategory`

export const useCommunityStore = defineStore('community', () => {
  
  const categoryList = ref([])
  const boardList = ref([]); // 선택한 카테고리의 게시글 리스트
  const selectCategoryId = ref(null); // 선택된 카테고리 ID
  const selectCategoryTitle = ref(null); // 선택된 카테고리 이름
  
  // 카테고리 전체 조회(list)
  const getcategoryList = async () => {
    try {
      const response = await axios.get(REST_API_URL)
      console.log("카테고리 리스트 전체 조회 완료")
      console.log(response.data)
      categoryList.value = response.data
      
      // selectCategoryId가 null이면 자유게시판을 기본값으로 설정
      if (selectCategoryId.value === null && response.data.length > 0) {
        const defaultCategory = response.data[0]; // 첫 번째 카테고리 (자유게시판)
        selectCategoryId.value = defaultCategory.categoryId;
        selectCategoryTitle.value = defaultCategory.category;
        fetchPostsByCategory(defaultCategory.categoryId, defaultCategory.category);
      }
    } catch (error) {
      console.error("카테고리 리스트 전체 데이터를 가져오는 데 실패했습니다:", error)
    }
  }

  // 카테고리 상세 조회(detail)
  // 카테고리별 게시글이 조회됨
  const fetchPostsByCategory = async (categoryId, categoryTitle) => {
    try {
      selectCategoryId.value = categoryId;
      selectCategoryTitle.value = categoryTitle;
      console.log(selectCategoryId.value);
      console.log(selectCategoryTitle.value);

      const response = await axios.get(`${REST_API_URL}/${categoryId}`);
      boardList.value = response.data; // 서버로부터 받아온 게시글 데이터를 저장
      console.log("선택한 카테고리 게시글 조회 완료:", boardList.value);
    } catch (error) {
      console.error("게시글을 가져오는 데 실패했습니다:", error);
    }
};

  // 컴포넌트가 마운트되면 카테고리 리스트를 가져오고, 자유게시판을 기본으로 로딩
  onMounted(() => {
    getcategoryList();
  });

  // 카테고리 등록(regist)
  const createCategory = async(categoryData) => {
    try {
      const response = await axios.post(REST_API_URL, categoryData)
      console.log("카테고리 등록 완료", response.data)
      // 등록 후 카테고리 목록 갱신
      await getcategoryList()
      return response.data
    } catch (error) {
      console.log("카테고리 등록에 실패했습니다.", error)
      throw error
    }
  }



return {
  categoryList,
  boardList,
  selectCategoryId,
  getcategoryList,
  fetchPostsByCategory,
  selectCategoryTitle, 
  createCategory
};
})
