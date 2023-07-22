<template>
  <div class="">
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
    padding: 12rem 2rem 12rem 2rem;
    background-color: #f9f9f9;
    display: grid;
    grid-gap: 1rem;
  }
</style>