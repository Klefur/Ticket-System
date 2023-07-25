<template>
  <div class="screen-height">
    <div class="login-form">
      <h1 class="login-title">Regístrate</h1>
  
      <p class="input-label"> Nombre: </p>
      <input v-model="nombre" class="login-input" placeholder="Nombre" type="text"/>
      <p class="input-label"> Apellido: </p>
      <input v-model="apellido" class="login-input" placeholder="Apellido" type="text"/>
      
      <p class="input-label"> Rut: </p>
      <p v-if="!isRutValid" class="invalid-rut"> Ingresa un RUT válido</p>
      <input v-model="rut" class="login-input" placeholder="Rut" type="text"/>
      
      <p class="input-label"> Correo: </p>
      <p v-if="!isEmailValid" class="invalid-email"> Ingresa un correo válido</p>
      <input v-model="email" class="login-input" placeholder="Correo" type="email"/>
      
      <p class="input-label"> Contraseña: </p>
      <input v-model="password" class="login-input" placeholder="Contraseña" type="password"/>
      
      <button :disabled="!allFieldsValid" @click="register" class="login-button">Crear Cuenta</button>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
import http from '../http-common';
import { store } from '../store'

const router = useRouter()

const nombre = ref('')
const apellido = ref('')
const rut = ref('')
const email = ref('')
const password = ref('')

const isEmailValid = computed(() => {
  // Verifica si el correo electrónico tiene un formato válido
  return validateEmail(email.value)
})

const isRutValid = computed(() => {
  // Verifica si el RUT tiene un formato válido
  return validateRut(rut.value)
})

const validateEmail = (email) => {
  // Implementa tu lógica de validación del correo electrónico aquí
  // Puedes usar expresiones regulares u otras técnicas para validar el formato del correo
  // Retorna true si el correo es válido, o false en caso contrario
  // Aquí se utiliza una expresión regular básica para verificar que el correo tenga un formato mínimo
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
  return emailRegex.test(email)
}

const validateRut = (rut) => {
  // Implementa tu lógica de validación del RUT aquí
  // Puedes usar expresiones regulares u otras técnicas para validar el formato del RUT
  // Retorna true si el RUT es válido, o false en caso contrario

  const rutRegex = /^(\d{1,3}\.\d{3}\.\d{3}-\d{1}|\d{1,3}\.\d{3}\.\d{1}-\d{1}|\d{1,3}\.\d{3}-\d{1}|\d{1,3}-\d{1}|\d{1,3}\.\d{3}\.\d{3}-[0-9kK]{1})$/
  return rutRegex.test(rut)
}

const allFieldsValid = computed(() => {
  // Verifica si todos los campos están llenos y son válidos
  return isEmailValid.value && isRutValid.value && nombre.value !== '' && apellido.value !== '' && password.value !== ''
})

const register = async () => {
  const postUser = {
    nombre: nombre.value,
    apellido: apellido.value,
    rut: rut.value,
    correo: email.value,
    clave: password.value
  }

  const { data: posted } = await http.post('/usuario', postUser)

  postUser.rol = { id: 1, nombre: 'usuario' }

  if (posted) {

    store.user = postUser
    store.isLogged = true

    router.push("/home");
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

.invalid-email  {
  color: #C8102E;
}
.invalid-rut  {
  color: #C8102E;
}
.input-label  {
  color: #f17e22;
}
</style>
