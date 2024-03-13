<template>
    <VContainer class="d-flex justify-center">
        <VDialog v-model="open" width="600px">
            <template #activator="{ props }">
                <VBtn v-bind="props" variant="tonal">
                    Adicionar mangá
                </VBtn>
            </template>
            <MangaForm @submit="emit('submit')" :request="postManga" :edit="false" nome="" sinopse="" :value="0" :id="-1"/>
        </VDialog>
    </VContainer>
</template>

<script setup lang="ts">
import axios from "axios";
import MangaForm from "./MangaForm.vue";
import { ref } from "vue";

const open = ref(false);

const emit = defineEmits<{ submit: [] }>()

async function postManga(nome: string | undefined, value: number, sinopse: string | undefined) {
    await axios.post(`http://localhost:8080/api/v1/mangas`, {
      nome,
      sinopse,
      value
    });
    open.value = false;
}

</script>