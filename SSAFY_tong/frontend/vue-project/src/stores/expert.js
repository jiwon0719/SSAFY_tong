import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

export const useExpertStore = defineStore('expert', () => {
  // state
  const experts = ref([])
  const expertDetail = ref(null)
  const expertCareers = ref([])
  const expertImages = ref([])
  const loading = ref(false)
  const error = ref(null)

  // getters(computed) 
  const averageScore = computed(() => {
    if(!expertDetail.value?.totalScore || !expertDetail.value?.totalScoreCnt) return 0
    return (expertDetail.value.totalScore / expertDetail.value.totalScoreCnt).toFixed(1)
  })

  // action
  // 전문가 상세
  // const fetchExpertDetail = async (expertId) => {
  //   if (!expertId) {
  //     error.value = '전문가 ID가 필요합니다.'
  //     return { success: false, error: error.value }
  //   }
    
  //   loading.value = true
  //   error.value = null
  
  //   try {
  //     // 병렬로 세 개의 API를 동시에 호출
  //     const [expertResponse, careersResponse, imagesResponse] = await Promise.all([
  //       axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/expert/${expertId}`),
  //       axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/expert/${expertId}/careers`),
  //       axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/expert/${expertId}/images`)
  //     ])
      
  //     console.log('이미지 응답 데이터: ', imagesResponse.data);

  //     // 각 응답 데이터 설정
  //     expertDetail.value = expertResponse.data
  //     console.log(expertDetail.value)
  //     expertCareers.value = careersResponse.data
  //     console.log(expertCareers.value)
  //     // 이미지 데이터에 URL 추가
  //     expertImages.value = imagesResponse.data.map(img => {
  //       const imageUrl = `${import.meta.env.VITE_API_BASE_URL}/api/expert/image/${img.filePath}/${img.systemName}`;
  //       console.log('생성된 이미지 URL:', imageUrl);
  //       return {
  //         ...img,
  //         imageUrl
  //       }
  //     })
  
  //     console.log('최종 이미지 데이터: ', expertImages.value)

  //     return { success: true }
  //   } catch (err) {
  //     console.error('전문가 상세 정보 로딩 에러:', err)
  //     error.value = err?.message || '전문가 정보를 불러오는데 실패했습니다.'
  //     return {
  //       success: false,
  //       error: error.value
  //     }
  //   } finally {
  //     loading.value = false
  //   }
  // }

  const fetchExpertDetail = async (expertId) => {
    if (!expertId) {
      error.value = '전문가 ID가 필요합니다.'
      return { success: false, error: error.value }
    }
    
    loading.value = true
    error.value = null
  
    try {
      // 각 API 호출을 개별적으로 시도
      try {
        const expertResponse = await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/expert/${expertId}`)
        expertDetail.value = expertResponse.data
        console.log('전문가 기본 정보:', expertDetail.value)
      } catch (e) {
        console.error('전문가 기본 정보 로딩 실패:', e)
      }
  
      try {
        const careersResponse = await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/expert/${expertId}/careers`)
        expertCareers.value = careersResponse.data
        console.log('전문가 경력 정보:', expertCareers.value)
      } catch (e) {
        console.error('전문가 경력 정보 로딩 실패:', e)
        expertCareers.value = [] // 실패시 빈 배열로 초기화
      }
  
      try {
        const imagesResponse = await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/expert/${expertId}/images`)
        console.log('이미지 응답 데이터:', imagesResponse.data)
        
        expertImages.value = imagesResponse.data.map(img => {
          const imageUrl = `${import.meta.env.VITE_API_BASE_URL}/api/expert/image/${img.filePath}/${img.systemName}`
          console.log('생성된 이미지 URL:', imageUrl)
          return {
            ...img,
            imageUrl
          }
        })
        console.log('최종 이미지 데이터:', expertImages.value)
      } catch (e) {
        console.error('전문가 이미지 정보 로딩 실패:', e)
        expertImages.value = [] // 실패시 빈 배열로 초기화
      }
  
      // 기본 정보가 없으면 실패로 처리
      if (!expertDetail.value) {
        throw new Error('전문가 기본 정보를 불러올 수 없습니다.')
      }
  
      return { success: true }
    } catch (err) {
      console.error('전문가 상세 정보 로딩 에러:', err)
      error.value = err?.message || '전문가 정보를 불러오는데 실패했습니다.'
      return {
        success: false,
        error: error.value
      }
    } finally {
      loading.value = false
    }
  }


  // 전문가 등록
  // 이미지, 경력 한번에 처리
  const registerExpert = async (expertData, careerList, imageList) => {
    loading.value = true
    error.value = null

    try {
      const formData = new FormData()
      
      // expert 데이터를 문자열로 변환
      formData.append('expert', new Blob([JSON.stringify({
        userId: expertData.userId, 
        addressZipcode: expertData.addressZipcode,
        addressDetail: expertData.addressDetail, 
        address: expertData.address,
        introduction: expertData.introduction,
        price: Number(expertData.price),
        priceDetail: expertData.priceDetail, 
        grade: expertData.grade,
        companyName: expertData.companyName,
        totalScore: 0,
        totalScoreCnt: 0
      })], {
        type: 'application/json'
      }))

      // career 데이터를 문자열로 변환
      formData.append('career', new Blob([JSON.stringify(careerList.map(career => ({
        careerDetail: career.detail,
        startDate: career.startDate,
        endDate: career.endDate
      })))], {
        type: 'application/json'
      }))

      // 이미지 파일들 추가
      imageList.forEach(image => {
        formData.append('files', image.file)
      })

      const response = await axios.post(`${import.meta.env.VITE_API_BASE_URL}/api/expert`, formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })

      loading.value = false
      return { 
        success: true, 
        data: response.data 
      }

    } catch (err) {
      loading.value = false
      error.value = err?.message || '알 수 없는 오류가 발생했습니다'
      return { 
        success: false, 
        error: error.value 
      }
    }
  }

  // 상태 초기화 메서드
  const resetState = () => {
    experts.value = []
    expertDetail.value = null
    expertCareers.value = []
    expertImages.value = []
    loading.value = false
    error.value = null
  }

  // validation 메서드 추가
  const validateExpertData = (expertData) => {
    const errors = []
    

    if (!expertData.introduction) errors.push('소개를 입력해주세요')
    if (!expertData.price || expertData.price <= 0) errors.push('가격을 올바르게 입력해주세요')
    if (!expertData.priceDetail) errors.push('가격 상세 정보를 입력해주세요')
    if (!expertData.grade) errors.push('등급을 선택해주세요')
    
    return errors
  }

  // 이미지 URL 생성 함수
  const getImageUrl = (filePath, systemName) => {
    return `${import.meta.env.VITE_API_BASE_URL}/api/expert/image/${filePath}/${systemName}`
  }

// 프로필 이미지 URL 생성 함수 추가
const getProfileImageUrl = (userId, profileImgPath) => {
  if (!profileImgPath) return 'src/assets/images/기본프로필.jpg'
  return `${import.meta.env.VITE_API_BASE_URL}/api/expert/image/${userId}/${profileImgPath}`
}

  // 전문가 목록 조회
  const fetchExperts = async () => {
    loading.value = true
    error.value = null

    try {
      const response = await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/expert/list`)
      console.log('API 응답 데이터:', response.data)  // API 응답 확인
      
      // 각 전문가의 이미지 URL 추가
      experts.value = response.data.map(expert => {
        console.log('개별 전문가 데이터:', expert)  // 각 전문가 데이터 확인
        
        return {
          ...expert,
          expertImages: expert.expertImages?.map(img => ({
            ...img,
            imageUrl: getImageUrl(img.filePath, img.systemName)
          })),
          // 프로필 이미지 URL 추가
        userProfileImgPath: getProfileImageUrl(expert.userId, expert.userProfileImgPath)
        }
      })
      
      console.log('변환된 experts 데이터:', experts.value)  // 최종 변환된 데이터 확인
      
      return { success: true }
    } catch (err) {
      console.error('전문가 목록 로딩 에러:', err) // 디버깅용
      error.value = err?.message || '전문가 목록을 불러오는데 실패했습니다.'
      experts.value = [] // 에러 시 빈 배열로 초기화
      return { 
        success: false, 
        error: error.value 
      }
    } finally {
      loading.value = false
    }
  }  

  return {
    // state
    experts,
    expertDetail, 
    expertCareers, 
    expertImages,
    loading,
    error,
    

    // getters
    averageScore, 

    // actions
    fetchExpertDetail,
    registerExpert,
    resetState,
    validateExpertData,
    fetchExperts
  }
})