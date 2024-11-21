<template>
  <div class="post-detail">
    <header class="post-header">
      <h1 class="post-title">{{ currentBoard?.title }}</h1>
      <div class="post-info">
        <span>작성자: {{ currentBoard?.writer }}</span>
        <span>작성일: {{ currentBoard?.regDate }}</span>
        <span>조회수: {{ currentBoard?.viewCnt }}</span>
      </div>
    </header>

    <div class="post-content">
      {{ currentBoard?.content }}
    </div>

    <div class="post-actions">
      <button class="btn" v-if="isAuthor">수정</button>
      <button class="btn" v-if="isAuthor">삭제</button>
      <button class="btn" @click="goToList">목록으로</button>
    </div>

    <section class="comments-section">
      <h2 class="comments-title">댓글</h2>
      
      <div v-if="commentStore.loading" class="loading">
        댓글을 불러오는 중...
      </div>
      
      <div v-else class="comments-list">
        <div v-for="comment in rootComments" :key="comment.commentId" class="comment">
          <div class="comment-header">
            <span class="author">{{ comment.commenter }}</span>
            <span class="date">{{ formatDate(comment.regDate) }}</span>
          </div>
          <div class="comment-content">{{ comment.content }}</div>
          <!-- 답글 영역 -->
          <div class="comment-actions">
            <button class="btn-icon" @click="replyToId = comment.commentId">
              <Send class="icon" size="16"/>
            </button>
          
            <!-- 인라인 대댓글 폼 -->
            <div v-if="replyToId === comment.commentId" class="inline-reply-form">
              <input 
              v-model="newReply"
              placeholder="대댓글을 작성해주세요"
              class="inline-input"
              />
              <button class="btn-send" @click="handleRegisterReply(comment.commentId)">
                등록
              </button>
            </div>
          </div>
                
          <div v-for="reply in comment.replies" 
            :key="reply.commentId" 
            class="reply">
            <div class="reply-header">
              <span class="author">{{ reply.commenter }}</span>
              <span class="date">{{ formatDate(reply.regDate) }}</span>
            </div>
            <div class="reply-content">{{ reply.content }}</div>
          </div>
        </div>
      </div>

      <div class="comment-form">
        <textarea 
          v-model="newComment"
          placeholder="댓글을 작성해주세요"
          class="input-field"
        ></textarea>
        <button class="btn-primary" @click="handleRegisterComment()">댓글 등록</button>
      </div>
    </section>
  </div>
</template>

<script setup>
// Script remains exactly the same as the original
import { ref, onMounted, computed } from 'vue';
import { useBoardStore } from '@/stores/board';
import { useCommentStore } from '@/stores/comment';
import { useCommunityStore } from '@/stores/community';
import { useUserStore } from '@/stores/user';
import { storeToRefs } from 'pinia';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';
import { Send } from 'lucide-vue-next'; // 아이콘

const boardStore = useBoardStore();
const commentStore = useCommentStore();
const communityStore = useCommunityStore();
const userStore = useUserStore();
const router = useRouter();

const { currentBoard } = storeToRefs(boardStore);
const { comments = ref([]) } = storeToRefs(commentStore);
const { selectCategoryId } = storeToRefs(communityStore);
const { userId, userType } = storeToRefs(userStore);

const newComment = ref('');
const newReply = ref('');
const replyToId = ref(null);

const route = useRoute();
const boardId = route.params.boardId;
const isFirstMount = ref(true);

const goToList = async () => {
  try {
    if(selectCategoryId.value) {
      const response = await axios.get(`http://localhost:8080/api/boardCategory/${selectCategoryId.value}`);
      communityStore.boardList.value = response.data;
      router.push(`/community/${route.params.categoryId}`);
    } else {
      router.push(`/community/${route.params.categoryId}`);
    }
  } catch(error) {
    console.log("데이터 로드 중 오류 발생:", error)
    router.push(`/community/${route.params.categoryId}`);
  } 
};

onMounted(async () => {
  if (boardId && isFirstMount.value) {
    try {
      isFirstMount.value = false;
      await boardStore.getBoardDetail(boardId);
      await commentStore.getCommentsList(boardId);
      if(!userId.value) {
        await userStore.fetchUserInfo()
      }
    } catch (error) {
      console.error('댓글 데이터를 불러오는 중 오류가 발생했습니다:', error);
    }
  }
});

const rootComments = computed(() => {
  return Array.isArray(comments.value) 
    ? comments.value.filter(comment => comment.parentCommentId === null)
    : [];
});

const formatDate = (dateString) => new Date(dateString).toLocaleString();

const handleRegisterComment = async () => {
  if (!newComment.value.trim()) return;
  try {
    await commentStore.registComment({
      boardId: currentBoard.value.boardId,
      content: newComment.value,
      commenter: userId.value,
    });
    newComment.value = '';
  } catch (error) {
    alert('댓글 작성에 실패했습니다.');
  }
};

const handleRegisterReply = async (parentCommentId) => {
  if (!newReply.value.trim()) return;
  try {
    await commentStore.registReply({
      boardId: currentBoard.value.boardId,
      parentCommentId: parentCommentId,
      content: newReply.value,
      commenter: userId.value,
    });
    newReply.value = '';
    replyToId.value = null;
  } catch (error) {
    alert('대댓글 작성에 실패했습니다.');
  }
};

const isAuthor = computed(() => {
  return currentBoard.value?.writer === userId.value;
})
</script>

<style scoped>
.post-detail {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  color: #333;
}

.post-header {
  margin-bottom: 2rem;
}

.post-title {
  font-size: 1.8rem;
  color: #1a1a1a;
  margin-bottom: 1rem;
}

.post-info {
  display: flex;
  gap: 1.5rem;
  color: #666;
  font-size: 0.9rem;
}

.post-content {
  min-height: 200px;
  margin: 2rem 0;
  padding: 1.5rem;
  background: #fafafa;
  border-radius: 8px;
  line-height: 1.6;
}

.post-actions {
  display: flex;
  gap: 0.75rem;
  margin: 2rem 0;
  justify-content: flex-end;  /* Changed: Align buttons to the right */
}

.btn {
  padding: 0.5rem 1rem;
  border: 1px solid #e0e0e0;
  border-radius: 6px;
  background: white;
  color: #666;
  font-size: 0.9rem;
  cursor: pointer;
  transition: all 0.2s ease;
}

.btn:hover {
  background: #f5f5f5;
  border-color: #d0d0d0;
}

.comments-section {
  margin-top: 3rem;
}

.comments-title {
  font-size: 1.4rem;
  color: #1a1a1a;
  margin-bottom: 1.5rem;
}

.input-field {
  width: 100%;
  min-height: 100px;
  padding: 0.75rem;
  margin-bottom: 0.75rem;
  border: 1px solid #e0e0e0;
  border-radius: 6px;
  font-family: inherit;
  resize: vertical;
  transition: border-color 0.2s ease;
}

.input-field:focus {
  outline: none;
  border-color: #e75757;
}

.btn-primary {
  padding: 0.5rem 1rem;
  background: #e75757;
  color: white;
  border: none;
  border-radius: 6px;
  font-size: 0.9rem;
  cursor: pointer;
  transition: background-color 0.2s ease;
}

.btn-primary:hover {
  background: #d64545;
}

.btn-subtle {
  padding: 0.4rem 0.8rem;
  background: transparent;
  color: #666;
  border: 1px solid #e0e0e0;
  border-radius: 4px;
  font-size: 0.85rem;
  cursor: pointer;
  transition: all 0.2s ease;
}

.btn-subtle:hover {
  background: #f5f5f5;
  border-color: #d0d0d0;
}

.comment {
  margin: 0.05rem 0;
  padding: 0.5rem 0.7rem;
  border-bottom: 1px solid #eee;
  border-radius: 0;
  border-top: none;
  border-left: none;
  border-right: none;
}

.comment-form {
  display: flex;
  flex-direction: column;
  align-items: flex-end;  /* Changed: Align comment button to the right */
  gap: 0.5rem;
}

.reply {
  margin: 0.05rem 0 0.2rem 1.0rem;
  padding: 0.3rem 0.7rem;
  background: #fafafa;
  border-left: 2px solid #e0e0e0;
  border-radius: 0 6px 6px 0;
  font-size: 0.9rem;
}

.comment:last-child {
  border-bottom: none;
}

.comment-header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 0.75rem;
  font-size: 0.9rem;
  color: #666;
}

.reply-header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 0.4rem;
  font-size: 0.85rem;
  color: #666;
}

.author {
  font-weight: 500;
  color: #444;
}

.date {
  color: #888;
}

.comment-content {
  line-height: 1.5;
  margin-bottom: 0.75rem;
}

.reply-content {
  line-height: 1.4;
  margin-bottom: 0;
  color: #444;
}

.loading {
  text-align: center;
  color: #666;
  padding: 2rem;
}

/* 아이콘 버튼 스타일 */
.btn-icon {
  background: transparent; /* 배경 투명 */
  border: none; /* 테두리 제거 */
  padding: 6px; /* 내부 여백 */
  color: #666; /* 아이콘 색상 */
  cursor: pointer; /* 마우스 포인터 변경 */
  display: flex; /* flexbox 사용 */
  align-items: center; /* 세로 중앙 정렬 */
  justify-content: center; /* 가로 중앙 정렬 */
  border-radius: 50%; /* 원형 버튼 */
  transition: all 0.2s ease; /* 부드러운 전환 효과 */
}

/* 아이콘 버튼 호버 효과 */
.btn-icon:hover {
  background: #f5f5f5; /* 호버시 배경색 변경 */
  color: #e75757; /* 호버시 아이콘 색상 변경 */
}

/* 아이콘 자체 스타일 */
.icon {
  stroke-width: 1.5px; /* 아이콘 선 두께 */
}

/* 대댓글 스타일 */
.comment-actions {
  display: flex;
  align-items: center;
  gap: 10px;
  margin-top: 0.75rem;
  height: 36px;
  width: 100%; /* 아이콘과 답글 촘 같은 행 두기 */
}

.inline-reply-form {
  display: flex;
  align-items: center;
  gap: 8px;
  flex: 1; /* 아이콘과 답글 촘 같은 행 두기 */
  height: 100%;  /* 아이콘과 답글 촘 같은 행 두기 */
  margin: 0;
}

.inline-input {
  flex-grow: 1;
  height: 36px; /* 높이 통일 */
  padding: 0 12px;
  border: 1px solid #e0e0e0;
  border-radius: 20px;
  font-size: 0.9rem;
  transition: border-color 0.2s ease;
}

.inline-input:focus {
  outline: none;
  border-color: #e75757;
}

.btn-send {
  height: 36px; /* 높이 통일 */
  padding: 0 16px;
  background: #e75757;
  color: white;
  border: none;
  border-radius: 20px;
  font-size: 0.85rem;
  cursor: pointer;
  transition: background-color 0.2s ease;
  white-space: nowrap; /* 텍스트 줄바꿈 방지 */
}

.btn-send:hover {
  background: #d64545;
}
</style>