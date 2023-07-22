<template>
    <div class="Asignar">
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
                <td>{{ ticket.descripcion }}</td>
                <td>{{ ticket.estado }}</td>
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
                <td>{{ analista.especialidad }}</td>
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
          <p class="selected-ticket" v-if="selectedTicket">Ticket seleccionado: {{ selectedTicket.descripcion }}</p>
          <p class="selected-analista" v-if="selectedAnalista">Analista seleccionado: {{ selectedAnalista.nombre }}</p>
        </div>
        
        <div class="form-group">
      <label for="Prioridad">Asignar Prioridad:</label>
      <select id="Prioridad" v-model="prioridad">
        <option value="">Selecciona un Prioridad</option>
        <option value="baja">baja</option>
        <option value="media">media</option>
        <option value="alta">alta</option>
        <!-- Agrega más opciones según tus necesidades -->
      </select>
    </div>

        <button class="assign-button" :disabled="!selectedTicket || !selectedAnalista || assignedTicket" @click="assignAnalyst">
          Asignar
        </button>

        
  
        <p v-if="assignedTicket" class="notification">Se logró asignar correctamente un analista al ticket.</p>
      </div>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue'
  
  export default {
    data() {
      return {
        tickets: [
          { id: 1, descripcion: 'Ticket 1', estado: 'Abierto' },
          { id: 2, descripcion: 'Ticket 2', estado: 'En progreso' },
          { id: 3, descripcion: 'Ticket 3', estado: 'Cerrado' },
        ],
        analistas: [
          { id: 1, nombre: 'Analista 1', especialidad: 'Especialidad 1' },
          { id: 2, nombre: 'Analista 2', especialidad: 'Especialidad 2' },
          { id: 3, nombre: 'Analista 3', especialidad: 'Especialidad 3' },
        ],
        selectedTicket: null,
        selectedAnalista: null,
        assignedTicket: false,
        prioridad:'',
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
        if (this.prioridad) {
        console.log(`Asignando el ticket "${this.selectedTicket.descripcion}" al analista "${this.selectedAnalista.nombre}" con prioridad "${this.prioridad}"`);
        this.assignedTicket = true;
      } else {
        alert('Debes seleccionar una prioridad antes de asignar el ticket.');
      }
      },
    },
  }
  </script>
  
  <style scoped>


.form-group {
    margin-bottom: 1rem;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
  }

  label {
    font-size: 1.2rem;
    font-weight: bold;
    color: #F17E22;
    margin-bottom: 0.5rem;
  }

  select {
    width: 100%;
    padding: 0.5rem;
    font-size: 1rem;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  /* Estilos para el botón de asignación de prioridad */
  .priority-button {
    padding: 0.5rem 1rem;
    font-size: 1.2rem;
    font-weight: bold;
    color: #F17E22;
    background-color: #95D5D3;
    border: 2px solid var(--color-border);
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    margin-bottom: 1rem;
  }

  .priority-button:hover {
    background-color: #00A9A0;
  }

  /* Estilos para la lista de opciones de prioridad */
  .priority-options {
    list-style: none;
    padding: 0;
    margin: 0;
    position: absolute;
    background-color: #fff;
    border: 2px solid #00A9A0;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    z-index: 1;
    width: 140px;
    text-align: center;
    display: flex;
    flex-direction: column;
    right: 4.5rem; /* Alineación a la derecha con respecto al botón "Asignar Prioridad" */
  }

  .priority-options li {
    padding: 0.5rem;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }

  .priority-options li:hover {
    background-color: #f0f0f0;
  }


  input[type="text"],
  textprioridad {
  width: 100%;
  padding: 0.5rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
  }

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
    height: 600px;
    max-width: 900px;
    margin: 0 auto;
    padding: 2rem;
    background-color: #C9E8E6;
    border-radius: 4px;
    border: 2px solid #00A9A0;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  .table-section {
    color:#394650;
    width:600px;
    font-family: "Bebas Neue Pro", Arial, sans-serif;
    margin-bottom: 2rem;
  }
  
  .section-title {
    font-size: 1.3rem;
    font-weight: bold;
    margin-bottom: 1rem;
    color: #F17E22;
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
  