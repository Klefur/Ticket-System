<template>
  <div class="screen-height">
    <label for="nombre"> Nombre: </label>
    <input type="text" id="nombre" v-model="nombre">

    <label for="apellido"> Apellido: </label>
    <input type="text" id="apellido" v-model="apellido">

    <label for="rut"> Rut: </label>
    <input type="text" id="rut" v-model="rut">
    <p v-if="!isRutValid" class="invalid-rut">Ingresa un RUT válido</p>

    <label for="correo"> Correo: </label>
    <input type="text" id="correo" v-model="email">
    <p v-if="!isEmailValid" class="invalid-email">Ingresa un correo válido</p>

    <label for="password"> Contraseña: </label>
    <input type="password" id="password" v-model="password">

    <button :disabled="!allFieldsValid" @click="register">Crear Cuenta</button>
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
.screen-height {
  height: 86vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  color: black;
}
</style>