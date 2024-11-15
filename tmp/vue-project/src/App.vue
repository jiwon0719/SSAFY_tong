<template>
  <div>
    <h2>전문가 상세페이지 작성</h2>
    <form @submit.prevent="submitForm">
      <!-- 전문가 정보 입력 -->
      <label>위치(location):</label>
      <input v-model="expert.location" type="text" required />
      <p></p>
      <label>소개(introduction):</label>
      <textarea v-model="expert.introduction"></textarea>
      <p></p>
      <label>가격(price):</label>
      <input v-model.number="expert.price" type="number" required />
      <p></p>
      <label>가격상세(priceDetail):</label>
      <input v-model="expert.priceDetail" type="text" required />
      <p></p>
      <label>직급(grade):</label>
      <input v-model="expert.grade" type="text" required />
      <p></p>
      <label>회사명(companyName):</label>
      <input v-model="expert.companyName" type="text" required />
      <p></p>
      <label>위도(latitude):</label>
      <input v-model.number="expert.latitude" type="number" required />
      <p></p>
      <label>경도(longitude):</label>
      <input v-model.number="expert.longitude" type="number" required />
      <p></p>
      <!-- 파일 업로드(여러 파일 선택 가능 : multiple) -->
      <label>이미지 파일 업로드:</label>
      <input type="file" @change="onFileChange"  multiple required /> 
      <p></p>
      <button type="submit">등록하기</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      expert: {
        userId: "expert",
        location: "대전시 유성구 싸피동",
        introduction: "전문가 소개글입니다.",
        price: 0,
        priceDetail: "가격 상세입니다.",
        grade: "점장",
        companyName: "SSAFIT",
        latitude: 36, // 예시 위도
        longitude: 127, // 예시 경도
      },
      imageFile: null,
    };
  },
  methods: {
    onFileChange(event) {
      this.imageFiles = Array.from(event.target.files); // 여러 파일을 배열로 저장
    },
    async submitForm() {
      try {
        const formData = new FormData();
        formData.append("expert", new Blob([JSON.stringify(this.expert)], { type: "application/json" }));
        // 각각의 파일을 FormData 추가
        this.imageFiles.forEach((file, index) => {
          formData.append("files", file);
        })

        const response = await axios.post("http://localhost:8080/api/expert", formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        });

        if (response.status === 200) {
          alert("등록 성공!");
        }
      } catch (error) {
        console.error("등록 오류:", error);
        alert("등록 실패!");
      }
    },
  },
};
</script>

<style scoped>
/* 스타일은 필요에 따라 추가 */
</style>
