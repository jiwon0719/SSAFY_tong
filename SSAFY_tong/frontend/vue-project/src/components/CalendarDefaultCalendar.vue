<template>
    <v-app>
      <v-row>
        <v-col cols="12" sm="6" class="my-2 px-1">
          <v-date-picker v-model="date" :picker-date.sync="pickerDate" full-width></v-date-picker>
        </v-col>
        <v-col cols="12" sm="6" class="my-2 px-1">
          <div class="text-h6">
            Month news ({{ pickerDate || 'change month...' }})
          </div>
          <div class="subheading">
            Change month to see other news
          </div>
          <ul class="ma-4">
            <li v-for="note in notes" :key="note">{{ note }}</li>
          </ul>
        </v-col>
      </v-row>
    </v-app>
  </template>
  
  <script>
  import { defineComponent, ref, watch } from 'vue';
  
  export default defineComponent({
    setup() {
      const date = ref((new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10));
      const pickerDate = ref(null);
      const notes = ref([]);
      const allNotes = [
        'President met with prime minister',
        'New power plant opened',
        'Rocket launch announced',
        'Global warming discussion cancelled',
        'Company changed its location',
      ];
  
      watch(pickerDate, () => {
        notes.value = [
          allNotes[Math.floor(Math.random() * 5)],
          allNotes[Math.floor(Math.random() * 5)],
          allNotes[Math.floor(Math.random() * 5)],
        ].filter((value, index, self) => self.indexOf(value) === index);
      });
  
      return {
        date,
        pickerDate,
        notes,
        allNotes
      };
    }
  });
  </script>
  
  <style scoped>
  /* 필요한 스타일을 여기에 추가하세요 */
  </style>
  