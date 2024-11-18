// stores/board.js
import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const BOARD_API_URL = `http://localhost:8080/api/board`
const REST_API_URL = `http://localhost:8080/api/boardCategory`
// const BOARD_API_URL = `http://192.168.210.55:8080/api/board`
// const REST_API_URL = `http://192.168.210.55:8080/api/boardCategory`

export const useBoardStore = defineStore('board', () => {
  const boardList = ref([]) // 게시글 목록
  const currentBoard = ref(null) // 현재 선택된 게시글
  
  // 게시글 목록 조회
  const getBoardList = async (categoryId) => {
    try {
      const response = await axios.get(`${REST_API_URL}/${categoryId}`)
      console.log("게시글 목록 조회 응답: ", response.data)

      boardList.value = response.data
      return response.data
    } catch (error) {
      console.error("게시글 목록을 가져오는데 실패했습니다:", error)
      throw error
    }
  }

  // 게시글 상세 조회
  const getBoardDetail = async (boardId) => {
    try {
      // 게시글 상세 정보를 먼저 가져옴
      const response = await axios.get(`${BOARD_API_URL}/${boardId}`)
      currentBoard.value = response.data
      
      // 조회수 증가 API를 따로 호출
      await axios.post(`${BOARD_API_URL}/${boardId}/incrementView`)
      
      // 증가된 조회수를 반영하기 위해 게시글 정보를 다시 가져옴
      const updatedResponse = await axios.get(`${BOARD_API_URL}/${boardId}`)
      currentBoard.value = updatedResponse.data
      
      // 조회수 증가를 위해 추가한 부분
      // boardList에서 해당 게시글의 조회수도 업데이트
      const boardIndex = boardList.value.findIndex(board => board.boardId === boardId)
      if (boardIndex !== -1) {
        boardList.value[boardIndex] = {
          ...boardList.value[boardIndex],
          viewCount: currentBoard.value.viewCount
        }
      }      

      console.log("게시글 상세 조회 완료")
      return updatedResponse.data
    } catch (error) {
      console.error("게시글 상세 정보를 가져오는데 실패했습니다:", error)
      throw error
    }
  }

  // 댓글 수 조회 함수
  // 댓글 수 조회 함수 수정 - URL 변경
  const getCommentCount = async(boardId) => {
    try {
      // boardCategory API가 아닌 board API 사용
      const response = await axios.get(`${BOARD_API_URL}/${boardId}/commentCount`);
      // console.log(`게시글 ${boardId}의 댓글 수:`, response.data);
      return response.data;
    } catch (error) {
      console.error(`게시글 ${boardId}의 댓글 수 조회 실패:`, error);
      return 0;
    }
  };



  // 게시글 등록
  const createBoard = async (boardData) => {
    try {
      const response = await axios.post(BOARD_API_URL, boardData)
      console.log("게시글 등록 완료:", response.data)
      // 게시글 목록 갱신
      await getBoardList(boardData.categoryId)
      return response.data
    } catch (error) {
      console.error("게시글 등록에 실패했습니다:", error)
      throw error
    }
  }

  // 게시글 수정
  const updateBoard = async (boardId, boardData) => {
    try {
      const response = await axios.put(`${BOARD_API_URL}/${boardId}`, boardData)
      console.log("게시글 수정 완료")
      return response.data
    } catch (error) {
      console.error("게시글 수정에 실패했습니다:", error)
      throw error
    }
  }

  // 게시글 삭제
  const deleteBoard = async (boardId) => {
    try {
      await axios.delete(`${BOARD_API_URL}/${boardId}`)
      console.log("게시글 삭제 완료")
      boardList.value = boardList.value.filter(board => board.id !== boardId)
    } catch (error) {
      console.error("게시글 삭제에 실패했습니다:", error)
      throw error
    }
  }

  return {
    boardList,
    currentBoard,
    getBoardList,
    getBoardDetail,
    createBoard,
    updateBoard,
    deleteBoard, 
    getCommentCount, 
  }
})