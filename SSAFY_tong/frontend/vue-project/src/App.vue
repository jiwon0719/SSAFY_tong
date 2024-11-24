<script>
// StartView 컴포넌트를 불러옵니다.
import StartView from './views/StartView.vue'

export default {
  name: 'App',
  components: {
    StartView
  }
}
</script>


<template>
  <div id="app">
    <RouterLink :to="{name: 'main'}"></RouterLink>
    <RouterView />
  </div>
</template>


<style scoped>
/* 글씨 폰트인 Jocky One 불러와서 사용 */
@import url('https://fonts.googleapis.com/css2?family=Jockey+One&display=swap');

/* 
header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
} */
</style>

<style>
#app {
  margin: 0;
  padding: 0;
  overflow-x: hidden;
  width: 100%;
}

body {
  margin: 0;
  padding: 0;
  overflow-x: hidden;
}
</style>