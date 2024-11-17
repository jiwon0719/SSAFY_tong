import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const MATCHING_API_URL = `http://localhost:8080/api/matching`
const EXPERT_API_URL = `http://localhost:8080/api/expert`

export const useMatchingStore = defineStore('matching', () => {
  const matchingList = ref([])
  const currentMatching = ref(null)
  const loading = ref(false)
  const error = ref(null)

  // 매칭 상태 확인
  const checkExistingMatching = async (userId, expertUserId) => {
    try {
      const response = await axios.get(`${MATCHING_API_URL}/check/${userId}/${expertUserId}`)
      return response.data
    } catch (error) {
      console.error("매칭 상태 확인 실패:", error)
      throw error
    }
  }

  // 매칭 신청
  const requestMatching = async (matchingData) => {
    try {
      loading.value = true
  
      // // 디버깅을 위한 로그 추가
      // console.log("매칭 데이터:", matchingData);
      // console.log("EXPERT_API_URL:", EXPERT_API_URL);
      
      // API URL 테스트
      const testUrl = `${EXPERT_API_URL}/${matchingData.expertId}/userId`;
      // console.log("실제 요청 URL:", testUrl);
  
      const expertResponse = await axios.get(testUrl)
      const expertUserId = expertResponse.data

      // console.log("전문가 userId:", expertUserId);

      // 기존 매칭 확인
      const exists = await checkExistingMatching(matchingData.userId, expertUserId)
      if (exists) {
        alert("이미 매칭 신청을 하였습니다.")
        return null
      }

      const data = {
        userId: matchingData.userId,
        expertUserId: expertUserId,  // 변환된 전문가의 user_id 사용
        status: 'X'
      }
      
      const response = await axios.post(MATCHING_API_URL, data, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
      
      console.log("매칭 신청 완료")
      await getUserMatchings(matchingData.userId)
      return response.data
    } catch (error) {
      console.error("매칭 신청에 실패했습니다:", error)
      throw error
    } finally {
      loading.value = false
    }
  }

  // 유저별 매칭 목록 조회 (ExpertList 형태로 반환)
  const getUserMatchings = async (userId) => {
    try {
      loading.value = true
      const response = await axios.get(`${MATCHING_API_URL}/user/${userId}`)
      console.log('API 응답 데이터:', response.data);
      matchingList.value = response.data  // 여기서 한 번만 업데이트되어야 함
      return response.data
    } catch (error) {
      console.error("매칭 목록을 가져오는데 실패했습니다:", error)
      throw error
    } finally {
      loading.value = false
    }
  }


  // 점수 업데이트
  const updateExpertScore = async (expertId, userId, score) => {
    try {
      loading.value = true
      console.log('Sending score update:', { expertId, userId, score });  // 요청 데이터 로그
  
      const response = await axios.put(`${MATCHING_API_URL}/${expertId}/score`, null, {
        params: {
          userId: userId,
          score: score
        }
      })
      
      console.log('Score update response:', response);  // 응답 로그
      await getUserMatchings(userId)
      return response.data
    } catch (error) {
      console.error("점수 업데이트에 실패했습니다:", error.response?.data || error.message)
      throw error
    } finally {
      loading.value = false
    }
  }


  return {
    matchingList,
    currentMatching,
    loading,
    error,
    requestMatching,
    getUserMatchings, 
    updateExpertScore, 
  }
})