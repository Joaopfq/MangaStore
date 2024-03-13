<template>
  <VContainer>
    <MangaModal @submit="fetchMangas" :edit="false" :id="-1" nome="" sinopse="" :value="0" />
    <VCard class="d-flex justify-center align-center w-50 h-50" v-if="mangas.length === 0 && !mangaLoading">
      <h2 >Nenhum mangá cadastrado</h2>
    </VCard>
    <VList min-height="600px" min-width="600px" v-else class="d-flex flex-wrap flex-md-row justify-center">
		  <VListItem v-for="manga in mangas" :key="manga.nome">
				<MangaCard @submit="fetchMangas" :id="manga.id" :nome="manga.nome" :sinopse="manga.sinopse" :value="manga.value" />     
		  </VListItem>
    </VList>
  </VContainer>
</template>

<script setup lang="ts">
import MangaCard from "./MangaCard.vue";
import axios from "axios";
import { ref } from "vue";
import type { Manga } from "../models/MangaModel";
import MangaModal from "./MangaModal.vue";

const mangas = ref<Manga[]>([])

let mangaLoading = ref(true);

async function fetchMangas(){
    const result = await axios.get(`http://localhost:8080/api/v1/mangas`);
    mangas.value = result.data;
    mangaLoading.value = false;
}

fetchMangas();

</script>