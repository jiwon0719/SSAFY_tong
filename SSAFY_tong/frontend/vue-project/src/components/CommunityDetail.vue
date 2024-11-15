<template>
  <div class="post-detail">
    <!-- 게시글 헤더 -->
    <header class="post-header">
      <h1>{{ currentBoard?.title }}</h1>
      <div class="post-info">
        <span>작성자: {{ currentBoard?.writer }}</span>
        <span>작성일: {{ currentBoard?.regDate }}</span>
        <span>조회수: {{ currentBoard?.viewCnt }}</span>
        <!-- <span>댓글수: {{ currentBoard?.commentCount }}</span>  -->
      </div>
    </header>

    <!-- 게시글 내용 -->
    <div class="post-content">
      {{ currentBoard?.content }}
    </div>

    <!-- 게시글 작업 버튼 -->
    <div class="post-actions">
      <button class="btn">수정</button>
      <button class="btn">삭제</button>
      <button class="btn" @click="$router.push('/community')">목록으로</button>
    </div>

    <!-- 댓글 섹션 -->
    <section class="comments-section">
      <h2>댓글</h2>
      
      <div v-if="commentStore.loading" class="loading">
        댓글을 불러오는 중...
      </div>
      
      <!-- 댓글 목록 -->
      <div v-else class="comments-list">
        <div v-for="comment in comments" :key="comment.commentId" class="comment">
          <div class="comment-header">
            <span class="author">{{ comment.commenter }}</span>
            <span class="date">{{ formatDate(comment.regDate) }}</span>
          </div>
          <div class="comment-content">{{ comment.content }}</div>
          <div class="comment-actions">
            <button @click="replyToId = comment.commentId">대댓글</button>
          </div>
                
          <!-- 대댓글 작성 폼 -->
          <div v-if="replyToId === comment.commentId" class="reply-form">
            <textarea 
            v-model="newReply"
            placeholder="답글을 작성해주세요"
            ></textarea>
            <button @click="handleRegisterReply(comment.commentId)">등록</button>
          </div>
                
          <!-- 대댓글 목록 -->
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

      <!-- 댓글 작성 -->
      <div class="comment-form">
        <textarea 
          v-model="newComment"
          placeholder="댓글을 작성해주세요"
        ></textarea>
        <button @click="handleRegisterComment()">댓글 등록</button>
      </div>

    </section>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useBoardStore } from '@/stores/board';
import { useCommentStore } from '@/stores/comment';
import { storeToRefs } from 'pinia';
import { useRoute } from 'vue-router'

// Pinia 스토어 참조
const boardStore = useBoardStore();
const commentStore = useCommentStore();

// 게시글 데이터와 댓글 데이터
const { currentBoard } = storeToRefs(boardStore);
const { comments } = storeToRefs(commentStore);

// 댓글 상태
const newComment = ref('');
const newReply = ref('');
const replyToId = ref(null);

// 라우트 파라미터로 전달된 boardId 받기
const route = useRoute();
const boardId = route.params.boardId;


// 컴포넌트 마운트 시 데이터 로딩
onMounted(async () => {
  if (boardId) {
    try {
      console.log(boardId); // 게시글 번호 출력
      // 게시글 상세 로드 
      await boardStore.getBoardDetail(boardId);
      // 댓글 및 대댓글 로드
      await commentStore.getCommentsList(boardId);
    } catch (error) {
      console.error('댓글 데이터를 불러오는 중 오류가 발생했습니다:', error);
    }
  }
});

// 날짜 포맷 함수
const formatDate = (dateString) => new Date(dateString).toLocaleString();

// 댓글 등록 핸들러
const handleRegisterComment = async () => {
  if (!newComment.value.trim()) return;

  try {
    await commentStore.registComment({
      boardId: currentBoard.value.boardId,
      content: newComment.value,
      commenter: 'admin',
    });
    newComment.value = ''; // 입력 필드 초기화
  } catch (error) {
    alert('댓글 작성에 실패했습니다.');
  }
};

// 대댓글 등록 핸들러
const handleRegisterReply = async (parentCommentId) => {
  if (!newReply.value.trim()) return;

  try {
    // console.log(parentCommentId);
    await commentStore.registReply({
      boardId: currentBoard.value.boardId,
      parentCommentId: parentCommentId,
      content: newReply.value,
      commenter: 'admin',
    });
    newReply.value = ''; // 입력 필드 초기화
    replyToId.value = null; // 대댓글 대상 초기화
  } catch (error) {
    alert('대댓글 작성에 실패했습니다.');
  }
};
</script>

<style scoped>
.post-detail {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.post-header {
  margin-bottom: 20px;
}

.post-info {
  display: flex;
  gap: 20px;
  color: #666;
  font-size: 0.9em;
}

.post-content {
  min-height: 200px;
  margin: 20px 0;
  padding: 20px;
  background: #f9f9f9;
  border-radius: 4px;
}

.post-actions {
  display: flex;
  gap: 10px;
  margin: 20px 0;
}

.btn {
  padding: 8px 16px;
  border: 1px solid #ddd;
  border-radius: 4px;
  background: #e75757;
  cursor: pointer;
}

.comments-section {
  margin-top: 40px;
}

.comment-form,
.reply-form {
  margin: 20px 0;
}

textarea {
  width: 100%;
  min-height: 100px;
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.comment {
  margin: 20px 0;
  padding: 15px;
  border: 1px solid #eee;
  border-radius: 4px;
}

.reply {
  margin: 10px 0 10px 20px;
  padding: 10px;
  background: #f9f9f9;
  border-left: 3px solid #ddd; /* 대댓글과 댓글을 구분하기 위해 강조 */
  padding-left: 15px; /* 좌측 여백 추가 */
  margin-left: 20px; /* 댓글과의 간격 유지 */
}

.comment-header,
.reply-header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
  font-size: 0.9em;
  color: #666;
}

.comment-actions {
  margin-top: 10px;
}

button {
  padding: 8px 16px;
  background: #e75757;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background: #e75757;
}
</style>