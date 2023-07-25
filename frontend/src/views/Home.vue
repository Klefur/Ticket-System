<template>
    <div>
        <HomeUsuario v-if="store.user.rol.nombre == 'usuario'" class="usuario" />
        <HomeJefe v-else-if="store.user.rol.nombre == 'jefe analista'" />
        <HomeAnalista v-else-if="store.user.rol.nombre == 'analista'" />
    </div>
</template>

<script setup>
import HomeUsuario from '../components/HomeUsuario.vue';
import HomeJefe from '../components/HomeJefe.vue';
import HomeAnalista from '../components/HomeAnalista.vue';
import { store } from '../store';

console.log(store.user)
</script>

<style></style>