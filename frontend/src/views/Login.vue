<template>
    <div>
        <div class="login-form">
          <h1 class="login-title">Iniciar Sesión</h1>
          <input v-model="mail" class="login-input" placeholder="Correo" />
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

    console.log(data)

    const user = await http.post("/usuario/login", data)
      .then((response) => {
        return response.data;
      })

    console.log(user)

    if (user) {
      localStorage.setItem('is_logged', true)
      localStorage.setItem('user', JSON.stringify(user))
      router.push("/home");
    }
    else {
        alert('correo o contraseña incorrectos')
    }
}
</script>

<style>
/* Estilos del formulario de inicio de sesión */

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
  margin-bottom: 20px;
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
</style>
