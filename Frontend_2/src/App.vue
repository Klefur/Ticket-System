<template>
  <div class="login-container">
    
    <!-- Formulario de inicio de sesión -->
    <div v-if="!isLoggedIn" class="login-form">
      <h1 class="login-title">Iniciar Sesión</h1>
      <input v-model="username" class="login-input" placeholder="Nombre de usuario" />
      <input v-model="password" type="password" class="login-input" placeholder="Contraseña" />
      <select v-model="userRole" class="login-select">
        <option value="usuario">Usuario</option>
        <option value="jefe">Jefe</option>
        <option value="analista">Analista</option>
      </select>
      <button :disabled="!isLoginFormValid" @click="redirectToHome" class="login-button">Iniciar Sesión</button>
    </div>

    <!-- Redirección a home según el rol -->
    <div v-else>
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      password: "",
      isLoggedIn: false,
      userRole: "usuario", // Valor predeterminado seleccionado en la lista desplegable
    };
  },
  computed: {
    isLoginFormValid() {
      return (
        this.username.trim() !== "" &&
        this.password.trim() !== "" &&
        this.userRole !== ""
      );
    },
  },
  methods: {
    redirectToHome() {
      // Redireccionar al home correspondiente según el rol del usuario
      switch (this.userRole) {
        case "usuario":
          this.$router.push("/vistausuario");
          break;
        case "jefe":
          this.$router.push("/vistajefe");
          break;
        case "analista":
          this.$router.push("/vistaanalista");
          break;
        default:
          break;
      }
      this.isLoggedIn = true;
    },
  },
};
</script>

<style>
/* Estilos del formulario de inicio de sesión */
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  padding: 300px;
  background-color: #f9f9f9;
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
