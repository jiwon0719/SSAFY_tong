<template>
    <div class="expert-create">
      <h1>전문가 등록</h1>
      
      <div class="expert-form">
        <div class="form-content">
          <!-- 다중 이미지 업로드 섹션 -->
          <div class="form-group">
            <label>프로필 이미지 (최소 1장 필수, 최대 5장까지 가능)</label>
            <div class="images-container">
              <div 
                v-for="(image, index) in images" 
                :key="index" 
                class="image-preview-container"
              >
                <img :src="image.preview" alt="Preview" class="image-preview">
                <button @click="removeImage(index)" class="remove-image">×</button>
              </div>
              
              <div 
                v-if="images.length < 5" 
                class="image-upload-container"
                @drop.prevent="handleDrop"
                @dragover.prevent
                @dragenter.prevent
              >
                <input
                  type="file"
                  @change="handleImageUpload"
                  accept="image/*"
                  ref="fileInput"
                  class="file-input"
                  multiple
                >
                <div class="upload-placeholder">
                  <span class="upload-icon">+</span>
                  <span>이미지 추가</span>
                  <small>( {{ images.length }}/5 )</small>
                </div>
              </div>
            </div>
          </div>
  
          <div class="form-group">
            <label>회사명</label>
            <input 
              type="text" 
              v-model="expertForm.companyName"
              placeholder="회사명을 입력해주세요"
              class="form-input"
            >
          </div>
  
          <div class="form-group">
            <label>직급</label>
            <input 
              type="text" 
              v-model="expertForm.grade"
              placeholder="직급을 입력해주세요"
              class="form-input"
            >
          </div>
  
          <!-- 경력 섹션 -->
          <div class="form-group">
            <label>경력사항</label>
            <div class="careers-container">
              <div v-for="(career, index) in careers" :key="index" class="career-item">
                <div class="career-header">
                  <span>경력 #{{ index + 1 }}</span>
                  <button @click="removeCareer(index)" class="remove-career">삭제</button>
                </div>
                <div class="career-inputs">
                  <div class="date-inputs">
                    <input 
                      type="date" 
                      v-model="career.startDate"
                      class="form-input date-input"
                    >
                    <span>~</span>
                    <input 
                      type="date" 
                      v-model="career.endDate"
                      class="form-input date-input"
                    >
                  </div>
                  <input 
                    type="text" 
                    v-model="career.detail"
                    placeholder="경력 상세내용"
                    class="form-input"
                  >
                </div>
              </div>
              <button @click="addCareer" class="btn btn-secondary add-career">
                + 경력 추가
              </button>
            </div>
          </div>
  
          <div class="form-group">
            <label>우편번호</label>
            <div>
              <input v-model="expertForm.addressZipcode" placeholder="우편번호" readonly />
              <button @click="openPostcode">우편번호 찾기</button>
            </div>
          </div>

          <div class="form-group location-inputs">
            <div class="form-group">
              <label>주소</label>
              <input v-model="expertForm.address" placeholder="기본 주소" readonly />
            </div>
            <div class="form-group">
              <label>상세 주소</label>
              <input v-model="expertForm.addressDetail" placeholder="상세 주소 입력" />
            </div>
          </div>
  
          <div class="form-group">
            <label>본인소개</label>
            <textarea 
              v-model="expertForm.introduction"
              placeholder="본인소개를 입력해주세요 (500자 이내)"
              maxlength="500"
              class="form-textarea"
            ></textarea>
            <span class="char-count">{{ expertForm.introduction.length }}/500</span>
          </div>
  
          <div class="form-group">
            <label>가격</label>
            <input 
              type="number" 
              v-model="expertForm.price"
              placeholder="1회당 평균 가격으로 산정합니다"
              class="form-input"
            >
          </div>
  
          <div class="form-group">
            <label>가격상세</label>
            <input 
              type="text" 
              v-model="expertForm.priceDetail"
              placeholder="가격 이외 기타 가격과 관련된 공지사항을 작성합니다"
              class="form-input"
            >
          </div>
        </div>
  
        <div class="form-actions">
          <button 
            class="btn btn-secondary"
            @click="goBack"
          >
            목록으로
          </button>
          <button 
            class="btn btn-primary"
            @click="submitExpert"
          >
            등록
          </button>
        </div>
      </div>
    </div>
  </template>
  
<script setup>
  import { ref, onMounted } from 'vue'
  import { useRouter } from 'vue-router'
  import { useExpertStore } from '@/stores/expert'
  import { useUserStore } from '@/stores/user'
  import { storeToRefs } from 'pinia'

  const router = useRouter()
  const expertStore = useExpertStore()
  const userStore = useUserStore()

  const { loading } = storeToRefs(expertStore)
  const { userId } = storeToRefs(userStore)

  const fileInput = ref(null)
  const images = ref([])
  const careers = ref([])
  const expertForm = ref({ // 전문가 등록 폼 데이터
    companyName: '',
    grade: '',
    addressZipcode: '', 
    addressDetail: '', 
    address: '', 
    introduction: '', 
    price: '', 
    priceDetail: '', 
    userId: ''
  })

  onMounted(async () => {
    // 우편번호 
    loadDaumPostcodeScript();

    // userId없으면 사용자 정보 가져옴
    if(!userId.value) {
      await userStore.fetchUserInfo()
    }
    // 폼데이터에 userId 저장
    expertForm.value.userId = userId.value
  }) 


  // 이미지 업로드 처리
  const handleImageUpload = (event) => {
    const files = Array.from(event.target.files)
    addImages(files)
  }

  // 드래그 앤 드롭 이미지 처리
  const handleDrop = (event) => {
    const files = Array.from(event.dataTransfer.files)
    .filter(file => file.type.startsWith('image/'))
    addImages(files)
  }

  // 이미지 추가 처리
  const addImages = (files) => {
    const remainingSlots = 5 - images.value.length
    const filesToAdd = files.slice(0, remainingSlots)

    filesToAdd.forEach(file => {
      const reader = new FileReader()
      reader.onload = (e) => {
        images.value.push({
          file: file,
          preview: e.target.result
        })
      }
      reader.readAsDataURL(file)
    })
  }

  // 이미지 제거
  const removeImage = (index) => {
    images.value.splice(index, 1)
  }

  // 경력 추가
  const addCareer = () => {
    careers.value.push({
      startDate: '',
      endDate: '',
      detail: ''
    })
  }

  // 경력 제거
  const removeCareer = (index) => {
    careers.value.splice(index, 1)
  }

  
  // 폼 유효성 검사
  const validateForm = () => {
    const required = ['companyName', 'grade', 'addressZipcode','addressDetail', 
    'address', 'introduction', 'price', 'priceDetail']
    
    const missing = required.filter(field => !expertForm.value[field])
    if (missing.length > 0) {
      alert('필수 항목을 모두 입력해주세요.')
      return false
    }
    return true
  }

  // 전문가 등록 제출
  const submitExpert = async () => {
    if (!validateForm()) return
    
    try {
      const { success, error } = await expertStore.registerExpert(
        expertForm.value,
        careers.value,
        images.value
      )
      
      if (success) {
        alert("전문가 정보가 성공적으로 등록되었습니다.")
        router.push('/matching')
      } else {
        alert(`등록에 실패했습니다: ${error}`)
      }
    } catch(error) {
      alert("등록 처리 중 오류가 발생했습니다.")
      console.error("전문가 등록 오류:", error)
    }
  }

  // 뒤로 가기
  const goBack = () => {
    router.push('/matching')
  }

  // 우편번호 찾기 
  // Daum 주소 API 스크립트 로드
  const loadDaumPostcodeScript = () => {
    const script = document.createElement('script');
    script.src = "//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js";
    script.async = true;
    document.head.appendChild(script);
  };

  const openPostcode = () => {
    new window.daum.Postcode({
      oncomplete: function (data) {
        let addr = ''; 
        let extraAddr = ''; 

        if (data.userSelectedType === 'R') {
          addr = data.roadAddress;
        } else {
          addr = data.jibunAddress;
        }

        if (data.userSelectedType === 'R') {
          if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
            extraAddr += data.bname;
          }
          if (data.buildingName !== '' && data.apartment === 'Y') {
            extraAddr += extraAddr !== '' ? ', ' + data.buildingName : data.buildingName;
          }
          if (extraAddr !== '') {
            extraAddr = ' (' + extraAddr + ')';
          }
        }

        expertForm.value.addressZipcode = data.zonecode;
        expertForm.value.address = addr + extraAddr;
        document.querySelector('input[placeholder="상세 주소 입력"]')?.focus()
      },
    }).open();
  };





</script>
  
<style scoped>
  .expert-create {
    padding: 20px;
    min-height: 100%;
    max-width: 1200px;
    margin: 0 auto;
    padding-bottom: 350px; /* 푸터 높이보다 약간 더 크게 설정 */
}
  
  .expert-form {
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    margin-bottom: 40px;
  }
  
  .form-content {
    padding: 40px;
    overflow-y: visible;
  }
  
  /* 다중 이미지 업로드 스타일 */
  .images-container {
    display: flex;
    gap: 15px;
    flex-wrap: wrap;
  }
  
  .image-preview-container {
    width: 150px;
    height: 150px;
    border-radius: 8px;
    overflow: hidden;
    position: relative;
    border: 1px solid #ddd;
  }
  
  .image-upload-container {
    width: 150px;
    height: 150px;
    border: 2px dashed #ddd;
    border-radius: 8px;
    display: flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;
    position: relative;
  }
  
  .image-preview {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  
  .upload-placeholder {
    display: flex;
    flex-direction: column;
    align-items: center;
    color: #666;
  }
  
  .upload-icon {
    font-size: 24px;
    margin-bottom: 5px;
  }
  
  .file-input {
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    opacity: 0;
    cursor: pointer;
  }
  
  .remove-image {
    position: absolute;
    top: 5px;
    right: 5px;
    background: rgba(0, 0, 0, 0.5);
    color: white;
    border: none;
    border-radius: 50%;
    width: 24px;
    height: 24px;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  /* 경력 관련 스타일 */
  .careers-container {
    display: flex;
    flex-direction: column;
    gap: 15px;
  }
  
  .career-item {
    border: 1px solid #ddd;
    border-radius: 4px;
    padding: 15px;
  }
  
  .career-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 10px;
  }
  
  .remove-career {
    background: none;
    border: none;
    color: #e74c3c;
    cursor: pointer;
  }
  
  .career-inputs {
    display: flex;
    flex-direction: column;
    gap: 10px;
  }
  
  .date-inputs {
    display: flex;
    gap: 10px;
    align-items: center;
  }
  
  .date-input {
    flex: 1;
  }
  
  .add-career {
    width: fit-content;
  }
  
  /* 기본 폼 스타일 */
  h1 {
    font-size: 1.5rem;
    margin-bottom: 30px;
  }
  
  .form-group {
    margin-bottom: 20px;
    position: relative;
  }

  /* 우편번호 입력 그룹 */
  .form-group input[placeholder="우편번호"] {
    width: 200px;
    padding: 8px 12px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 14px;
    margin-right: 10px;
  }

  .form-group button {
    padding: 8px 16px;
    border: none;
    border-radius: 4px;
    background: #f5f5f5;
    color: #333;
    font-size: 14px;
    cursor: pointer;
    transition: background-color 0.2s;
  }

  .form-group button:hover {
    background: #e0e0e0;
  }
  
  /* 주소 입력 그룹 */
  .location-inputs {
    margin-bottom: 30px;
  }
  
  .location-inputs .form-group {
    margin-bottom: 15px;
  }

  .location-inputs input {
    width: 100%;
    padding: 8px 12px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 14px;
  }
  
  .coordinate-group {
    display: flex;
    gap: 20px;
    margin-bottom: 8px;
  }
  
  .coordinate-input {
    width: 200px;
  }
  
  .help-text {
    display: block;
    font-size: 12px;
    color: #666;
    text-align: right;
  }
  
  label {
    display: block;
    margin-bottom: 8px;
    font-weight: 500;
    color: #333;
  }
  
  .form-input {
    width: 100%;
    padding: 8px 12px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 14px;
  }
  
  .form-textarea {
    width: 100%;
    min-height: 200px;
    padding: 12px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 14px;
    resize: vertical;
  }
  
  .char-count {
    position: absolute;
    right: 0;
    bottom: -20px;
    font-size: 12px;
    color: #666;
  }
  
  .form-actions {
    display: flex;
    justify-content: flex-end;
    gap: 10px;
    padding: 20px 40px;
    background: #fff;
    border-top: 1px solid #eee;
  }
  
  .btn {
    padding: 8px 24px;
    border: none;
    border-radius: 4px;
    font-size: 14px;
    cursor: pointer;
    transition: background-color 0.2s;
  }
  
  .btn-primary {
    background: #e74c3c;
    color: white;
  }
  
  .btn-primary:hover {
    background: #c0392b;
  }
  
  .btn-secondary {
    background: #f5f5f5;
    color: #333;
  }
  
  .btn-secondary:hover {
    background: #e0e0e0;
  }
  
  @media (max-width: 768px) {
    .expert-create {
      padding: 15px;
    }
    
    .form-content {
      padding: 20px;
    }
  
    .coordinate-group {
      flex-direction: column;
      gap: 10px;
    }
  
    .coordinate-input {
      width: 100%;
    }
  
    .image-preview-container,
    .image-upload-container {
      width: calc(50% - 7.5px);
    }
  
    .date-inputs {
      flex-direction: column;
    }

    .form-group input[placeholder="우편번호"] {
      width: calc(100% - 110px); /* 버튼 너비 + 마진 고려 */
    }
    
    .form-group button {
      width: 100px;
    }
  }
</style>