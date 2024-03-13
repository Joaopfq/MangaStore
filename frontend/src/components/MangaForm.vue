<template>
    <VCard>
        <VCardTitle v-if="!edit">
            Adicionar mangá
        </VCardTitle>
        <VCardTitle v-else>
            Editar mangá
        </VCardTitle>
        <VCardText class="">
            <VTextField
                v-model="nome"
                variant="outlined"
                label="Nome do mangá"
                :rules="nameRules"
            >
            </VTextField>
            <VTextField
                v-model="value"
                class="my-5"
                variant="outlined"
                label="Preço do mangá"
                type="input"
                :rules="valueRules"
                prefix="R$"
            >
                
            </VTextField>
            <VTextarea
                v-model="sinopse"
                variant="outlined"
                label="Breve descrição do mangá"
                :rules="sinopseRules"
            >

            </VTextarea>
        </VCardText>
        <VCardActions class="d-flex justify-center align-items-center my-3">
            <VBtn v-if="!edit" @click="() => handleSubmit()" variant="flat" color="success">
                Adicionar
            </VBtn>
            <VBtn v-else @click="() => handleSubmit()" variant="flat" color="info">
                Editar
            </VBtn>
        </VCardActions>
    </VCard>
</template>

<script setup lang="ts">

import { ref } from "vue";

const props = defineProps<{
    edit: boolean,
    request: (nome: string | undefined, value: number, sinopse: string | undefined, id: number) => Promise<void>,
    id: number;
    nome?: string;
    value: number;
    sinopse?: string;
}>();

const emit = defineEmits<{ submit: [] }>()
const nome = ref(props.nome ?? "");
const sinopse = ref(props.sinopse ?? "");
const value = ref(props.value);

async function handleSubmit(){
    await props.request(nome.value, value.value, sinopse.value, props.id);
    emit("submit");
}



function verificarSeSaoApenasNumeros(input: string): boolean {
  const regexApenasNumeros = /^[0-9]+$/;

  return regexApenasNumeros.test(input);
}

type rule = string|boolean;

const nameRules = [
    (value: string): rule => {
        if(value) return true;
        return 'O nome é obrigatório'
    }
]

const valueRules = [
    (value: number): rule => {
        if(value) return true;
        return 'O valor é obrigatório'
    },
    (value: string): rule => {
        if(verificarSeSaoApenasNumeros(value)) return true;
        return 'Apenas números são aceitos';
    }
]

const sinopseRules = [
    (value: string): rule => {
        if(value) return true;
        return 'A sinopse é obrigatória'
    }
]

</script>