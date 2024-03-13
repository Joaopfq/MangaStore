<template>
    <VDialog width="600px" v-model="open">
        <template #activator="{ props }">
            <VCard v-bind="props" width="500px" min-height="300px" class="ma-6" variant="elevated" color="#222622">
                <VCardActions>
                    <VBtn @click.stop="() => deleteManga(id)">
                        <VIcon size="24" color="red" icon="mdi-close-circle" />
                    </VBtn>
                </VCardActions>
                <VCardText >
                    <p class="text-h5 text--primary mb-3 font-weight-bold text-md-center">
                        {{ nome }}
                    </p>
                    <VDivider class="border-opacity-25" color="#5e635e" thickness="2"/>
                    <div class="text-h6 text--primary my-3 text-center">
                        {{ sinopse }}
                    </div>
                    <VDivider class="border-opacity-25" color="#5e635e" thickness="2"/>
                    <div class="text-h4 font-weight-black mt-3 text-md-center">
                        {{ "R$ " + value }}
                    </div>
                </VCardText>
            </VCard>
        </template>
        <MangaForm @submit="emit('submit')" :request="putManga" :edit="true" :nome="nome" :sinopse="sinopse" :value="value" :id="id"/>
    </VDialog>
</template>

<script setup lang="ts">
import axios from "axios";
import MangaForm from "./MangaForm.vue";
import { ref } from "vue";

const open = ref(false);
const emit = defineEmits<{ submit: [] }>();


async function deleteManga(id: number){
    try {
        await axios.delete(`http://localhost:8080/api/v1/mangas/${id}`);
        emit("submit");
    } catch(error){

    }
}

async function putManga(nome: string | undefined, value: number, sinopse: string | undefined, id: number) {
    await axios.put(`http://localhost:8080/api/v1/mangas`, {
      nome,
      sinopse,
      value,
      id
    });

    open.value = false;
}

defineProps<{
    id: number;
    nome?: string;
    value: number;
    sinopse?: string;
}>();

</script>