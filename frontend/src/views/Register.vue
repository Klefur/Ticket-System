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
import { ref, computed, useRouter } from 'vue'
import http from '../http-common';

const router = useRouter()

const nombre = ref('')
const apellido = ref('')
const rut = ref('')
const email = ref('')
const password = ref('')

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

const isEmailValid = computed(() => {
  // Verifica si el correo electrónico tiene un formato válido
  return validateEmail(email.value)
})

const isRutValid = computed(() => {
  // Verifica si el RUT tiene un formato válido
  return validateRut(rut.value)
})

const allFieldsValid = computed(() => {
    // Verifica si todos los campos están llenos y son válidos
    return isEmailValid.value && isRutValid.value && nombre.value !== '' && apellido.value !== '' && password.value !== ''
})

const register = async () => {
    const user = {
        nombre: nombre.value,
        apellido: apellido.value,
        rut: rut.value,
        correo: email.value,
        clave: password.value
    }

    await http.post('/usuario', user)
            .then((response) => {
                console.log(response.data)
                return response.data
            })
            .catch((error) => {
                console.log(error)
            })

    const postedUser = await http.get(`/usuario/correo/${user.email}`)
            .then((response) => {
                return response.data
            })
            .catch((error) => {
                console.log(error)
            })

    if (postedUser) {
      localStorage.setItem('is_logged', true)
      localStorage.setItem('user', JSON.stringify(postedUser))
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