<template>
  <div class="post-detail">
    <!-- 게시글 헤더 -->
    <header class="post-header">
      <h1>{{ post.title }}</h1>
      <div class="post-info">
        <span>작성자: {{ post.writer }}</span>
        <span>작성일: {{ post.regDate }}</span>
        <span>조회수: {{ post.viewCnt }}</span>
        <span>댓글수: {{ post.commentCount }}</span> 
      </div>
    </header>

    <!-- 게시글 내용 -->
    <div class="post-content">
      {{ post.content }}
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
      
      
      <!-- 댓글 목록 -->
      <div class="comments-list">
          <div v-for="comment in comments" :key="comment.id" class="comment">
              <div class="comment-header">
                  <span class="author">{{ comment.author }}</span>
                  <span class="date">{{ comment.date }}</span>
                </div>
                <div class="comment-content">{{ comment.content }}</div>
                <div class="comment-actions">
                    <button @click="replyToId = comment.id">대댓글</button>
                </div>
                
                <!-- 대댓글 작성 폼 -->
                <div v-if="replyToId === comment.id" class="reply-form">
                    <textarea 
                    v-model="newReply"
                    placeholder="답글을 작성해주세요"
                    ></textarea>
                    <button @click="addReply(comment.id)">등록</button>
                </div>
                
                <!-- 대댓글 목록 -->
                <div v-for="reply in comment.replies" 
                :key="reply.id" 
                class="reply">
                <div class="reply-header">
                    <span class="author">{{ reply.author }}</span>
                    <span class="date">{{ reply.date }}</span>
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
      <button @click="addComment">댓글 등록</button>
    </div>
 
</section>
  </div>
</template>

<script setup>
import { ref, reactive, watch } from 'vue'
import { useBoardStore } from '@/stores/board';

const boardStore = useBoardStore();

// 게시글 상세 정보
const post = reactive({
  boardId: boardStore.currentBoard.boardId,
  title: boardStore.currentBoard.title,
  content: boardStore.currentBoard.content,
  writer: boardStore.currentBoard.writer,
  regDate: boardStore.currentBoard.regDate,
  viewCnt: boardStore.currentBoard.viewCnt,
  commentCount: 0
})

// 다른 게시글 선택시 데이터 변경 처리
watch(() => boardStore.currentBoard, (newBoard) => {
  post.boardId = newBoard.boardId
  post.title = newBoard.title
  post.content = newBoard.content
  post.writer = newBoard.writer
  post.regDate = newBoard.regDate
  post.viewCnt = newBoard.viewCnt
  post.commentCount = newBoard.commentCount
})


// 댓글 목록
const comments = reactive([
  {
    id: 1,
    content: '댓글 내용입니다.',
    author: '댓글작성자',
    date: '2024-11-01 10:07',
    replies: [
      {
        id: 1,
        content: '대댓글 내용입니다.',
        author: '대댓글작성자',
        date: '2024-11-01 10:08'
      }
    ]
  }
])

// 새 댓글 입력
const newComment = ref('')
const newReply = ref('')
const replyToId = ref(null)

// 댓글 등록
const addComment = () => {
  if (!newComment.value) return
  
  comments.push({
    id: comments.length + 1,
    content: newComment.value,
    author: '현재 사용자',
    date: new Date().toLocaleString(),
    replies: []
  })
  newComment.value = ''
}

// 대댓글 등록
const addReply = (commentId) => {
  if (!newReply.value) return
  
  const comment = comments.find(c => c.id === commentId)
  if (comment) {
    comment.replies.push({
      id: comment.replies.length + 1,
      content: newReply.value,
      author: '현재 사용자',
      date: new Date().toLocaleString()
    })
    newReply.value = ''
    replyToId.value = null
  }
}
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
  border-left: 2px solid #ddd;
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