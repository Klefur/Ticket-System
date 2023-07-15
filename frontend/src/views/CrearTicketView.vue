<template>
  <div class="CrearTicket">
    <h1 class="title">CREACIÓN DE TICKET</h1>

    <div class="form-group">
      <label for="email">Coloca tu correo:</label>
      <input id="email" type="text" v-model="email" placeholder="Escribe tu correo aquí" />
      <p v-if="!isEmailValid" class="invalid-email">Ingresa un correo válido</p>
    </div>

    <div class="form-group">
      <label for="rut">Coloque su RUT :</label>
      <input id="rut" type="text" v-model="rut" placeholder="Escribe tu RUT aquí" />
      <p v-if="!isRutValid" class="invalid-rut">Ingresa un RUT válido</p>
    </div>

    <div class="form-group">
      <label for="subject">Asunto:</label>
      <textarea id="subject" v-model="subject" placeholder="Escribe el asunto aquí"></textarea>
      <p v-if="!isSubjectValid" class="invalid-subject">Describa el asunto del ticket</p>
    </div>

    <div class="form-group">
      <label for="area">Asignar Área:</label>
      <select id="area" v-model="area">
        <option value="">Selecciona un área</option>
        <option value="educacion">Educación</option>
        <option value="salud">Salud</option>
        <!-- Agrega más opciones según tus necesidades -->
      </select>
    </div>

    <!-- Botón agregado -->
    <button class="submit-button" :disabled="!areAllFieldsFilled" @click="submitForm">Enviar ticket</button>

    <!-- Notificación -->
    <p v-if="ticketCreated" class="notification">Ticket creado con éxito</p>



  </div>
</template>

<script setup>
import { ref, computed } from 'vue'

const email = ref('')
const rut = ref('')
const subject = ref('')
const area = ref('')

const isEmailValid = computed(() => {
  // Verifica si el correo electrónico tiene un formato válido
  return validateEmail(email.value)
})

const isRutValid = computed(() => {
  // Verifica si el RUT tiene un formato válido
  return validateRut(rut.value)
})

const isSubjectValid = computed(() => {
  // Verifica si el campo de asunto tiene al menos 5 caracteres
  return subject.value.trim().length > 5
})

const areAllFieldsFilled = computed(() => {
  // Verifica si todos los campos están llenos y son válidos
  return isEmailValid.value && isRutValid.value && isSubjectValid.value && area.value !== ''
})

// Variable para la notificación
const ticketCreated = ref(false)

function validateEmail(email) {
  // Implementa tu lógica de validación del correo electrónico aquí
  // Puedes usar expresiones regulares u otras técnicas para validar el formato del correo
  // Retorna true si el correo es válido, o false en caso contrario
  // Aquí se utiliza una expresión regular básica para verificar que el correo tenga un formato mínimo
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
  return emailRegex.test(email)
}

function validateRut(rut) {
  // Implementa tu lógica de validación del RUT aquí
  // Puedes usar expresiones regulares u otras técnicas para validar el formato del RUT
  // Retorna true si el RUT es válido, o false en caso contrario
  
  const rutRegex = /^(\d{1,3}\.\d{3}\.\d{3}-\d{1}|\d{1,3}\.\d{3}\.\d{1}-\d{1}|\d{1,3}\.\d{3}-\d{1}|\d{1,3}-\d{1}|\d{1,3}\.\d{3}\.\d{3}-[0-9kK]{1})$/
  return rutRegex.test(rut)
}

function submitForm() {
  // Lógica para enviar el formulario
  if (areAllFieldsFilled.value) {
    console.log(`Ticket creado con éxito`)
    ticketCreated.value = true
  } else {
    console.log(`Ingresa un correo, RUT válido, un asunto y selecciona un área`)
  }
}
</script>

<style>
/* Estilos adicionales para la página AboutView, si es necesario */
.about {
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
}

.notification {
  font-size: 1rem;
  margin-top: 1rem;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
  color: #F17E22;
}

.submit-button {
    padding: 0.5rem 1rem;
    font-size: 1.2rem;
    font-weight: bold;
    color: #F17E22;
    background-color: #95D5D3;
    border: 2px solid var(--color-border);
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}
.submit-button:hover {
  background-color: #00A9A0;
}
.CrearTicket {
  background-color: #F9F9F9;  
  padding: 2rem;
}

.title {
  font-size: 2rem;
  font-weight: bold;
  margin-bottom: 1rem;
  color: #F17E22;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
  margin-bottom: 1.5rem;
  letter-spacing: -1px;
  text-align: center;
  background-color: #F9F9F9;  
}
#email::placeholder {
  color: #394650;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
}
#rut::placeholder {
  color: #394650;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
}
#subject::placeholder {
  color: #394650;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
}
#area::placeholder {
  color: #394650;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
}

.form-group {
  margin-bottom: 2rem;
  background-color: #C9E8E6;
  padding: 1rem;
  border-radius: 4px;
  border: 2px solid #00A9A0; 
  color:#394650;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
  justify-content: center;

}

label {
  display: block;
  font-weight: bold;
  margin-bottom: 0.5rem;
}

input[type="text"],
textarea {
  width: 100%;
  padding: 0.5rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.valid-rut {
  margin-top: 0.5rem;
  color: #394650;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
}

.invalid-rut {
  margin-top: 0.5rem;
  color: #394650;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
}

.invalid-email {
  margin-top: 0.5rem;
  color: #394650;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
}

.invalid-subject {
  margin-top: 0.5rem;
  color: #394650;
  font-family: "Bebas Neue Pro", Arial, sans-serif;
}

select {
  width: 100%;
  padding: 0.5rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

</style>