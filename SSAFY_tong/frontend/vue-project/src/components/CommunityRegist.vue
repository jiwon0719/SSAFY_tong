<template>
  <div class="post-create">
    <h1>게시판 등록</h1>
    
    <div class="post-form">
      <div class="form-group">
        <label>카테고리명</label>
        <input 
          type="text" 
          v-model="postForm.category"
          placeholder="카테고리명을 작성해주세요. "
          class="form-input"
        >
      </div>

      <div class="form-group">
        <label>작성자</label>
        <input 
          type="text" 
          v-model="postForm.userId"
          disabled
          class="form-input"
        >
      </div>

      <div class="form-group">
        <label>설명</label>
        <textarea 
             type="text" 
          v-model="postForm.content"
          placeholder="카테고리에 대한 간략한 설명을 해주세요."
          class="form-textarea"
        ></textarea>
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

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useCommunityStore } from '@/stores/community';
import { storeToRefs } from 'pinia';

const router = useRouter()
const store = useCommunityStore()

// 폼 데이터
const postForm = ref({
  category: '',
  content: '',
  userId: 'admin' // 실제로는 로그인된 사용자 정보를 사용
})

// 게시글 등록
const submitPost = async () => {
  // 유효성 검사
  if (!postForm.value.category || !postForm.value.content) {
    alert('모든 필드를 입력해주세요.')
    return
  }

  try {
    await store.createCategory({
      category: postForm.value.category, 
      description: postForm.value.content,
      userId: postForm.value.userId
    })

    alert("카테고리가 성공적으로 등록되었습니다.")

    // 등록 후 목록 이동
    router.push('/community')
  } catch(error) {
    alert("카테고리 등록에 실패했습니다.")
    console.error('카테고리 등록 오류', error)
  }  
}

// 목록으로 돌아가기
const goBack = () => {
  router.push('/community')
}
</script>

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

  .form-actions {
    flex-direction: column;
  }

  .btn {
    width: 100%;
  }
}
</style>