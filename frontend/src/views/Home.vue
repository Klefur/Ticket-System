<template>
    <div>
        <HomeUsuario v-if="user.rol.nombre == 'usuario'" class="usuario"/>
        <HomeJefe v-else-if="user.rol.nombre == 'jefe analista'"/>
        <HomeAnalista v-else-if="user.rol.nombre == 'analista'"/>
    </div>
</template>

<script setup>
    import HomeUsuario from '../components/HomeUsuario.vue';
    import HomeJefe from '../components/HomeJefe.vue';
    import HomeAnalista from '../components/HomeAnalista.vue';

    const user = JSON.parse(localStorage.getItem('user'))
    console.log(user)
</script>

<style>
</style>