import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const REST_API_URL = `http://localhost:8080/api/boardCategory`

export const useCommunityStore = defineStore('community', () => {
  
  // 카테고리 리스트 전체 조회
  const categoryList = ref([])
  const getcategoryList = async () => {
    try {
      const response = await axios.get(REST_API_URL)
      console.log("전체 조회 완료")
      console.log(response.data)
      categoryList.value = response.data
    } catch (error) {
      console.error("데이터를 가져오는 데 실패했습니다:", error)
    }
  }

  
  // 카테고리선택
  // 카테고리별 게시글 조회
  const selectCategoryId = ref();

  function selectCategoryIMethod(categoryId) {
    console.log("여기 왔다")
    selectCategoryId.value = categoryId;
    console.log(selectCategoryId);


  }






  return { categoryList, getcategoryList, selectCategoryId, selectCategoryIMethod }
})
