<script setup>
import { RouterLink, RouterView } from 'vue-router'

</script>

<template>
  <header class="header">
    <div class="logo-container">
      <img alt="Usach logo" class="logo" src="@/assets/logo.svg" width="200" height="200" />
    </div>

    <div class="content-wrapper">
      <h1 class="title">Sistema de Tickets</h1>
      <h2 class="subtitle">Universidad Santiago de Chile</h2>

      <nav>
        <RouterLink class="nav-link" to="/">Asignar Analista</RouterLink>
        <RouterLink class="nav-link" to="/CrearTicket">Crear Ticket</RouterLink>
        
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style scoped>
.header {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 2rem;
  background-color: #f8f8f8;
}

.logo-container {
  margin-bottom: 2rem;
}

.logo {
  display: block;
  width: 100%;
  max-width: 200px;
  height: auto;
}

.content-wrapper {
  text-align: center;
}

.title {
  font-size: 2rem;
  margin-bottom: 2rem;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
  font-weight: bold;
  color: #F17E22;
}

.subtitle {
  font-size: 1rem;
  margin-bottom: 2rem;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
  font-weight: bold;
  color: #F17E22;
}

nav {
  margin-top: 2rem;
}

.nav-link {
  display: inline-block;
  padding: 0.5rem 1rem;
  font-size: 1.2rem;
  text-decoration: none;
  color: #333;
  border-radius: 4px;
  background-color: #F7AC70;
  transition: background-color 0.3s ease;
}

.nav-link:hover {
  background-color: #F17E22;
}

@media (min-width: 1024px) {
  .header {
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
  }

  .logo-container {
    margin-bottom: 0;
  }

  .title {
    text-align: left;
    margin-bottom: 0;
  }

  nav {
    margin-top: 0;
  }

  .nav-link {
    margin-left: 1rem;
  }
}
</style>
