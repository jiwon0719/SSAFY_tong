<template>
  <div class="post-create">
    <h1>게시글 수정</h1>
    
    <div class="post-form">
      <div class="form-group">
        <label>카테고리</label>
        <input 
          type="text" 
          :value="selectCategoryTitle"
          disabled
          class="form-input">
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
          취소
        </button>
        <button 
          class="btn btn-primary"
          @click="submitEdit"
        >
          수정
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useCommunityStore } from '@/stores/community';
import { useBoardStore } from '@/stores/board';
import { useUserStore } from '@/stores/user';
import { storeToRefs } from 'pinia';

const router = useRouter()
const route = useRoute()
const communityStore = useCommunityStore();
const boardStore = useBoardStore();
const userStore = useUserStore();

const { selectCategoryId, selectCategoryTitle } = storeToRefs(communityStore)
const { userId } = storeToRefs(userStore);
const { currentBoard } = storeToRefs(boardStore);

const postForm = ref({
  categoryId: selectCategoryId.value,
  title: '',
  writer: '',
  content: '',
  viewCnt: 0
})

onMounted(async () => {
  const boardId = route.params.boardId;
  
  if (!currentBoard.value) {
    await boardStore.getBoardDetail(boardId);
  }

  if(!userId.value) {
    await userStore.fetchUserInfo()
  }

  // 기존 게시글 데이터 불러오기
  postForm.value = {
    ...postForm.value,
    title: currentBoard.value.title,
    writer: currentBoard.value.writer,
    content: currentBoard.value.content
  }
})

const submitEdit = async () => {
  if (!postForm.value.title || !postForm.value.content) {
    alert('모든 필드를 입력해주세요.')
    return
  }

  if (postForm.value.title.length > 20) {
    alert('제목은 20자를 초과할 수 없습니다.')
    return
  }

  if (postForm.value.content.length > 255) {
    alert('내용은 255자를 초과할 수 없습니다.')
    return
  }

  try {
    await boardStore.updateBoard(route.params.boardId, {
      categoryId: selectCategoryId.value,
      title: postForm.value.title, 
      content: postForm.value.content
    });
    alert("게시글이 성공적으로 수정되었습니다.");
    router.push(`/community/${route.params.categoryId}/${route.params.boardId}`);
  } catch(error) {
    alert("게시글 수정에 실패했습니다.");
    console.log("게시글 수정 오류:", error);
  }
}

const goBack = () => {
  router.back()
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