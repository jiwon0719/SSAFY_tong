import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const MATCHING_API_URL = `${import.meta.env.VITE_API_BASE_URL}/api/matching`
const EXPERT_API_URL = `${import.meta.env.VITE_API_BASE_URL}/api/expert`

export const useMatchingStore = defineStore('matching', () => {
  const matchingList = ref([]) // (회원용) 전문가 매칭 리스트
  const userMatchingList = ref([]) // (전문가용) 회원 매칭 리스트
  const currentMatching = ref(null)
  const loading = ref(false)
  const error = ref(null)

  // 매칭 상태 확인
  const checkExistingMatching = async (userId, expertUserId) => {
    try {
      console.log("userId:", userId) // 객체인지 확인
      console.log("expertUserId:", expertUserId)
      
      // userId가 객체라면 .value를 사용해 실제 값을 가져옵니다
      const userIdValue = userId?.value || userId
      
      const response = await axios.get(`${MATCHING_API_URL}/check/${userIdValue}/${expertUserId}`)
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
  
      // matchingData의 userId가 객체인지 확인
      console.log("matchingData.userId:", matchingData.userId)

      const userIdValue = matchingData.userId?.value || matchingData.userId
      
      // API URL 테스트
      const testUrl = `${EXPERT_API_URL}/${matchingData.expertId}/userId`;
      const expertResponse = await axios.get(testUrl)  
      const expertUserId = expertResponse.data


      // 기존 매칭 확인
      const exists = await checkExistingMatching(userIdValue, expertUserId)
      if (exists) {
        alert("이미 매칭 신청을 하였습니다.")
        return null
      }

      const data = {
        userId: userIdValue,
        expertUserId: expertUserId,  // 변환된 전문가의 user_id 사용
        status: 'X'
      }
      
      const response = await axios.post(MATCHING_API_URL, data, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
      
      console.log("매칭 신청 완료")
      await getUserMatchings(userIdValue)
      return response.data
    } catch (error) {
      console.error("매칭 신청에 실패했습니다:", error)
      throw error
    } finally {
      loading.value = false
    }
  }

  // 유저별 칭 목록 조회 (ExpertList 형태로 반환)
  // const getUserMatchings = async (userId) => {
  //   try {
  //     loading.value = true
  //     console.log('매칭 목록 요청 시작 - userId:', userId);

  //     const response = await axios.get(`${MATCHING_API_URL}/user/${userId}`)
  //     console.log('매칭 목록 API 응답 데이터:', response);
  //     console.log('매칭 목록 데이터:', response.data);

  //     // 응답 데이터 배열인지 확인
  //     if (!Array.isArray(response.data)) {
  //       console.error('API 응답이 배열 형태가 아닙니다:', response.data);
  //       matchingList.value = [];
  //     } else {
  //       matchingList.value = response.data;
  //     }      

  //     return response.data
  //   } catch (error) {
  //     console.error("매칭 목록을 가져오는데 실패했습니다:", error)
  //     console.error("에러 상세: ", error.response?.data);
  //     matchingList.value = [];
  //     throw error
  //   } finally {
  //     loading.value = false
  //   }
  // }
  const getUserMatchings = async (userId) => {
    try {
      loading.value = true
      console.log('매칭 목록 요청 시작 - userId:', userId);
  
      const response = await axios.get(`${MATCHING_API_URL}/user/${userId}`)
      console.log('매칭 목록 API 응답 데이터:', response);
      console.log('매칭 목록 데이터:', response.data);
  
      // 응답 데이터 배열인지 확인
      if (!Array.isArray(response.data)) {
        console.error('API 응답이 배열 형태가 아닙니다:', response.data);
        matchingList.value = [];
      } else {
        // 프로필 이미지 URL 생성 로직 추가
        matchingList.value = response.data.map(matching => ({
          ...matching,
          userProfileImgUrl: matching.userProfileImgPath 
            ? `${import.meta.env.VITE_API_BASE_URL}/api/expert/image/${matching.userId}/${matching.userProfileImgPath}`
            : null
        }));
      }      
  
      return matchingList.value
    } catch (error) {
      console.error("매칭 목록을 가져오는데 실패했습니다:", error)
      console.error("에러 상세: ", error.response?.data);
      matchingList.value = [];
      throw error
    } finally {
      loading.value = false
    }
  }

  // 전문가별 매칭 목록 조회(UserList 형태로 반환)
  const getExpertMatchings = async (userId) => {
    try {
      loading.value = true
      // console.log('1. (전문가용) 유저 매칭 목록 요청 시작 - userId:', userId);
  
      const response = await axios.get(`${MATCHING_API_URL}/expert/${userId}`)
      // console.log('2. 매칭 목록 API 응답 데이터:', response);
      // console.log('3. 매칭 목록 데이터:', response.data);
  
      // console.log('4. response.data의 타입:', typeof response.data);
      // console.log('5. response.data가 배열인가?', Array.isArray(response.data));
  
      // 응답 데이터 배열인지 확인
      if (!Array.isArray(response.data)) {
        // console.error('API 응답이 배열 형태가 아닙니다:', response.data);
        userMatchingList.value = [];
      } else {
        // console.log("6. 여기 와?")
        userMatchingList.value = response.data;
      }      
  
      return response.data
    } catch (error) {
      // console.error("7. 매칭 목록을 가져오는데 실패했습니다:", error)
      // console.error("8. 에러 상세: ", error.response?.data);
      userMatchingList.value = [];
      throw error
    } finally {
      // console.log("9. 최종 userMatchingList: ", userMatchingList.value)
      loading.value = false
    }
  }

  // 매칭 수락, 거절(전문가가 실행)
  const updateMatchingStatus = async (userId, expertUserId, status) => {
    try {
      loading.value = true
      console.log('매칭 상태 업데이트 요청:', { userId, expertUserId, status })
  
      // 매칭 상태 업데이트
      const response = await axios.put(`${MATCHING_API_URL}/status`, {
        userId: userId,
        expertUserId: expertUserId,
        status: status
      })
  
      // 매칭이 수락된 경우에만 환영 메시지 전송
      if (status === 'O') {
        try {
          // 전문가 정보 조회 전에 로그 추가
          console.log('전문가 정보 조회 시작:', expertUserId)
          
          const expertInfoResponse = await axios.get(
            `${MATCHING_API_URL}/expert-info/${expertUserId}`
          )
          
          // 응답 데이터 확인
          console.log('전문가 정보 응답:', expertInfoResponse.data)
          
          if (!expertInfoResponse.data) {
            throw new Error('전문가 정보를 찾을 수 없습니다.')
          }

          const expertInfo = expertInfoResponse.data
          // 1. 매칭 ID 조회
          const matchingResponse = await axios.get(
            `${MATCHING_API_URL}/find/${userId}/${expertUserId}`
          )
          const matchingId = matchingResponse.data

          // 2. 환영 메시지 생성
          const welcomeMessage = `회원을 승락하였습니다. 감사합니다.\n\n` + 
            `              🎉✨저희 둘이 TONG했어요✨🎉\n` +
            `🏃드디어 찾으셨네요! 믿을 수 있는 전문가와 함께하세요‍🏃‍\n\n` +
            `저를 ${expertInfo.companyName}에서 만나실 수 있습니다!\n\n` +
            `직급 : ${expertInfo.grade}\n` +
            `주소 : ${expertInfo.address} ${expertInfo.addressDetail}\n` +
            `1회 가격 : ${expertInfo.price}원\n\n` +
            `문의 사항은 편하게 채팅해주세요~`


          // 3. 채팅 메시지 전송
          await axios.post(`${import.meta.env.VITE_API_BASE_URL}/api/chat/message`, {
            matchingId: matchingId,
            senderId: expertUserId,
            content: welcomeMessage,
            type: "CHAT",
            isRead: "X"
          })
        } catch (error) {
          console.error("환영 메시지 전송 실패:", error)
          console.error("상세 에러:", error.response?.data)
          throw error  // 에러를 상위로 전파
        }
      }

      console.log('매칭 상태 업데이트 완료:', response.data)
      
      // 매칭 목록 갱신
      await getExpertMatchings(expertUserId)
      
      // 성공 메시지 표시
      const message = status === 'O' ? '매칭이 수락되었습니다.' : '매칭이 거절되었습니다.'
      alert(message)
      
      return response.data
    } catch (error) {
      console.error("매칭 상태 업데이트 실패:", error.response?.data || error.message)
      alert('처리 중 오류가 발생했습니다. 다시 시도해주세요.')
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
    userMatchingList, 
    currentMatching,
    loading,
    error,
    requestMatching,
    getUserMatchings, 
    getExpertMatchings, 
    updateExpertScore, 
    updateMatchingStatus, 
  }
})