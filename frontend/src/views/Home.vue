<template>
    <div v-if="this.user.rol.name == 'usuario'">
        <HomeUsuario />
    </div>
    <div v-else-if="this.user.rol.name == 'jefe analista'">
        <HomeJefe />
    </div>
    <div v-else-if="this.user.rol.name == 'analista'">
        <HomeAnalista />
    </div>
    <div v-else>
        <h1>Bienvenido</h1>
    </div>
</template>

<script>
    import HomeUsuario from '../components/HomeUsuario.vue';
    import HomeJefe from '../components/HomeJefe.vue';
    import HomeAnalista from '../components/HomeAnalista.vue';

    export default {
        components: {
            HomeUsuario,
            HomeJefe,
            HomeAnalista,
        },
    };
</script>