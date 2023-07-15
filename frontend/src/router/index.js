import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CrearTicketView from '../views/CrearTicketView.vue'
import AreasView from '../views/AreasView.vue'
import AsignarAnalistaView from '../views/AsignarAnalistaView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/Areas',
      name: 'Areas',
      component: AreasView
    },
    {
      path: '/CrearTicket',
      name: 'CrearTicket',
      component: CrearTicketView
    },
    {
      path: '/AsignarAnalista',
      name: 'AsignarAnalista',
      component: AsignarAnalistaView
    }
  ]
})

export default router
