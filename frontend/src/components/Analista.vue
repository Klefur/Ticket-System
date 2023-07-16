<template>
    <div class="assignment-page">
      <h1 class="page-title">ASIGNACIÓN DE ANALISTA</h1>
  
      <div class="content-container">
        <div class="table-section">
          <h2 class="section-title">Tickets</h2>
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Descripción</th>
                <th>Estado</th>
                <th>Seleccionar</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="ticket in tickets" :key="ticket.id">
                <td>{{ ticket.id }}</td>
                <td>{{ ticket.asunto }}</td>
                <td>{{ ticket.estado?.nombre }}</td>
                <td>
                  <button
                    class="select-button"
                    @click="selectTicket(ticket)"
                    :disabled="selectedTicket || assignedTicket"
                  >
                    Seleccionar
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
  
        <div class="table-section">
          <h2 class="section-title">Analistas</h2>
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Especialidad</th>
                <th>Seleccionar</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="analista in analistas" :key="analista.id">
                <td>{{ analista.id }}</td>
                <td>{{ analista.nombre }}</td>
                <td>{{ analista.area.nombre }}</td>
                <td>
                  <button
                    class="select-button"
                    @click="selectAnalista(analista)"
                    :disabled="selectedAnalista || assignedTicket"
                  >
                    Seleccionar
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
  
        <div class="selected-options">
          <p class="selected-ticket" v-if="selectedTicket">Ticket seleccionado: {{ selectedTicket.asunto }}</p>
          <p class="selected-analista" v-if="selectedAnalista">Analista seleccionado: {{ selectedAnalista.nombre }}</p>
        </div>
  
        <button class="assign-button" :disabled="!selectedTicket || !selectedAnalista || assignedTicket" @click="assignAnalyst">
          Asignar
        </button>
  
        <p v-if="assignedTicket" class="notification">Se logró asignar correctamente un analista al ticket.</p>
      </div>
    </div>
  </template>
  
  <script>
  import UsuarioService from '../services/UsuarioService';
  import TicketService from '../services/TicketService';

  const analistas = async () => {
    const response = await UsuarioService.getArea(1);
    return response.data;
  };

  const tickets = async () => {
    const response = await TicketService.getAll();
    return response.data;
  };
  let response = await analistas();
  console.log({"person": "analistas", response});
  let response2 = await tickets();
  console.log({"person": "tickets", response2});

  
  export default {
    data() {
      return {
        tickets: response2,
        analistas: response,
        selectedTicket: null,
        selectedAnalista: null,
        assignedTicket: false,
      }
    },
    methods: {
      selectTicket(ticket) {
        this.selectedTicket = ticket
      },
      selectAnalista(analista) {
        this.selectedAnalista = analista
      },
      assignAnalyst() {
        console.log(`Asignando el ticket "${this.selectedTicket.descripcion}" al analista "${this.selectedAnalista.nombre}"`)
        this.assignedTicket = true
      },
    },
  }
  </script>
  
  <style scoped>
  .assignment-page {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-color: #F9F9F9;
  }
  
  .page-title {
    font-size: 2rem;
    font-weight: bold;
    margin-bottom: 1rem;
    color: #F17E22;
    font-family: "Bebas Neue Pro", Arial, sans-serif;
    letter-spacing: -1px;
    margin-top: 1.5rem;
  }
  
  .content-container {
    width: 100%;
    max-width: 1280px;
    margin: 0 auto;
    padding: 2rem;
    background-color: #C9E8E6;
    border-radius: 4px;
    border: 2px solid #00A9A0;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  .table-section {
    color:#394650;
    font-family: "Bebas Neue Pro", Arial, sans-serif;
    margin-bottom: 2rem;
  }
  
  .section-title {
    font-size: 1.5rem;
    font-weight: bold;
    margin-bottom: 1rem;
    color: #F17E22;;
  }
  
  .assign-button {
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
  
  .assign-button:hover {
    background-color: #00A9A0;
  }
  
  .select-button {
    padding: 0.5rem 1rem;
    font-size: 1rem;
    font-weight: bold;
    color: #F17E22;
    background-color: var(--color-background-light);
    border: 2px solid var(--color-border);
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  
  .select-button:hover {
    background-color: #00A9A0;
    
  }
  
  .selected-options {
    margin-top: 2rem;
  }
  
  .selected-ticket,
  .selected-analista {
    font-size: 1rem;
    margin-bottom: 0.5rem;
  }
  
  .notification {
    font-size: 1rem;
    margin-top: 1rem;
    font-family: "Bebas Neue Pro", Arial, sans-serif;
    color: #F17E22;
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
  
  button:disabled {
    opacity: 0.5;
    cursor: not-allowed;
  }
  </style>
  