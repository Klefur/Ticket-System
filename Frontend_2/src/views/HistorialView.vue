<template>
    <div class="Historial">
      <h1>Historial de Tickets</h1>
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
            <td>{{ ticket.descripcion }}</td>
            <td>{{ ticket.estado }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        tickets: [
          { id: 1, descripcion: 'Ticket 1', estado: 'Abierto' },
          { id: 2, descripcion: 'Ticket 2', estado: 'En progreso' },
          { id: 3, descripcion: 'Ticket 3', estado: 'Cerrado' },
          // Agrega más tickets según tus necesidades
        ],
      };
    },
  };
  </script>
  
  <style scoped>
  .Historial {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center; /* Centrar verticalmente */
    height: 100vh;
    width: 700px;
    margin: 0 auto; /* Centrar horizontalmente */
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
  