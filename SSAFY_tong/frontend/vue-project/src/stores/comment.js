import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

const COMMENT_API_URL = 'http://localhost:8080/api/comment'

export const useCommentStore = defineStore('comment',() => {
    const comments = ref([]); // 댓글과 대댓글의 구분 없이 모든 댓글 저장
    const loading = ref(false)
    const error = ref(null)

    // 전체 댓글 조회
    // userType 포함하도록 수정
    const getCommentsList = async (boardId) => {
        try {
            loading.value = true;

            const response = await axios.get(`${COMMENT_API_URL}/${boardId}`)
            console.log("API 응답 데이터(userType 확인하기!!!) : ", response.data)

            if(Array.isArray(response.data)) {
                comments.value = response.data;
            } else if( response.data && typeof response.data === 'object') {
                // 응답이 객체인 경우, 실제 댓글 배열이 있는 속성을 찾아 할당
                comments.value = response.data.comments || response.data.data || [];                
            } else {
                comments.value = []; // 적절한 데이터가 없는 경우 빈 배열로 초기화
            }

            console.log("전체 댓글: ", comments.value);

            // comments.value가 배열인지 확인 후 트리 구조로 변환
            if (Array.isArray(comments.value)) {
                const commentTree = getCommentTree();
                return commentTree;
            }
            return []; // 배열이 아닌 경우 빈 배열 반환
            
        } catch (error) {
            console.error("전체 댓글 조회 실패", error)
            error.value = error.message
            throw error
        } finally {
            loading.value = false
        }
    }


    // 댓글 : 트리 구조 변환
    const getCommentTree = () => {
        // 모든 댓글을 commentId키로 저장
        // Map을 이용해 빠른 검색 가능
        const commentMap = new Map()
        const rootComments = []

        comments.value.forEach(comment => {
            comment.replies = []  //각 댓글마다 대댓글 저장할 공간
            commentMap.set(comment.commentId, comment)
        })

        comments.value.forEach(comment => {
            if(comment.parentCommentId === null) { // 댓글일 경우
                rootComments.push(comment)
            } else { // 대댓글일 경우 
                const parentComment = commentMap.get(comment.parentCommentId)
                if(parentComment) {
                    parentComment.replies.push(comment)
                } else {
                    console.error("부모 댓글을 찾을 수 없습니다.", comment);
                }
            }
        })

        console.log("트리 구조: ", rootComments)
        return rootComments;
            // 변환된 트리 구조 반환
            // 예시 출력 데이터:
            // [
            //   { 
            //     commentId: 1, 
            //     content: "부모댓글1", 
            //     parentCommentId: null,
            //     replies: [
            //       { commentId: 2, content: "1번의 대댓글", parentCommentId: 1 },
            //       { commentId: 4, content: "1번의 두번째 대댓글", parentCommentId: 1 }
            //     ]
            //   },
            //   {
            //     commentId: 3,
            //     content: "부모댓글2",
            //     parentCommentId: null,
            //     replies: []
            //   }
            // ]
    }

    // 댓글 등록
    const registComment = async (commentData) => {
        try {
            const response = await axios.post(COMMENT_API_URL, {
                boardId: commentData.boardId, 
                content: commentData.content, 
                commenter: commentData.commenter, 
                parentCommentId: null
            })
            console.log("댓글 등록 완료")

            // 댓글 목록 갱신
            await getCommentsList(commentData.boardId)

        } catch (error) {
            console.error("댓글 등록 실패: ", error)
            error.value = error.message
            throw error
        }
    }


    // 대댓글 등록
    const registReply = async(replyData) => {
        try {
            const response = await axios.post(COMMENT_API_URL, {
                boardId: replyData.boardId, 
                content: replyData.content, 
                commenter: replyData.commenter, 
                parentCommentId: replyData.parentCommentId
            })
            console.log("대댓글 등록 완료")
            console.log(response.data)

            // 댓글 목록 갱신
            await getCommentsList(replyData.boardId)

            return response.data
        } catch (error) {
            console.error("대댓글 등록 실패: ", error)
            error.value = error.message
            throw error
        }
    }

    // 댓글 수정
    // const updateComment = async (commentId, commentData) => {
    //     try {
    //       const response = await axios.put(`${COMMENT_API_URL}/${commentId}`, commentData)
    //       console.log("댓글 수정 완료")
    //       await fetchComments(commentData.boardId)
    //       return response.data
    //     } catch (error) {
    //       console.error("댓글 수정에 실패했습니다:", error)
    //       error.value = error.message
    //       throw error
    //     }
    //   }

    // 댓글 삭제
    // const deleteComment = async (commentId, boardId) => {
    //     try {
    //       await axios.delete(`${COMMENT_API_URL}/${commentId}`)
    //       console.log("댓글 삭제 완료")
    //       // 댓글 목록 갱신
    //       await fetchComments(boardId)
    //     } catch (error) {
    //       console.error("댓글 삭제에 실패했습니다:", error)
    //       error.value = error.message
    //       throw error
    //     }
    //   }

    return {
        comments,
        loading,
        error,
        getCommentTree,
        getCommentsList,
        registComment,
        registReply,
        // updateComment,
        // deleteComment
      }
})