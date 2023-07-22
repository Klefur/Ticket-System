<template>
  <div>
    <NavBar />
    <router-view class="container"/>
  </div>
</template>

<script>
import NavBar from '@/components/NavBar.vue';

export default {
  name: 'App',
  components: {
    NavBar,
  },
};
</script>

<style>
  .container {
        justify-content: center;
        align-items: center;
        height: 100vh;
        padding: 300px;
        background-color: #f9f9f9;
  }
</style>