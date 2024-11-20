<template>
  <div class="post-create">
    <h1>게시글 등록</h1>
    
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
import { onMounted, ref, watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useCommunityStore} from '@/stores/community';
import { useBoardStore} from '@/stores/board';
import { useUserStore } from '@/stores/user';
import { storeToRefs } from 'pinia';

const router = useRouter()
const route = useRoute()
const communityStore = useCommunityStore();
const boardStore = useBoardStore();
const userStore = useUserStore();

// 컴포넌트 마운드 확인을 위한 로그 추가
console.log("컴포넌트 setup 실행")

// 반응형 상태를 가져오는 방법
const { selectCategoryId, selectCategoryTitle } = storeToRefs(communityStore)
const { userId } = storeToRefs(userStore);

// 폼 데이터
const postForm = ref({
  categoryId: selectCategoryId.value,
  title: '',
  writer: '', 
  content: '',
  viewCnt: 0
})



// 컴포넌트 마운트 시 카테고리 목록 로드
onMounted(async () => {
  console.log("onMounted 시작");

  await communityStore.getcategoryList()
  // console.log("카테고리 목록 로드 완료");

  // userId 체크
  // console.log("현재 userId 상태:", userId.value);

  // userId없으면 사용자 정보 가져옴
  if(!userId.value) {
    await userStore.fetchUserInfo()
  }

  // console.log(selectCategoryId.value)
  if(selectCategoryId.value) {
    postForm.value.categoryId = selectCategoryId.value
  }

  postForm.value.writer = userId.value
  // console.log("현재 유저 ID: ", userId.value)
})

// 추가로 라우터 이동 시점 확인
router.beforeEach((to, from, next) => {
  console.log("라우터 이동:", to.path);
  next();
});

// 게시글 등록
const submitPost = async () => {
  // 유효성 검사
  if (!postForm.value.categoryId || !postForm.value.title || !postForm.value.content) {
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

  try {

    console.log("등록할 카테고리 정보: ", postForm.value)
    await boardStore.createBoard(postForm.value)
    alert("게시글이 성공적으로 등록되었습니다.")

    // 게시글 등록 후 해당 카테고리의 게시글 목록을 새로 가져옴
    await communityStore.fetchPostsByCategory(postForm.value.categoryId, selectCategoryTitle.value)

    // 등록 후 목록으로 이동
    router.push(`/community/${selectCategoryId.value}`)  
  } catch(error) {
    alert("게시글 등록에 실패했습니다.")
    console.log("게시글 등록 오류:", error)
    console.log(postForm.value)
  }
}

// 목록으로 돌아가기
const goBack = () => {
  router.push(`/community/${selectCategoryId.value}`)
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