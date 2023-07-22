import { createRouter, createWebHistory } from 'vue-router'
import vistajefe from '../views/vistajefe.vue'
import vistausuario from '../views/vistausuario.vue'
import vistaanalista from '../views/vistaanalista.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/Asignar',
      name: 'Asignar',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AsignarView.vue')
    },
    
    {
      path: '/CrearTicket',
      name: 'CrearTicket',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/CrearTicketView.vue')
    },
    {
      path: '/Historial',
      name: 'Historial',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/HistorialView.vue')
    },
    {
      path: '/vistajefe', // Ruta hacia la vista "vistajefe.vue"
      name: 'VistaJefe', // Nombre de la ruta
      component: vistajefe // Componente de la vista "vistajefe.vue"
    },
    {
      path: '/vistausuario', 
      name: 'vistausuario', 
      component: vistausuario 
    },
    {
      path: '/vistaanalista', 
      name: 'vistaanalista', 
      component: vistaanalista
    }
  ]
})

export default router
