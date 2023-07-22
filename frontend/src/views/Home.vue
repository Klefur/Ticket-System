<template>
        <div v-if="user.rol.nombre == 'usuario'">
            <HomeUsuario />
        </div>
        <div v-else-if="user.rol.nombre == 'jefe analista'">
            <HomeJefe />
        </div>
        <div v-else-if="user.rol.nombre == 'analista'">
            <HomeAnalista />
        </div>
</template>

<script setup>
    import HomeUsuario from '../components/HomeUsuario.vue';
    import HomeJefe from '../components/HomeJefe.vue';
    import HomeAnalista from '../components/HomeAnalista.vue';

    const user = JSON.parse(localStorage.getItem('user'))
    console.log(user)
</script>