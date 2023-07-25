<template>
  <div class="screen-height">
    <div class="login-form">
      <h1 class="login-title">Iniciar Sesión</h1>
      <p class="input-label"> Correo: </p>
      <input v-model="mail" class="login-input" placeholder="Correo" />
      <p class="input-label"> Contraseña: </p>
      <input v-model="password" type="password" class="login-input" placeholder="Contraseña" />
      <button :disabled="!isLoginFormValid" @click="redirectToHome" class="login-button">Iniciar Sesión</button>
      <a href="/register">No estas registrado? Registrate!</a>
    </div>
  </div>
</template>

<script setup>
import http from "../http-common";
import { ref, computed } from "vue";
import { useRouter } from "vue-router";
import { store } from "../store";

const router = useRouter();

const mail = ref("");
const password = ref("");

const isLoginFormValid = computed(() => {
  return (
    mail.value.trim() !== "" &&
    password.value.trim() !== ""
  );
});

const redirectToHome = async () => {
  const data = {
    correo: mail.value,
    clave: password.value
  }

  const { data: user } = await http.post("/usuario/login", data)

  

  if (user) {
    store.isLogged = true;
    store.user = user;

    console.log(user, store)

    router.push("/home");
  }
  else {
    alert('correo o contraseña incorrectos')
  }
}
</script>

<style>
/* Estilos del formulario de inicio de sesión */
.screen-height {
  height: 86vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.login-form {
  padding: 20px;
  width: 600px;
  justify-content: center;
  align-items: center;
  background-color: #c9e8e6;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.login-title {
  font-size: 2rem;
  font-weight: bold;
  color: #f17e22;
  text-align: center;
}

.login-input {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
  margin-bottom: 10px;
}

.login-select {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
  margin-bottom: 10px;
  background-color: #f0f0f0;
}

.login-button {
  width: 100%;
  padding: 10px;
  font-size: 18px;
  font-weight: bold;
  color: #f17e22;
  background-color: #95d5d3;
  border: 2px solid #00a9a0;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.login-button:hover {
  background-color: #00a9a0;
}

.input-label  {
  color: #f17e22;
}
</style>
