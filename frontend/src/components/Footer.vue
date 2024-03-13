<template>
    <VFooter app color="black" class="footer">
        <VRow justify="center" no-gutters>
            <VBtn color="black" class="about-button" size="large" :href="url">
                About
            </VBtn>
        </VRow>
    </VFooter>
</template>

<script setup lang="ts">

const url = "https://github.com/Joaopfq/MangaStore"
</script>

<style scoped>

.about-button{
    background-color: black;
}

</style>