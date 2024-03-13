<template>
<VApp theme="dark">
  <Navbar />
  <VMain class="d-flex flex-column align-center justify-center">
    <VCol class="d-flex flex-column align-center justify-center">
      <MangasList />
    </VCol>
  </VMain>
  <Footer />
</VApp>
</template>

<script setup lang="ts">
import Navbar from './components/Navbar.vue'
import Footer from './components/Footer.vue'
import MangasList from './components/MangasList.vue';
import MangaModal from './components/MangaModal.vue'

</script>

<style scoped>
</style>