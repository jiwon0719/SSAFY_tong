<template>
  <div>
    <h4>List</h4>
    <button @click="registerIdolForm">등록하기</button>
    <div v-for="idol in idols" :key="idol.no" @click="detailIdol(idol.no)"> <!-- 클릭시, 백앤드 정보 요청할 함수 -->
      <p>번호 : {{idol.no}}</p>
      <p>이름 : {{idol.name}}</p>
      <p>성별 : {{idol.gender}}</p>
    </div>
  </div>
</template>

<script setup>

</script>

<style scoped>

</style>