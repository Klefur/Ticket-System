<template>
    <div class="Historial">
      <h1>Historial de Tickets</h1>
      <div class="table">
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Descripción</th>
              <th>Estado</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="ticket in tickets" :key="ticket.id">
              <td>{{ ticket.id }}</td>
              <td>{{ ticket.asunto }}</td>
              <td>{{ ticket.estado.nombre }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </template>
  
<script setup>
  import http from '../http-common';
  import { ref, onMounted } from 'vue';

  const tickets = ref();

  const getTickets = async () => {
    const user = JSON.parse(localStorage.getItem('user'))
    const tickets = await http.get(`/ticket/rut/${user.rut}`)
      .then((response) => {
        return response.data;
      })
    console.log(tickets)
    return tickets
  }

  onMounted(async () => {
    tickets.value = await getTickets()
  })

</script>
  
  <style scoped>
  .Historial {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center; /* Centrar verticalmente */
    height: 86vh;
    margin: 0 auto; /* Centrar horizontalmente */
    padding: 10vh, 10vh, 10vh ,10vh;
  }

  .table {
    width: 40%;
    border-collapse: collapse;
    background-color: #F0F0F0;
    border: 1px solid #00A9A0;
    color: #000000;
  }
  
  h1 {
    font-size: 2rem;
    font-weight: bold;
    margin-bottom: 1rem;
    color: #F17E22;
    font-family: "Bebas Neue Pro", Arial, sans-serif;
    letter-spacing: -1px;
    margin-top: 1.5rem;
  }
  
  table {
    width: 100%;
    border-collapse: collapse;
    background-color: #F0F0F0;
    border: 2px solid #00A9A0;
  }
  
  th,
  td {
    padding: 0.5rem;
    border-bottom: 1px solid var(--color-border);
  }
  
  th {
    font-weight: bold;
    text-align: left;
  }
  
  tbody tr:nth-child(even) {
    background-color: var(--color-background-lighter);
  }
  </style>
  