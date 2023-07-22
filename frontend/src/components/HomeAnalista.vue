<template>
    <div class="Historial">
      <h1>Tickets</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Descripción</th>
            <th>Estado</th>
            <th>Acciones</th> <!-- Agregamos una columna para las acciones -->
          </tr>
        </thead>
        <tbody>
          <tr v-for="ticket in tickets" :key="ticket.id">
            <td>{{ ticket.id }}</td>
            <td>{{ ticket.descripcion }}</td>
            <td>{{ ticket.estado }}</td>
            <td>
              <button @click="revisarTicket(ticket.id)">Revisar</button>
              <button @click="responderTicket(ticket.id)">Responder</button>
              <button @click="eliminarTicket(ticket.id)">Eliminar</button>
            </td>
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
    methods: {
      revisarTicket(ticketId) {
        // Lógica para revisar el ticket con el ID dado
        console.log(`Revisando ticket con ID: ${ticketId}`);
      },
      responderTicket(ticketId) {
        // Lógica para responder al ticket con el ID dado
        console.log(`Respondiendo al ticket con ID: ${ticketId}`);
      },
      eliminarTicket(ticketId) {
        // Lógica para eliminar el ticket con el ID dado
        console.log(`Eliminando ticket con ID: ${ticketId}`);
      },
    },
  };
  </script>
  
  <style scoped>
  .Historial {
    display: flex;
    justify-content: center;
    padding: 100px;
    
    display: flex;
    flex-direction: column;
    align-items: center;
    
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
    width: 460px;
    align-items: center;
    height: 100px;
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
  
  /* Estilos para los botones de acción */
  button {
    padding: 0.5rem 1rem;
    font-size: 1rem;
    font-weight: bold;
    color: #F17E22;
    background-color: var(--color-background-light);
    border: 2px solid var(--color-border);
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    margin-right: 0.5rem;

  }
  
  button:hover {
    background-color: #00A9A0;
  }
  
  </style>
  