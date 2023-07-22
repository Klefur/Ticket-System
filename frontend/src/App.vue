<template>
  <div class="">
    <NavBar />
    <router-view class="container"/>
  </div>
</template>

<script setup>
import NavBar from '@/components/NavBar.vue';
</script>

<style>
  .container {
    justify-content: center;
    align-items: center;
    padding: 4rem 2rem 4rem 2rem;
    background-color: #f9f9f9;
    display: grid;
    grid-gap: 1rem;
  }
</style>