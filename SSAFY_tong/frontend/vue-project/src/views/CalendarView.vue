<template>
    <v-app>
      <v-container>
        <v-row>
          <!-- Date Picker Column -->
          <v-col cols="12" sm="6" class="my-2 px-1">
            <v-menu
              v-model="menu"
              :close-on-content-click="false"
              transition="scale-transition"
              offset-y
              max-width="290px"
              min-width="290px"
            >
              <template v-slot:activator="{ props }">
                <v-text-field
                  v-model="date"
                  label="Pick a date"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="props"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="pickerDate"
                @input="menu = false"
              ></v-date-picker>
            </v-menu>
          </v-col>
  
          <!-- Notes Column -->
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
      </v-container>
    </v-app>
  </template>
  
  <script setup>
  import { ref, watch } from 'vue'
  
  // Reactive State
  const date = ref(new Date().toISOString().substr(0, 10))
  const pickerDate = ref(null)
  const menu = ref(false)
  const notes = ref([])
  const allNotes = [
    'President met with prime minister',
    'New power plant opened',
    'Rocket launch announced',
    'Global warming discussion cancelled',
    'Company changed its location',
  ]
  
  // Watcher to update notes when pickerDate changes
  watch(pickerDate, (val) => {
    if (val) {
      const selectedNotes = [
        allNotes[Math.floor(Math.random() * allNotes.length)],
        allNotes[Math.floor(Math.random() * allNotes.length)],
        allNotes[Math.floor(Math.random() * allNotes.length)],
      ]
      notes.value = Array.from(new Set(selectedNotes)) // 중복 제거
    }
  })
  </script>
  
  <style scoped>
  .v-text-field {
    width: 100%;
  }
  </style>
  