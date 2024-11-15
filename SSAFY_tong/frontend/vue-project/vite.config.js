import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'
import vuetify from 'vite-plugin-vuetify'

// https://vite.dev/config/
export default defineConfig({
  server: {
<<<<<<< HEAD
    host: '0.0.0.0',  // 모든 네트워크 인터페이스에서 접근 가능
    port: 5173,       // 기본 포트
=======
    host: '0.0.0.0', // 모든 IP에서 접근 가능하게 설정
    port: 5173       // 포트 번호는 5173으로 유지
>>>>>>> d9062e22c1ae92f5d6219af7509b59a7852dc93d
  },
  plugins: [
    vue(),
    vueDevTools(),
    vuetify({ autoImport: true }),
  ],
  css : {
    preprocessorOptions: {
      scss: {
        additionalData: `@use "vuetify/styles" as *;`,
      },
    },
  },
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
})