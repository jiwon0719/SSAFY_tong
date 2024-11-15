<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

// 폼 데이터
const postForm = ref({
  category_id: '',
  title: '',
  writer: 'admin', // 실제로는 로그인된 사용자 정보를 사용
  content: '',
  view_cnt: 0
})

// 카테고리 목록 (실제로는 API에서 가져올 데이터)
const categories = ref([
  { category_id: 1, name: '자유게시판' },
  { category_id: 2, name: '운동게시판' },
  { category_id: 3, name: '마음게시판' }
])

// 게시글 등록
const submitPost = () => {
  // 유효성 검사
  if (!postForm.value.category_id || !postForm.value.title || !postForm.value.content) {
    alert('모든 필드를 입력해주세요.')
    return
  }

  // 제목 길이 체크 (20자 제한)
  if (postForm.value.title.length > 20) {
    alert('제목은 20자를 초과할 수 없습니다.')
    return
  }

  // 내용 길이 체크 (255자 제한)
  if (postForm.value.content.length > 255) {
    alert('내용은 255자를 초과할 수 없습니다.')
    return
  }

  // TODO: API 호출하여 게시글 등록
  console.log('게시글 등록:', postForm.value)
  
  // 등록 후 목록으로 이동
  router.push('/community')
}

// 목록으로 돌아가기
const goBack = () => {
  router.push('/community')
}
</script>

<template>
  <div class="post-create">
    <h1>게시글 등록</h1>
    
    <div class="post-form">
      <div class="form-group">
        <label>카테고리</label>
        <select 
          v-model="postForm.category_id"
          class="form-input"
        >
          <option value="">카테고리를 선택해주세요</option>
          <option 
            v-for="category in categories" 
            :key="category.category_id"
            :value="category.category_id"
          >
            {{ category.name }}
          </option>
        </select>
      </div>

      <div class="form-group">
        <label>제목</label>
        <input 
          type="text" 
          v-model="postForm.title"
          placeholder="제목을 입력해주세요 (20자 이내)"
          maxlength="20"
          class="form-input"
        >
        <span class="char-count">{{ postForm.title.length }}/20</span>
      </div>

      <div class="form-group">
        <label>작성자</label>
        <input 
          type="text" 
          v-model="postForm.writer"
          disabled
          class="form-input"
        >
      </div>

      <div class="form-group">
        <label>내용</label>
        <textarea 
          v-model="postForm.content"
          placeholder="내용을 입력해주세요 (255자 이내)"
          maxlength="255"
          class="form-textarea"
        ></textarea>
        <span class="char-count">{{ postForm.content.length }}/255</span>
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
          @click="submitPost"
        >
          등록
        </button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.post-create {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

h1 {
  font-size: 1.5rem;
  margin-bottom: 30px;
}

.post-form {
  background: #fff;
  padding: 70px;
  border-radius: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.form-group {
  margin-bottom: 20px;
  position: relative;
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

.form-input:disabled {
  background: #f5f5f5;
  cursor: not-allowed;
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
  margin-top: 30px;
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

/* 반응형 스타일 */
@media (max-width: 768px) {
  .post-create {
    padding: 15px;
  }
  
  .post-form {
    padding: 30px;
  }

  .form-actions {
    flex-direction: column;
  }

  .btn {
    width: 100%;
  }
}
</style>